package thirdstage.exercise.akka.wordcounter;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Router extends UntypedActor{

   private final LoggingAdapter logger = Logging.getLogger(this.getContext().system(), this);

   private final ActorRef[] counters = new ActorRef[26];


   public Router(){

      char initial = 0x41;
      for(int i = 0; i < this.counters.length; i++, initial++){
         this.counters[i] = this.getContext().actorOf(Props.create(WordCounter.class, initial), "WordCounter" + initial);
         this.logger.info("An actor[name: {}] is created.", "WordCounter" + initial);
      }

   }

   @Override
   public void onReceive(Object message){

   }


}
