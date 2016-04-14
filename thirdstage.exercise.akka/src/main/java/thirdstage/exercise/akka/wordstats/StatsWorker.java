package thirdstage.exercise.akka.wordstats;

import java.util.HashMap;
import java.util.Map;
import akka.actor.UntypedActor;

public class StatsWorker extends UntypedActor{

   private final Map<String, Integer> cache = new HashMap<>();

   @Override
   public void onReceive(Object msg){
      if(msg instanceof String){
         String str = (String)msg;
         Integer len = cache.get(str);
         if(len == null){
            len = str.length();
            cache.put(str, len);
         }
         getSender().tell(len, getSelf());

      }else{
         this.unhandled(msg);
      }
   }

}
