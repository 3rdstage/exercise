package thirdstage.exercise.akka.wordanalysis;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class AnalysisClusterMaster extends ClusterNodeBase{

   public static final int MASTER_NODE_NETTY_PORT_DEFAULT = 2551;

   public static final int HTTP_PORT_DEFAULT = 8080;

   private final int httpPort;

   public int getHttpPort(){ return this.httpPort; }


   public AnalysisClusterMaster(@NotBlank String clusterName, @NotBlank String applName,
         @Min(1) @Max(0xFFFF) int nettyPort,@Min(1) @Max(0xFFFF) int httpPort,
         String configSubtree) throws Exception{
      super(clusterName, applName, nettyPort, configSubtree);
      this.httpPort = httpPort;
   }

   @Override
   public ActorSystem buildActorSystem() throws Exception{

      ActorSystem system = ActorSystem.create();

      ActorRef httpClerk;


      return system;
   }




}
