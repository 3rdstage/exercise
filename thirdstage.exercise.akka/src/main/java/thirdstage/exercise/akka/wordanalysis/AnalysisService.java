package thirdstage.exercise.akka.wordanalysis;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import akka.actor.UntypedActor;

public class AnalysisService extends UntypedActor{

   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   private volatile Map<String, Integer> stats = new HashMap<String, Integer>();

   private volatile Lock statsLock = new ReentrantLock();

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

   }


   @Override @GuardedBy("statsLock")
   public void onReceive(Object message) throws Exception{

      if(message instanceof Sentence){

         Sentence sentence = (Sentence)message;
         String id = sentence.getId();
         String key = sentence.getKey().getValue();
         String text = sentence.getText();

         this.logger.debug("Actor(path: {}, port : {}) received a sentence - id: {}, key: {}, text length: {}",
               this.getSelf().path(), this.getNettyPort(), id, key, StringUtils.length(text));
         if(!StringUtils.isBlank(text)){
            String[] words = StringUtils.splitByWholeSeparator(text, null);

            String word = null;
            for(int i = 0, n = words.length; i < n; i++){
               word = words[i].toLowerCase();

               this.statsLock.lock();
               try{
                  if(this.stats.containsKey(word)){
                     int cnt = this.stats.get(word);
                     this.stats.put(word, cnt+ 1);
                  }else{
                     this.stats.put(word, 1);
                  }
               }finally{
                  this.statsLock.unlock();
               }
            }
         }else{
            this.unhandled(message);
         }

      }


   }





}
