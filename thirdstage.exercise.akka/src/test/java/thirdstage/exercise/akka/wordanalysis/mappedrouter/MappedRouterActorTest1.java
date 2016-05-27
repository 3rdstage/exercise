package thirdstage.exercise.akka.wordanalysis.mappedrouter;

import org.testng.annotations.Test;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

@Test(singleThreaded=true)
public class MappedRouterActorTest1 {


   @Test
   public void testRun() throws Exception{

      Config config = ConfigFactory.load();
      config = config.getConfig("wordanalysis2").withFallback(config);
      config = ConfigFactory.parseString("akka.cluster.roles = [compute]").withFallback(config);
      config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + 2551).withFallback(config);

      ActorSystem system = ActorSystem.create("Node0", config);

      ActorRef routingActor = system.actorOf(Props.create(MappedRouterActor.class,
            null, "noService"), "routingActor");

      System.out.println("The master node of Akka cluster has started.\n"
            + "Start worker node and then type retun key to proceed.");
      System.in.read();

      system.shutdown();

   }

}
