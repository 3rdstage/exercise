package thirdstage.exercise.akka.wordanalysis;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class AnalysisClusterTestMaster {

   private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AnalysisClusterTestMaster.class);

   public static void main(String[] args) throws Exception{
      RuntimeMXBean mbean = ManagementFactory.getRuntimeMXBean();
      String pid = mbean.getName();
      if(pid != null && pid.length() > 0){
         if(pid.contains("@")) pid = pid.substring(0, pid.indexOf("@"));
      }
      MDC.put("pid", pid);

      try{
         AnalysisClusterMaster master = new AnalysisClusterMaster(
               "WordAnalysis", "wordanalysis", AnalysisClusterMaster.MASTER_NODE_NETTY_PORT_DEFAULT,
               AnalysisClusterMaster.HTTP_PORT_DEFAULT, "wordanalysis");

         master.setPID(pid);
         master.start(false);

      }catch(Exception ex){
         logger.error("Fail to run cluster master node.", ex);
         throw new RuntimeException("Fail to run cluster master node.", ex);
      }
   }

}
