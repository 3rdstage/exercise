package thirdstage.exercise.akka.wordanalysis.mappedrouter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.hibernate.validator.constraints.NotBlank;
import akka.actor.ActorSystem;
import akka.actor.Address;
import akka.actor.UntypedActor;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent;
import akka.cluster.ClusterEvent.MemberEvent;
import akka.cluster.ClusterEvent.MemberExited;
import akka.cluster.ClusterEvent.MemberUp;
import akka.cluster.ClusterEvent.UnreachableMember;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.routing.Router;

public class MappedRouterActor<T extends java.io.Serializable> extends UntypedActor{

   private final LoggingAdapter logger = Logging.getLogger(getContext().system(), this);
   private final Cluster cluster;

   /**
    * The name of the routee actor.
    * Full name includes all the elements following the '.../user/' in the path.
    * For example, for 'akka.tcp://SampleSystem@xxx.xxx.xxx.xx/user/mallService/warehouseService/scheduleService',
    * the full name is 'mallService/warehouseService/scheduleService'
    */
   private final String routeeFullName;

   private final NodeIdResolver nodeIdResolver;

   private final KeyNodeMap<T> nodeMap = new SimpleKeyNodeMap<T>();

   protected KeyNodeMap<T> getKeyNodeMap(){ return this.nodeMap; }

   private final List<KeyedRoutee<T>> routees = new ArrayList<KeyedRoutee<T>>();

   protected List<KeyedRoutee<T>> getRoutees(){ return this.routees; }

   private volatile Router router = null;

   protected Router getRouter(){ return this.router; }

   /**
    * @param nodeMap will be copied, not referenced
    * @param routeeFullName
    * @param nodeIdResolver
    */
   public MappedRouterActor(@Nullable KeyNodeMap<T> nodeMap, @NotBlank String routeeFullName,
         @Nonnull NodeIdResolver nodeIdResolver){

      Validate.isTrue(StringUtils.isNotBlank(routeeFullName), "Routee name should be specified.");

      if(nodeMap != null){
         for(Map.Entry<Key<T>, String> entry: nodeMap.getEntrySet()){
            this.nodeMap.putNodeId(entry.getKey(), entry.getValue());
         }
      }

      this.nodeIdResolver = nodeIdResolver;
      this.routeeFullName = routeeFullName;

      this.cluster = Cluster.get(this.getContext().system());
      this.cluster.subscribe(getSelf(), ClusterEvent.initialStateAsEvents(),
            MemberEvent.class, UnreachableMember.class);
   }

   /* (non-Javadoc)
    * @see akka.actor.UntypedActor#preStart()
    */
   @Override
   public void preStart() throws Exception{
      super.preStart();
   }

   @Override
   public void onReceive(Object msg) throws Exception{

      if(msg instanceof Keyed<?>){
         if(!(router == null)){
            this.router.route(msg, this.getSender());
            this.logger.debug("Routed the keyed message.");
         }
      }else if(msg instanceof MemberUp){
         MemberUp ev = (MemberUp) msg;
         this.updateRouterWithMemberEvent(ev);

      }else if(msg instanceof MemberExited){
         //@TODO Need implementation
      }else{
         this.unhandled(msg);
      }
   }

   private void updateRouterWithMemberEvent(@Nonnull MemberEvent ev){
      Address addr = ev.member().address();
      String protocol = addr.protocol();
      String nodeId = this.nodeIdResolver.resolveNodeId(ev.member());
      if(StringUtils.isBlank(nodeId)){
         this.logger.warning("Can't resolve node ID from member whose address is {}.", addr.toString());
         return;
      }

      String hostPort = addr.hostPort();
      String path = new StringBuilder().append(protocol).append("://")
            .append(hostPort).append("/user/").append(this.routeeFullName).toString();

      ActorSystem system = this.getContext().system();
      KeyedRoutee<T> routee = null;

      if(ev instanceof MemberUp){
         for(Map.Entry<Key<T>, String> entry : this.nodeMap.getEntrySet()){
            if(nodeId.equals(entry.getValue())){
               routee = new KeyedActorSelectionRoutee(entry.getKey(), system.actorSelection(path));
               this.routees.add(routee);
            }
         }
      }else if(ev instanceof MemberExited){
         //@TODO Need implementation
      }

      MappedRouterConfig2 routerFactory = new MappedRouterConfig2(this.routees);
      int n1 = (this.router == null) ? 0 : this.router.routees().size();
      this.router = routerFactory.createRouter(system);
      int n2 = this.router.routees().size();
      this.logger.info("Updated the router. The number of routees become {} from {}.", n2, n1);
   }

}
