package thirdstage.exercise.spark.linkage

import org.scalatest.BeforeAndAfter
import org.zeroturnaround.zip.ZipUtil
import com.holdenkarau.spark.testing.SharedSparkContext
import org.scalatest.FunSuite
import org.apache.spark.rdd.RDD

class LinkageDataTest1 extends FunSuite with SharedSparkContext {

  var block1: RDD[String] = _

  override def beforeAll {
    super.beforeAll()

    val workDir = System.getProperty("workDir")
    if (workDir == null || workDir.isEmpty()) {
      throw new IllegalStateException("The 'workDir' should be provided at command-line")
    }

    val block1Csv = new java.io.File(workDir + raw"\block_1.csv")
    if (block1Csv.isDirectory()) {
      throw new IllegalStateException("The directory 'block_1.csv' exists!!, which is never expected.")
    }

    if (!block1Csv.exists()) {
      val dataDir = System.getProperty("dataDir")
      if (dataDir == null || dataDir.isEmpty()) {
        throw new IllegalStateException("The 'dataDir' should be provided at command-line")
      }
      val block1Zip = new java.io.File(dataDir + raw"\linkage\block_1.zip")

      ZipUtil.unpack(block1Zip, new java.io.File(workDir))
    }

    this.block1 = sc.textFile(block1Csv.getAbsolutePath)

  }

  test("The total rows of the block 1 is more than tens of thousands"){
    assert(this.block1.count() > 10000)
  }

  test("Taking just leading 10 rows from the block") {
    val head = this.block1.take(10)
    assert(head.length == 10)
  }

  test("The block 1 has just one header line"){
    val header = this.block1.filter(x => x.contains("id_1"))
    assert(header.count() == 1)
  }

  test("The 1st line of block is only header line"){

  }


}