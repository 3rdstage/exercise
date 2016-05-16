package thirdstage.exercise.akka.wordanalysis;

import akka.routing.Routee;
import akka.routing.RoutingLogic;
import scala.collection.immutable.IndexedSeq;

public class StaticRoutingLogic implements RoutingLogic{



   @Override
   public Routee select(Object message, IndexedSeq<Routee> routees){
      int size = routees.size();

      Routee routee = null;
      for(int i = 0; i < size; i++){
         routee = routees.apply(i);

      }


      return null;

   }

}
