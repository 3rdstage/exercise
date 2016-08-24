package thirdstage.exercise.kafka;

import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;
import kafka.server.KafkaConfig;
import kafka.server.KafkaServerStartable;

public class KafkaServerSimpleTest{

   @Test
   public void testStartUp() throws Exception{
      final Properties props = new Properties();
      props.setProperty("host.name", "localhost");
      props.setProperty("port", "9090");
      props.setProperty("broker.id", "1");
      props.setProperty("log.dir", StringUtils.defaultIfBlank(System.getenv("TEMP"), System.getenv("TMP")));
      props.setProperty("zookeeper.connect", "127.0.0.1:2181");

      final KafkaConfig config = new KafkaConfig(props);

      final KafkaServerStartable server = new KafkaServerStartable(config);
      try{
         server.startup();
      }catch(Throwable ex){
         ex.printStackTrace(System.out);
      }

      System.out.println("Server started.");

      Runtime.getRuntime().addShutdownHook(new Thread(){

         @Override
         public void run(){
            server.awaitShutdown();
         }
      });


      System.out.println("Press [Enter] key to start.");
      int cnt;
      while((cnt = System.in.available()) < 1){
         Thread.sleep(500);
      }
      while(cnt-- > 0) System.in.read();

   }
}
