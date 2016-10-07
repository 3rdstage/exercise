package thirdstage.exercise.spark.streaming.apache

import sys.process._
import org.apache.commons.io.FileUtils
import java.net.URL
import org.zeroturnaround.zip.ZipUtil
import org.slf4j.LoggerFactory
import java.io.FileReader

object SampleLogGenerator {

  private val logger = LoggerFactory.getLogger(this.getClass)

  def main(args: Array[String]) = {

    val workDir = System.getProperty("workDir")
    if (workDir == null || workDir.isEmpty()) {
      throw new IllegalStateException("The 'workDir' should be provided at command-line")
    }

    val dPath = workDir + raw"\error_log"
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

      logger.info("Start to unzip archive file {} to {}",  zfPath, workDir:Any)
      ZipUtil.unpack(zFile, new java.io.File(workDir))
      logger.info(raw"Completed unzipping archive file to {}\error_log and {}\access_log", workDir)
    }else{
      logger.info(raw"Sample data files ({}\error_log and {}\access_log) are already prepared at {}", workDir, workDir, workDir)
    }


    var in :java.io.BufferedReader = null
    var out :java.io.FileOutputStream = null
    try{
      if(args.length != 2){
        System.out.println("Usage - java SampleLogGenerator file1 file2")
        System.exit(0)
      }

      in = new java.io.BufferedReader(new FileReader(new java.io.File(args(0))))
      out = new java.io.FileOutputStream(new java.io.File(args(1)))
      var line:String = null
      while(true){
        line = in.readLine()
        if(line == null){
          in.close()
          in = new java.io.BufferedReader(new FileReader(new java.io.File(args(0))))
          line = in.readLine()
        }
        out.write((line + "\n").getBytes())
        out.flush()
        logger.info("Wrote a line to {}", args(1))
        Thread.sleep(500)
      }

    }catch {
      case ex:Exception => ex.printStackTrace(System.err)
    }finally{

      if(out != null){
        try{ out.close() }catch{ case ex:Exception => }
      }
      if(in != null){
        try{ in.close() }catch{ case ex:Exception => }
      }
    }
  }

}