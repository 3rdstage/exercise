package thirdstage.exercise.scala.basic

import org.scalatest.FunSuite

class ForSuite extends FunSuite {


  test("For with if filtering"){

    for(i <- 1 to 100 if i % 3 == 0){
      println(i + " is multiple of 3")
    }

  }

  test("Listing files using for clasue"){

    val files = (new java.io.File(java.lang.System.getenv("windir"))).listFiles()

    println("Files under %windir% directory")
    for(file <- files) println(file)

  }

}