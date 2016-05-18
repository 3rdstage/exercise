package thirdstage.exercise.akka.wordanalysis;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import com.typesafe.config.Config;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class AnalysisClusterWorker extends ClusterNodeBase{

   public AnalysisClusterWorker(@Pattern(regexp="[a-zA-Z0-9]+") String clusterName,
         @Pattern(regexp="[a-zA-Z0-9]+") String applName,
         @Min(1) @Max(0xFFFF) int nettyPort, String configSubtree) throws Exception{
      super(clusterName, applName, nettyPort, configSubtree);
   }

   @Override
   protected ActorSystem buildActorSystem(Config config) throws Exception{
      ActorSystem system = ActorSystem.create(this.getClusterName(), config);

      ActorRef analysisService = system.actorOf(Props.create(AnalysisService.class), "analysisService");

      return system;
   }
}
