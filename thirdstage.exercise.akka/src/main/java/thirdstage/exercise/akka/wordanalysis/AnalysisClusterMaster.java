package thirdstage.exercise.akka.wordanalysis;

import java.util.concurrent.TimeUnit;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisURI;
import com.typesafe.config.Config;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.camel.Camel;
import akka.camel.CamelExtension;
import akka.util.Timeout;
import redis.embedded.RedisExecProvider;
import redis.embedded.RedisServer;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import thirdstage.exercise.akka.wordanalysis.mappedrouter.Key;
import thirdstage.exercise.akka.wordanalysis.mappedrouter.SimpleRoutingMap;

public class AnalysisClusterMaster extends ClusterNodeBase{

   public static final int MASTER_NODE_NETTY_PORT_DEFAULT = 2551;

   public static final int HTTP_PORT_DEFAULT = 8080;

   private final int httpPort;

   public int getHttpPort(){ return this.httpPort; }

   private String baseUrl;

   public String getBaseUrl(){ return this.baseUrl; }

   private RedisServer redis;

   private RedisClient redisClient;

   private final ObjectMapper jacksonMapper = new ObjectMapper();

   public AnalysisClusterMaster(@Pattern(regexp="[a-zA-Z0-9]+") String clusterName,
         @Pattern(regexp="[a-zA-Z0-9]+") String applName,
         @Min(1) @Max(0xFFFF) int nettyPort, @Min(1) @Max(0xFFFF) int httpPort,
         String configSubtree) throws Exception{
      super(clusterName, applName, nettyPort, configSubtree);
      this.httpPort = httpPort;

      this.jacksonMapper.registerModule(new JaxbAnnotationModule())
      .configure(MapperFeature.AUTO_DETECT_FIELDS, false)
      .configure(MapperFeature.AUTO_DETECT_CREATORS, false)
      .configure(MapperFeature.AUTO_DETECT_GETTERS, true)
      .configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true)
      .configure(MapperFeature.AUTO_DETECT_SETTERS, true);

   }

   @Override
   public ActorSystem buildActorSystem(Config config) throws Exception{

      //start redis
      final int redisPort = (config.hasPath("components.redis.port")) ? config.getInt("components.redis.port") : RedisURI.DEFAULT_REDIS_PORT;
      final String redisLogLevel = config.hasPath("components.redis.log-level") ? config.getString("components.redis.log-level") : "verbose";
      String logBase = System.getenv("LOG_BASE");
      if(StringUtils.isBlank(logBase)) logBase = System.getenv("TEMP");
      final String redisLogFile = config.hasPath("components.redis.log-file") ? config.getString("components.redis.log-file") : logBase + "\\redis.log";
      final String redisPidFile = config.hasPath("components.redis.pid-file") ? config.getString("components.redis.pid-file") : logBase + "\\redis.pid";

      try{
         this.redis = RedisServer.builder()
               .redisExecProvider(RedisExecProvider.defaultProvider())
               .port(redisPort)
               .setting("loglevel " + redisLogLevel)
               .setting("logfile " + redisLogFile)
               .setting("pidfile " + redisPidFile)
               .build();

         new Thread(){
            @Override
            public void run(){
               try{
                  redis.start();
                  logger.info("Started redis server on {} port", redisPort);
               }catch(Exception ex){
                  logger.error("Fail to start redis server.", ex);
               }
            }
         }.start();
      }catch(Exception ex){
         this.logger.error("Fail to start redis server.", ex);
      }

      //create redis client
      String redisUri = "redis://" + this.getAddress().getHostAddress() + ":" + redisPort + "/0";
      this.redisClient = new RedisClient(RedisURI.create(redisUri));

      ActorSystem system = ActorSystem.create(this.getClusterName(), config);
      Camel camel = CamelExtension.get(system);

      this.baseUrl = "http://" + this.getAddress().getHostAddress() + ":"
            + this.getHttpPort() + "/" + this.getApplicationName();
      String uri = "jetty:" + this.baseUrl;

      String recorderKeyBase = this.getClusterName() + ":" + "words";
      ActorRef recordingService = system.actorOf(Props.create(RecordingService.class,
            recorderKeyBase, this.redisClient), "recorderService");

      String tracerKey = this.getClusterName() + ":trace:node:1";
      ActorRef traceLogService = system.actorOf(Props.create(TraceLogService.class,
            tracerKey, this.redisClient, this.jacksonMapper), "traceLogService");

      ActorRef analysisService = system.actorOf(Props.create(AnalysisService.class,
            recordingService, traceLogService), "analysisService");

      String pathBase = "akka.tcp://" + this.getClusterName() + "@" + this.getAddress().getHostAddress() + ":";
      SimpleRoutingMap<String> routingMap = new SimpleRoutingMap<String>();
      routingMap.putPath(new Key<String>("1"), pathBase + "2550/user/analysisService");
      routingMap.putPath(new Key<String>("2"), pathBase + "2551/user/analysisService");

      ActorRef httpClerk = system.actorOf(Props.create(WebService.class, uri, routingMap), "httpClerk");

      Future<ActorRef> activationFuture = camel.activationFutureFor(httpClerk,
            new Timeout(Duration.create(10, TimeUnit.SECONDS)), system.dispatcher());

      return system;
   }

   @Override
   public void stopComponents(){

      if(this.redisClient != null){
         this.redisClient.shutdown();
      }

      try{
         new Thread(){
            @Override
            public void run(){
               if(redis != null){
                  redis.stop();
               }
            }
         }.start();
      }catch(Exception ex){
         logger.error("Fail to stop redis", ex);
      }
   }
}
