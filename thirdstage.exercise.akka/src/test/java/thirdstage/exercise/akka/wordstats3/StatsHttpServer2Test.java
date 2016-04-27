package thirdstage.exercise.akka.wordstats3;

public class StatsHttpServer2Test{


   public static void main(String[] args) throws Exception{

      int nettyPort = 2551;
      int httpPort = 8080;
      String appName = "wordstats";

      StatsHttpServer2 server = new StatsHttpServer2(nettyPort, httpPort, appName);

      server.start();
   }

}
