package thirdstage.exercise.spark.streaming.apache

import sys.process._
import org.apache.commons.io.FileUtils
import java.net.URL
import org.zeroturnaround.zip.ZipUtil
import org.slf4j.LoggerFactory

object SampleLogGenerator {

  private val logger = LoggerFactory.getLogger(this.getClass)

  def main(args: Array[String]) = {

    val workDir = System.getProperty("workDir")
    if (workDir == null || workDir.isEmpty()) {
      throw new IllegalStateException("The 'workDir' should be provided at command-line")
    }

    val dPath = workDir + raw"\error-log"
    val dFile = new java.io.File(dPath)
    val zfPath = workDir + raw"\apache-samples.rar"  //Need to enhance the code in case when 'workDir' ends with path separator (slash or back-slash)
    val zFile = new java.io.File(zfPath)
    val url = "http://www.monitorware.com/en/logsamples/download/apache-samples.rar"

    if(!dFile.exists()){
      if(!zFile.exists()){
        FileUtils.forceMkdir(new java.io.File(workDir))
        logger.info("The archive file {} containing sample data file dosen't exist. Now the file will be downloaded from {}.", zfPath, url:Any)
        logger.info("Downloading {}", url:Any)
        new URL(url) #> zFile !!

        logger.info("Completed downloading {}.", url:Any)
      }


    }else{
      logger.info("Sample data file is already prepared at {}", dPath)
    }




  }

}