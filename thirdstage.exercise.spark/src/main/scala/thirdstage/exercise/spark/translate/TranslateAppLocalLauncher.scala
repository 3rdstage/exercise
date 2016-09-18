package thirdstage.exercise.spark.translate

import org.apache.spark.launcher.SparkLauncher

object TranslateAppLocalLauncher extends App {

   def main(args: Array[String]){

      val spark = new SparkLauncher();

      spark.setSparkHome(System.getProperty("appl.spark.home"))
      .setAppResource(System.getProperty("appl.spark.resource"))
      .setMainClass("thirdstage.exercise.spark.translate.TranslateApp")
      .setMaster("local[*]")
      .launch()

      spark.wait();
   }

}