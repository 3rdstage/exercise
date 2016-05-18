package thirdstage.exercise.akka.wordanalysis;

import java.util.concurrent.TimeUnit;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import com.typesafe.config.Config;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.camel.Camel;
import akka.camel.CamelExtension;
import akka.util.Timeout;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

public class AnalysisClusterMaster extends ClusterNodeBase{

   public static final int MASTER_NODE_NETTY_PORT_DEFAULT = 2550;

   public static final int HTTP_PORT_DEFAULT = 8080;

   private final int httpPort;

   public int getHttpPort(){ return this.httpPort; }

   private String baseUrl;

   public String getBaseUrl(){ return this.baseUrl; }


   public AnalysisClusterMaster(@Pattern(regexp="[a-zA-Z0-9]+") String clusterName,
         @Pattern(regexp="[a-zA-Z0-9]+") String applName,
         @Min(1) @Max(0xFFFF) int nettyPort, @Min(1) @Max(0xFFFF) int httpPort,
         String configSubtree) throws Exception{
      super(clusterName, applName, nettyPort, configSubtree);
      this.httpPort = httpPort;
   }

   @Override
   public ActorSystem buildActorSystem(Config config) throws Exception{

      ActorSystem system = ActorSystem.create(this.getClusterName(), config);
      Camel camel = CamelExtension.get(system);

      this.baseUrl = "http://" + this.getAddress().getHostAddress() + ":"
            + this.getHttpPort() + "/" + this.getApplicationName();
      String uri = "jetty:" + this.baseUrl;

      ActorRef analysisService = system.actorOf(Props.create(AnalysisService.class), "analysisService");

      String pathBase = "akka.tcp://" + this.getClusterName() + "@" + this.getAddress().getHostAddress() + ":";
      SimpleRoutingMap<String> routingMap = new SimpleRoutingMap<String>();
      routingMap.put("1", pathBase + "2550/user/analysisService");
      routingMap.put("2", pathBase + "2551/user/analysisService");

      ActorRef httpClerk = system.actorOf(Props.create(WebService.class, uri, routingMap), "httpClerk");

      Future<ActorRef> activationFuture = camel.activationFutureFor(httpClerk,
            new Timeout(Duration.create(10, TimeUnit.SECONDS)), system.dispatcher());

      return system;
   }
}
