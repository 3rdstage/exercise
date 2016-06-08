package thirdstage.exercise.akka.wordanalysis.mappedrouter;

import java.net.InetAddress;
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

      String addr = InetAddress.getLocalHost().getHostAddress();

      Config config = ConfigFactory.load();
      config = config.getConfig("wordanalysis").withFallback(config);
      Config config2 = ConfigFactory.parseString("akka.cluster.roles = [compute]");
      config2 = ConfigFactory.parseString("akka.remote.netty.tcp.hostname=" + addr).withFallback(config2);
      config2 = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + 2551).withFallback(config2);
      config = config2.withFallback(config);

      KeyNodeMap<String> keyNodeMap = new SimpleKeyNodeMap<String>();
      keyNodeMap.putNodeId(new Key<String>("1"), "2551");
      keyNodeMap.putNodeId(new Key<String>("2"), "2552");
      keyNodeMap.putNodeId(new Key<String>("3"), "2551");
      keyNodeMap.putNodeId(new Key<String>("4"), "2552");

      ActorSystem system = ActorSystem.create("WordAnalysis", config);

      ActorRef routingActor = system.actorOf(Props.create(MappedRouterActor.class,
            keyNodeMap, "noService", new PortBaseNodeIdResolver()), "routingActor");

      System.out.println("The master node of Akka cluster has started.\n"
            + "Start worker node and then type retun key to proceed.");
      System.in.read();

      system.shutdown();

   }

}
