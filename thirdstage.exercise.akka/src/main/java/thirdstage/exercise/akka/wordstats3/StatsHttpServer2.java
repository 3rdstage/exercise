package thirdstage.exercise.akka.wordstats3;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.concurrent.TimeUnit;
import javax.validation.constraints.Min;
import org.slf4j.MDC;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.camel.Camel;
import akka.camel.CamelExtension;
import akka.util.Timeout;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import thirdstage.exercise.akka.wordstats.HttpConsumer;
import thirdstage.exercise.akka.wordstats.StatsService;
import thirdstage.exercise.akka.wordstats.StatsWorker;


public class StatsHttpServer2{

   public static final String ACTOR_SYSTEM_NAME_DEFAULT = "WordStats";

   public static final String APPL_NAME_DEFAULT = ACTOR_SYSTEM_NAME_DEFAULT.toLowerCase();

   private static String pid;

   public static void main(String[] args) throws Exception{
      RuntimeMXBean mbean = ManagementFactory.getRuntimeMXBean();
      pid = mbean.getName();
      if(pid != null && pid.length() > 0){
         if(pid.contains("@")) pid = pid.substring(0, pid.indexOf("@"));
      }
      MDC.put("pid", pid);


      if(args.length > 2 || args.length < 1){
         throw new IllegalArgumentException("One or two argument(s) is(are) expected.");
      }else if(args.length == 1){
         (new StatsHttpServer(Integer.valueOf(args[0]), -1, APPL_NAME_DEFAULT)).start();
      }else if(args.length == 2){
         (new StatsHttpServer(Integer.valueOf(args[0]), Integer.valueOf(args[1]), APPL_NAME_DEFAULT)).start();
      }
   }

   private final int[] nettyPorts;

   public int[] getNettyPorts(){ return this.nettyPorts; }

   private final int httpPort;

   public int getHttpPort(){ return this.httpPort; }

   private final String configSubtree;

   public String getConfigSubtree(){ return this.configSubtree; }

   private Config config;

   private ActorSystem[] systems;

   public StatsHttpServer2(@Min(1) int nettyPort, int httpPort, String configSubtree){
      int[] ports = new int[1];
      ports[0] = nettyPort;

      this.nettyPorts = ports;
      this.httpPort = httpPort;
      this.configSubtree = configSubtree;
   }

   public StatsHttpServer2(int[] nettyPorts, int httpPort, String configSubtree){
      this.nettyPorts = nettyPorts;
      this.httpPort = httpPort;
      this.configSubtree = configSubtree;
   }

   public void start() throws Exception{

      this.config = ConfigFactory.load();
      this.config = this.config.getConfig(this.getConfigSubtree()).withFallback(this.config);
      this.config = ConfigFactory.parseString("akka.cluster.roles = [compute]").withFallback(config);

      this.systems = new ActorSystem[this.nettyPorts.length];
      for(int i = 0, n = this.nettyPorts.length; i < n; i++){
         systems[i] = ActorSystem.create(ACTOR_SYSTEM_NAME_DEFAULT,
               ConfigFactory.parseString("akka.remote.netty.tcp.port=" + this.getNettyPorts()[i]).withFallback(this.config));
         ActorRef worker = systems[i].actorOf(Props.create(StatsWorker.class), "statsWorker");
         ActorRef service = systems[i].actorOf(Props.create(StatsService.class), "statsService");

         if(i == 0 && this.httpPort > 1){
            Camel camel = CamelExtension.get(systems[i]);
            ActorRef httpConsumer = systems[i].actorOf(Props.create(HttpConsumer.class, "127.0.0.1", httpPort, service), "httpConsumer");

            Future<ActorRef> activationFuture = camel.activationFutureFor(httpConsumer,
                  new Timeout(Duration.create(10, TimeUnit.SECONDS)), systems[i].dispatcher());
         };
      }

      System.out.println("Type return to exit");
      System.in.read();

      for(final ActorSystem system : this.systems){
         new Runnable(){
            @Override
            public void run(){ system.shutdown(); }
         }.run();
      }
   }


}
