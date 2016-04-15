package thirdstage.exercise.akka.wordstats2;

import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


public class StatsMasterMain{

   public static void main(String... args){



   }

   public static void startup(String[] ports){

      Config config = ConfigFactory.load();
      config = config.getConfig("wordstats").withFallback(config);
      config = ConfigFactory.parseString("akka.cluster.roles = [compute]").withFallback(config);


      for(String port : ports){
         ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port).withFallback(config);
         ActorSystem system = ActorSystem.create("ClusterSystem", config);

         //ClusterSingletonManagerSettings settings = ClusterSingletonManagerSettings.create(system).withRole("compute");

      }

   }


}
