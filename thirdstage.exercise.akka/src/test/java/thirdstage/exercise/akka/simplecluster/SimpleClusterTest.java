package thirdstage.exercise.akka.simplecluster;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import org.slf4j.MDC;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class SimpleClusterTest{

   public static void main(String... args){

      RuntimeMXBean mbean = ManagementFactory.getRuntimeMXBean();
      String name = mbean.getName();
      MDC.put("pid", name);

      if(args.length == 0){
         startup(new String[] {"2551", "2552", "0"});
      }else{
         startup(args);
      }
   }

   private static void startup(String... ports){
      Config config = ConfigFactory.load();
      config = config.getConfig("simplecluster").withFallback(config);

      for(String port : ports){
         ActorSystem system = ActorSystem.create("ClusterSystem",
               ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port).withFallback(config));

         system.actorOf(Props.create(SimpleClusterListener.class), "clusterListener");
      }
   }

}
