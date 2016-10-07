package thirdstage.exercise.spark.streaming.apache

import org.apache.spark.SparkConf
import org.slf4j.LoggerFactory
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds

object LogTransformApp extends App {

  private val logger = LoggerFactory.getLogger(this.getClass)

  def main(args:Array[String]){

        val workDir = System.getProperty("workDir")
    if (workDir == null || workDir.isEmpty()) {
      throw new IllegalStateException("The 'workDir' should be provided at command-line")
    }

    val conf = new SparkConf()
    conf.setAppName("Apache Log Transformer")
    this.logger.info("Constructing Sparak streaming context")

    val cntx = new StreamingContext(conf, Seconds(10))


  }
}