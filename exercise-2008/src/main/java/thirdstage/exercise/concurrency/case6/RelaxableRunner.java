/**
 *
 */
package thirdstage.exercise.concurrency.case6;

import java.util.concurrent.Callable;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.LoggerFactory;

/**
 * @author Sangmoon Oh
 * @since 2016. 7. 27.
 *
 */
public class RelaxableRunner implements Callable<Void>{

   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   private final String id;

   private final int sleeps;

   private final int repeats;

   RelaxableRunner(@NotBlank String id, @Min(10) int sleeps, @Min(0) int repeats){
      this.id = id;
      this.sleeps = sleeps;
      this.repeats = repeats;
   }

   @Override
   public Void call(){

      long tm = 0;
      if(this.logger.isDebugEnabled()){
         tm = System.currentTimeMillis();
         this.logger.debug("Running the task whose ID is {}", this.id);
      }

      for(int i = 0; i < this.repeats; i++){
         this.doSomething();
         try{
            Thread.currentThread().sleep(this.sleeps);
         }catch(Exception ex){
            this.logger.error("Fail to sleep the task whose ID is {}", this.id, ex);
         }
      }

      if(this.logger.isDebugEnabled()){
         tm = System.currentTimeMillis() - tm;
         this.logger.debug("Finished the task whose ID is {} in {} milli-second at {}", this.id, tm, new java.util.Date());
      }

      return null;
   }

   private void doSomething(){

      long sum = 0;
      for(int i = 0; i < 10000; i++) sum = sum + i;
   }

}
