package thirdstage.exercise.akka.wordanalysis;

import java.net.InetAddress;
import java.util.Date;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.GuardedBy;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.LoggerFactory;
import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class AnalysisService extends UntypedActor{

   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   private final static FastDateFormat timestampFormat =
         FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss");

   private final InetAddress address;

   <<<<<<< HEAD
   protected InetAddress getAddress(){ return this.address; }
   =======
         private final int nettyPort;

   protected int getNettyPort(){ return this.nettyPort; }

   public AnalysisService(){

      int port = -1;
      try{
         port = this.getContext().system().settings().config().getInt("akka.remote.netty.tcp.port");
      }catch(Throwable t){
         this.logger.warn("Can't read 'akka.remote.netty.tcp.port' from the config.");
      }

      this.nettyPort = port;
      >>>>>>> branch 'master' of https://github.com/3rdstage/exercise.git

         private final int nettyPort;

   protected int getNettyPort(){ return this.nettyPort; }

   private ActorRef recordingService;

   private ActorRef traceService;

   public AnalysisService(@Nonnull ActorRef recordingService) throws Exception{

      int port = -1;
      try{
         port = this.getContext().system().settings().config().getInt("akka.remote.netty.tcp.port");
      }catch(Throwable t){
         this.logger.warn("Can't read 'akka.remote.netty.tcp.port' from the config.");
      }

      this.address = InetAddress.getLocalHost();
      this.nettyPort = port;

      this.recordingService = recordingService;
   }

   public AnalysisService(ActorRef recordingService, ActorRef traceService) throws Exception{
      this(recordingService);
      this.traceService = traceService;
   }


   @Override @GuardedBy("statsLock")
   public void onReceive(Object message) throws Exception{

      if(message instanceof Sentence){

         Sentence sentence = (Sentence)message;
         String id = sentence.getId();
         String key = sentence.getKey().getValue();
         String text = sentence.getText();
         String timestamp = timestampFormat.format(new Date());

         this.logger.debug("Actor(path: {}, port : {}) received a sentence - id: {}, key: {}, text length: {}",
               this.getSelf().path(), this.getNettyPort(), id, key, StringUtils.length(text));

         if(this.traceService != null){
            Trace trace = new Trace(id, sentence.getSourceId(),
                  this.address.getHostAddress(), this.nettyPort, timestamp);
            this.traceService.tell(trace, this.getSelf());
         }

         if(!StringUtils.isBlank(text)){
            String[] words = StringUtils.splitByWholeSeparator(text, null);

            String word = null;
            Record rd = null;
            for(int i = 0, n = words.length; i < n; i++){
               word = words[i].toLowerCase();

               rd = new Record(word, id, timestamp);
               this.recordingService.tell(rd, this.getSelf());
            }
         }else{
            this.unhandled(message);
         }
      }
   }

   }
