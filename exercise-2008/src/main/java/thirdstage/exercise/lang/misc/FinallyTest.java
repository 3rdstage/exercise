/**
 *
 */
package thirdstage.exercise.lang.misc;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Sangmoon Oh
 * @since 2016. 8. 25.
 *
 */
public class FinallyTest{


   @Test
   public void testFinallyWithContinue(){
      Assert.assertEquals(this.get10(), 10);
   }

   private int get10(){

      int value = 0;
      for(int i = 0, n = 10; i < n; i++){
         try{
            value = 100;
            throw new RuntimeException("Intentionall exception");
         }catch(Exception ex){
            continue;
         }finally{
            value = i + 1;
         }
      }
      return value;
   }


}
