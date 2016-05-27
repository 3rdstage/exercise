package thirdstage.exercise.akka.wordanalysis.mappedrouter;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import akka.actor.ActorSystem;

public class MappedRouterActorTest1Worker{

   public static void main(String[] args) throws Exception{
      Config config = ConfigFactory.load();
      config = config.getConfig("wordanalysis2").withFallback(config);
      config = ConfigFactory.parseString("akka.cluster.roles = [compute]").withFallback(config);
      config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + 2552).withFallback(config);

      ActorSystem system = ActorSystem.create("Node0", config);

      System.out.println("The master node of Akka cluster has started.\n"
            + "Type retun key to end this process.");
      System.in.read();

      system.shutdown();

   }

}
