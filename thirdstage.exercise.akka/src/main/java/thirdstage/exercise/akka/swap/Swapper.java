package thirdstage.exercise.akka.swap;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Swapper extends UntypedActor{
   LoggingAdapter logger = Logging.getLogger(this.getContext().system(), this);


   @Override
   public void onReceive(Object message) throws Exception{
      if(message == Swap.SWAP){


      }

   }

}
