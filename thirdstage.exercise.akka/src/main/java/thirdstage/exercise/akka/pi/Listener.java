package thirdstage.exercise.akka.pi;

import akka.actor.UntypedActor;

public class Listener extends UntypedActor{

   @Override
   public void onReceive(Object msg) throws Exception{
      if(msg instanceof PiApproximation){
         PiApproximation pi = (PiApproximation) msg;
         System.out.println(String.format("Pi approximation : %s", pi.getPi()));
         System.out.println(String.format("Calculation time : %s", pi.getDuration()));
      }else{
         this.unhandled(msg);
      }

   }

}
