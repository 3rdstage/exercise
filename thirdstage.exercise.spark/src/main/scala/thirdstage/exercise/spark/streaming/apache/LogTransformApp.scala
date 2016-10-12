package thirdstage.exercise.spark.streaming.apache

import org.apache.spark.SparkConf
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.dstream.DStream
import org.slf4j.LoggerFactory

object LogTransformApp extends {

  private val logger = LoggerFactory.getLogger(this.getClass)

  def main(args: Array[String]) {

    val workDir = System.getProperty("workDir")
    logger.debug("The 'workDir' is : {}", workDir)

    if (workDir == null || workDir.isEmpty()) {
      throw new IllegalStateException("The 'workDir' should be provided at command-line")
    }

    val conf = new SparkConf()
    conf.setAppName("Apache Log Transformer")
    this.logger.info("Constructing Sparak streaming context")

    val analyzer = new LogAnalyzer()

    val cntx = new StreamingContext(conf, Seconds(10))
    val stream = cntx.textFileStream(workDir + "\\logs")
    val stream2 = stream.flatMap{x => analyzer.transformLogData(x) }

    transform(stream2, cntx)

    cntx.start()
    cntx.awaitTermination()

  }

  private def transform(stream:DStream[(String, String)], cntx:StreamingContext){
    logger.debug("Transforming map stream")

    val gets = stream.filter(x => x._1.equals("method") && x._2.contains("GET")).count().print()

    println("The number of GET requests is : " + gets)

  }

}