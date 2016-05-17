package thirdstage.exercise.akka.wordanalysis;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.LoggerFactory;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.routing.CustomRouterConfig;
import akka.routing.Router;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;

public class StaticRouterConfig extends CustomRouterConfig{

   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   private final RoutingMap routingMap;

   private final Map<String, ActorRef> actorMap = new HashMap<String, ActorRef>();


   public StaticRouterConfig(@Nonnull RoutingMap map){
      this.routingMap = map;

   }


   @Override
   public Router createRouter(ActorSystem system){
      return null;

   }

   @Nullable
   private ActorRef findActor(@Nonnull ActorSystem system, @NotBlank String path, @Min(1) int timeout){
      Timeout seconds = new Timeout(timeout, TimeUnit.SECONDS);
      ActorSelection selection = system.actorSelection(path);
      Future<ActorRef> future = selection.resolveOne(seconds);

      try{
         ActorRef actor = Await.result(future, seconds.duration());
         this.logger.debug("Succeed to find actor : {}", path);
         return actor;
      }
      catch(Exception ex){
         this.logger.warn("Fail to find actor : {}", path);
         return null;
      }
   }





}
