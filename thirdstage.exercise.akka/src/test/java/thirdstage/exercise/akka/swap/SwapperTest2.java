package thirdstage.exercise.akka.swap;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class SwapperTest2{

   public static void main(String... args) {
      ActorSystem system = ActorSystem.create("MySystem");
      ActorRef swapper = system.actorOf(Props.create(Swapper.class));

      swapper.tell(Swap.SWAP, ActorRef.noSender());
      swapper.tell(Swap.SWAP, ActorRef.noSender());
   }

}
