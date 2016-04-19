package thirdstage.exercise.akka.wordstats3;

import javax.annotation.Nonnull;
import javax.validation.constraints.Min;
import org.slf4j.LoggerFactory;
import thirdstage.exercise.akka.wordstats.StatsMessages.StatsJob;
import thirdstage.exercise.akka.wordstats.StatsService;
import thirdstage.exercise.akka.wordstats.StatsWorker;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.server.Handler;
import akka.http.javadsl.server.HttpApp;
import akka.http.javadsl.server.RequestContext;
import akka.http.javadsl.server.Route;
import akka.http.javadsl.server.RouteResult;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


public class StatsHttpServer{

   public static final String CLUSTER_NAME_DEFAULT = "StatsCluster";

   private final int nettyPort;

   public int getNettyPort(){ return this.nettyPort; }

   private final int httpPort;

   public int getHttpPort(){ return this.httpPort; }

   private final String configSubtree;

   public String getConfigSubtree(){ return this.configSubtree; }

   private Config config;

   public StatsHttpServer(@Min(1) int nettyPort, @Min(1) int httpPort, String configSubtree){
      this.nettyPort = nettyPort;
      this.httpPort = httpPort;
      this.configSubtree = configSubtree;

   }

   public void start() throws Exception{

      this.config = ConfigFactory.load();
      this.config = this.config.getConfig(this.getConfigSubtree()).withFallback(this.config);
      this.config = ConfigFactory.parseString("akka.cluster.roles = [compute]").withFallback(config);

      ActorSystem system = ActorSystem.create(CLUSTER_NAME_DEFAULT,
            ConfigFactory.parseString("akka.remote.netty.tcp.port=" + this.getNettyPort()).withFallback(this.config));
      ActorRef worker = system.actorOf(Props.create(StatsWorker.class), "statsWorker");
      ActorRef service = system.actorOf(Props.create(StatsService.class), "statsService");

      new StatsHttpApp(system).bindRoute("localhost", 8080, system);
      System.out.println("Type return to exit");
      System.in.read();
      system.shutdown();
   }

   private static class StatsHttpApp extends HttpApp{

      private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

      private final ActorSystem system;

      public StatsHttpApp(@Nonnull ActorSystem system){
         this.system  = system;
      }

      @Override
      public Route createRoute(){

         return route(
               get(
                     path("test").route(handleWith(testHandler))
                     )
               );
      }

      private final Handler testHandler = new Handler(){
         private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

         @Override
         public RouteResult apply(RequestContext cntx){
            this.logger.debug("Received the {} request to {}", cntx.request().method().value(), cntx.request().getUri());

            ActorSelection service = system.actorSelection("/user/statsService");
            service.tell(new StatsJob("You're just good to be true"), service.anchor());

            return cntx.complete(String.format("This was a %s  request to %s",
                  cntx.request().method().value(), cntx.request().getUri()));
         }
      };


   }


}
