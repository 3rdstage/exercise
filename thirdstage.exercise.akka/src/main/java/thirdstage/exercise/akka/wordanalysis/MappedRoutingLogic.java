package thirdstage.exercise.akka.wordanalysis;

import org.slf4j.LoggerFactory;
import akka.routing.Routee;
import akka.routing.RoutingLogic;
import scala.collection.immutable.IndexedSeq;

public class MappedRoutingLogic<K extends java.io.Serializable> implements RoutingLogic{

   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


   @Override
   public Routee select(Object message, IndexedSeq<Routee> routees){
      if(!(message instanceof Keyed<?>)){
         this.logger.error("Keyed type message should be provided. But {} type message is provided.",
               message.getClass().getSimpleName());
         return akka.routing.NoRoutee$.MODULE$;
      }

      Keyed<K> keyedMsg = (Keyed<K>)message;

      int size = routees.size();
      Routee routee = null;
      KeyedRoutee<K> keyedRoutee = null;
      for(int i = 0; i < size; i++){
         routee = routees.apply(i);
         if(!(routee instanceof KeyedRoutee<?>)){
            this.logger.warn("KeyedRoutee type routee should be provided. But {} type is provided.",
                  routee.getClass().getSimpleName());
            continue;
         }

         keyedRoutee = (KeyedRoutee<K>)routee;
         if(keyedMsg.getKey().equals(keyedRoutee.getKey())){
            break;
         }
      }
      if(keyedRoutee != null){
         return keyedRoutee;
      }else{
         return akka.routing.NoRoutee$.MODULE$;
      }

   }

}
