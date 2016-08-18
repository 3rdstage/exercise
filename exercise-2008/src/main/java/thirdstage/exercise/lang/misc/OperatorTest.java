/**
 *
 */
package thirdstage.exercise.lang.misc;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Sangmoon Oh
 * @since 2016. 8. 16.
 *
 */
public class OperatorTest{


   @Test(description="Prefix incremental operator is executed before comparison operation.")
   public void testPrefixIncrementalOperator(){


      int cnt = 0;

      if(++cnt > 0){
         Assert.assertEquals(cnt, 1);
      }else{
         Assert.fail("Prefix incremental operator is executed after comparison operation.");
      }
   }

   @Test(description="Postfix incremental operator is executed after comparison operation.")
   public void testPostfixIncrementalOperator(){


      int cnt = 0;

      if(cnt++ == 0){
         Assert.assertEquals(cnt, 1);
      }else{
         Assert.fail("Postfix incremental operator is executed before comparison operation.");
      }
   }

}
