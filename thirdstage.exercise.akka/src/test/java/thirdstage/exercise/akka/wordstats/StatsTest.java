package thirdstage.exercise.akka.wordstats;

import thirdstage.exercise.akka.wordstats.StatsMessages.StatsJob;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class StatsTest{

   public static void main(String[] args){
      if(args.length == 0){
         startup(new String[]{"2551", "2552", "0"});
      }else{
         startup(args);
      }
   }

   private static void startup(String[] ports){

      Config config = ConfigFactory.load();
      config = config.getConfig("wordstats").withFallback(config);
      config = ConfigFactory.parseString("akka.cluster.roles = [compute]").withFallback(config);


      for(String port : ports){
         ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port).withFallback(config);

         ActorSystem system = ActorSystem.create("WordStatsCluster", config);

         system.actorOf(Props.create(StatsWorker.class), "statsWorker");
         ActorRef service = system.actorOf(Props.create(StatsService.class), "statsService");

         service.tell(new StatsJob("She got a smile"), service);

      }


   }


}
