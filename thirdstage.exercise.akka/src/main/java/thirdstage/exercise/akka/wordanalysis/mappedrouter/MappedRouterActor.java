package thirdstage.exercise.akka.wordanalysis.mappedrouter;

import javax.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.hibernate.validator.constraints.NotBlank;
import akka.actor.Address;
import akka.actor.UntypedActor;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent;
import akka.cluster.ClusterEvent.MemberEvent;
import akka.cluster.ClusterEvent.MemberUp;
import akka.cluster.ClusterEvent.UnreachableMember;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MappedRouterActor<T extends java.io.Serializable> extends UntypedActor{

   private final LoggingAdapter logger = Logging.getLogger(getContext().system(), this);
   private final Cluster cluster;

   private final String routeeFullName;

   private final KeyNodeMap<T> nodeMap = new SimpleKeyNodeMap<T>();

   protected KeyNodeMap<T> getKeyNodeMap(){ return this.nodeMap; }

   private final RoutingMap<T> routingMap = new SimpleRoutingMap<T>();

   protected RoutingMap<T> getRoutingMap(){ return this.routingMap; }

   public MappedRouterActor(@Nullable KeyNodeMap<T> nodeMap, @NotBlank String routeeFullName){

      Validate.isTrue(StringUtils.isNotBlank(routeeFullName), "Routee name should be specified.");

      this.routeeFullName = routeeFullName;

      if(nodeMap != null){
         for(Key<T> key: nodeMap.getKeys()){
            this.nodeMap.putNodeId(key, nodeMap.getNodeId(key));
         }
      }

      this.cluster = Cluster.get(this.getContext().system());
      this.cluster.subscribe(getSelf(), ClusterEvent.initialStateAsEvents(),
            MemberEvent.class, UnreachableMember.class);
   }

   /* (non-Javadoc)
    * @see akka.actor.UntypedActor#preStart()
    */
   @Override
   public void preStart(){
      Address addr = this.cluster.selfAddress();

      String protocol = addr.protocol();
      String nodeId = addr.system();
      String hostPort = addr.hostPort();
      String path = new StringBuilder().append(protocol).append("://")
            .append(hostPort).append("/user/").append(this.routeeFullName).toString();

      if(StringUtils.isNotBlank(nodeId)){
         for(Key<T> key : this.nodeMap.getKeys()){
            if(nodeId.equals(this.nodeMap.getNodeId(key))){
               this.routingMap.putPath(key, path);
            }
         }
      }
   }

   @Override
   public void onReceive(Object msg) throws Exception{
      if(msg instanceof MemberUp){
         MemberUp ev = (MemberUp) msg;

         Address addr = ev.member().address();
         String protocol = addr.protocol();
         String nodeId = addr.system();
         String hostPort = addr.hostPort();
         String path = new StringBuilder().append(protocol).append("://")
               .append(hostPort).append("/user/").append(this.routeeFullName).toString();

      }else{
         this.unhandled(msg);
      }

   }

}
