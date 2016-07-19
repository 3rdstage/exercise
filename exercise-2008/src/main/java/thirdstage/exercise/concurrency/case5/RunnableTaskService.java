/**
 *
 */
package thirdstage.exercise.concurrency.case5;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import org.apache.commons.collections.CollectionUtils;

/**
 * @author Sangmoon Oh
 * @since 2016. 7. 19.
 *
 */
public class RunnableTaskService{


   private final int concurrency;
   private final ExecutorService executor;

   private final AtomicLong seq = new AtomicLong(0);
   private final AtomicLong tasksNum = new AtomicLong(0);

   public RunnableTaskService(int concurrency){
      this.concurrency = concurrency;
      this.executor = Executors.newFixedThreadPool(concurrency);

   }

   public void service(@Nullable List<byte[]> bundle){
      if(CollectionUtils.isEmpty(bundle)) return;

      String id = null;
      for(byte[] data : bundle){
         id = String.valueOf(seq.incrementAndGet());
         this.executor.submit(new RunnableTask(id, data, tasksNum));
      }
   }

   @Override
   public void finalize(){
      this.destroy();
   }

   public void destroy(){
      if(this.executor != null){
         this.executor.shutdown();
      }
   }
}
