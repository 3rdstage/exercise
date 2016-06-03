package thirdstage.exercise.akka.wordanalysis.mappedrouter;

import org.slf4j.LoggerFactory;
import akka.routing.Routee;
import akka.routing.RoutingLogic;
import scala.collection.immutable.IndexedSeq;

public class MappedRoutingLogic<T extends java.io.Serializable> implements RoutingLogic{

   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


   @Override
   public Routee select(Object message, IndexedSeq<Routee> routees){
      if(!(message instanceof Keyed<?>)){
         this.logger.error("Keyed type message should be provided. But {} type message is provided.",
               message.getClass().getSimpleName());
         return akka.routing.NoRoutee$.MODULE$;
      }

      Keyed<T> keyedMsg = (Keyed<T>)message;

      int size = routees.size();
      Routee routee = null;
      KeyedRoutee<T> keyedRoutee = null;
      for(int i = 0; i < size; i++){
         routee = routees.apply(i);
         if(!(routee instanceof KeyedRoutee<?>)){
            this.logger.warn("KeyedRoutee type routee should be provided. But {} type is provided.",
                  routee.getClass().getSimpleName());
            continue;
         }

         if(keyedMsg.getKey().equals(((KeyedRoutee<T>)routee).getKey())){
            this.logger.debug("Found routee mapped to the key of {}.", keyedMsg.getKey());
            keyedRoutee = (KeyedRoutee<T>)routee;
            break;
         }
      }
      if(keyedRoutee != null){
         return keyedRoutee;
      }else{
         this.logger.warn("Can't find routee is mapped to the key of {}.", keyedMsg.getKey());
         return akka.routing.NoRoutee$.MODULE$;
      }

   }

}
