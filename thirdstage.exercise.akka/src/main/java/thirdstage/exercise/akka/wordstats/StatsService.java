package thirdstage.exercise.akka.wordstats;

import thirdstage.exercise.akka.wordstats.StatsMessages.StatsJob;
import thirdstage.exercise.akka.wordstats.StatsMessages.StatsJobFailed;
import thirdstage.exercise.akka.wordstats.StatsMessages.StatsResult;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.routing.ConsistentHashingRouter.ConsistentHashableEnvelope;
import akka.routing.FromConfig;


/**
 * @author Sangmoon Oh
 * @since 2016-04-15
 * @see <a href="http://www.lightbend.com/activator/template/akka-sample-cluster-java">Akka Cluster Samples with Java</a>
 */
public class StatsService extends UntypedActor{

   private final LoggingAdapter logger = Logging.getLogger(this.getContext().system(), this);

   ActorRef workerRouter = getContext().actorOf(
         FromConfig.getInstance().props(Props.create(StatsWorker.class)), "workerRouter");

   @Override
   public void onReceive(Object message) throws Exception{
      if(message instanceof StatsJob){
         StatsJob job = (StatsJob)message;

         if("".equals(job.getText())){
            this.unhandled(message);
         }else{
            final String[] words = job.getText().split(" ");

            ActorRef aggregator = this.getContext().actorOf(
                  Props.create(StatsAggregator.class, words.length, this.getSelf()));

            for(String word : words){
               this.workerRouter.tell(new ConsistentHashableEnvelope(word, word), aggregator);
            }
         }
      }else if(message instanceof StatsResult){
         this.logger.info("Stats result : {}", message.toString());
      }else if(message instanceof StatsJobFailed){
         this.logger.info("Stats failed : {}", message.toString());
      }else {
         this.unhandled(message);
      }
   }

}
