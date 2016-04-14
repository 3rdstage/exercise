package thirdstage.exercise.akka.wordstats;


public interface StatsMessages{

   public static class StatsJob implements java.io.Serializable{

      private final String text;

      public StatsJob(String text){
         this.text = text;
      }

      public String getText(){ return this.text; }
   }

   public static class StatsResult implements java.io.Serializable{

      private final double meanLen;

      public StatsResult(double len){ this.meanLen = len; }

      public double getMeanWordLength(){ return this.meanLen; }

      @Override
      public String toString(){
         return "Mean Word Length : " + this.meanLen;
      }
   }

   public static class StatsJobFailed implements java.io.Serializable{

      private final String reason;

      public String getReason(){ return this.reason; }

      public StatsJobFailed(String reason){ this.reason = reason; }

      @Override
      public String toString(){
         return "Job failed : " + this.reason;
      }
   }

}
