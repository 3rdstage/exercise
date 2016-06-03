package thirdstage.exercise.akka.wordanalysis.mappedrouter;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.slf4j.LoggerFactory;
import akka.actor.ActorSystem;
import akka.routing.CustomRouterConfig;
import akka.routing.Routee;
import akka.routing.Router;

public class MappedRouterConfig2<T extends java.io.Serializable> extends CustomRouterConfig{

   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   private final List<Routee> routees = new ArrayList<Routee>();

   /**
    * @param routees will be copied, not referenced
    */
   public MappedRouterConfig2(@Nullable List<KeyedRoutee> routees){

      if(routees != null){
         for(KeyedRoutee routee: routees){
            this.routees.add(routee);
         }
      }
   }

   @Override
   public Router createRouter(ActorSystem system){

      return new Router(new MappedRoutingLogic<T>(), this.routees);
   }

}
