package thirdstage.exercise.akka.wordanalysis;

import akka.routing.ActorSelectionRoutee;
import akka.routing.Routee;
import akka.routing.RoutingLogic;
import scala.collection.immutable.IndexedSeq;

public class StaticRoutingLogic implements RoutingLogic{



   @Override
   public Routee select(Object message, IndexedSeq<Routee> routees){
      int size = routees.size();

      ActorSelectionRoutee routee = null;
      for(int i = 0; i < size; i++){
         routee = (ActorSelectionRoutee)(routees.apply(i));

      }


      return null;

   }

}
