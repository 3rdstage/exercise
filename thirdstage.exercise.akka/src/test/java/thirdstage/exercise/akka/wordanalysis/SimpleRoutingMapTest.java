package thirdstage.exercise.akka.wordanalysis;

import org.testng.annotations.Test;

public class SimpleRoutingMapTest {

   @Test
   public void testPut() {
      String pathBase = "akka.tcp://127.0.0.1@2550:";
      SimpleRoutingMap<String> routingMap = new SimpleRoutingMap<String>();
      routingMap.put("1", pathBase + "2550/user/analysisService");
      routingMap.put("2", pathBase + "2551/user/analysisService");

   }
}
