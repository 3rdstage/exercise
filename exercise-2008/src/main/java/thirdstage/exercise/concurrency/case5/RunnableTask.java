/**
 *
 */
package thirdstage.exercise.concurrency.case5;

import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.LoggerFactory;

/**
 * @author Sangmoon Oh
 * @since 2016-07-19
 *
 */
public class RunnableTask implements Runnable{

   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   private final String id;

   private final byte[] img;

   private final AtomicLong counter;

   public RunnableTask(String id, byte[] img, final AtomicLong cnt){
      this.id = id;
      this.img = img;
      this.counter = cnt;
   }


   @Override
   public void run(){

      this.counter.incrementAndGet();

   }

}
