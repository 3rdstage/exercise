package thirdstage.exercise.spark.streaming.apache

import java.util.regex.Pattern
import java.util.regex.Matcher

class LogAnalyzer extends Serializable{


  def transformLogData(line : String) : Map[String, String] = {

    val pattern = """^(\S+) (\S+) (\S+) \[([\w:/]+\s[+\-]\d{4})\] "(\S+) (\S+) (\S+)" (\d{3}) (\S+)"""
    val matcher = Pattern.compile(pattern).matcher(line)


    if(!matcher.find()){
      throw new IllegalArgumentException("Cannot parse the specified string : " + line)
    }

    createDataMap(matcher)
  }

  private def createDataMap(m:Matcher) = {
    Map("IP" -> m.group(1), "client" -> m.group(2), "user" -> m.group(3), "date" -> m.group(4), "method" -> m.group(5), "request" -> m.group(6),
        "protocol" -> m.group(7), "respCode" -> m.group(8), "size" -> m.group(9))
  }


}