package thirdstage.exercise.spark.translate

import org.apache.spark.launcher.SparkLauncher
import com.google.common.collect.Maps
import java.util.HashMap

object TranslateAppLocalLauncher extends App {

   override def main(args: Array[String]){

      val env = new HashMap[String, String]()
      env.put("SPARK_PRINT_LAUNCH_COMMAND", "1");

      val spark = new SparkLauncher(env)
            .setSparkHome("C:/lang/spark-1.6.2")
            .setAppResource(System.getProperty("appl.spark.resource"))
            .setMainClass("thirdstage.exercise.spark.translate.TranslateApp")
            .setMaster("local[*]")
            .addSparkArg("--verbose")
            .setVerbose(true);

      //val process = spark.launch()
      spark.startApplication()

      System.out.println("Launched Spark Application")

      //process.waitFor()
   }

}