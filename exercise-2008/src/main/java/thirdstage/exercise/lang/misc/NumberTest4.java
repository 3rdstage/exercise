/**
 *
 */
package thirdstage.exercise.lang.misc;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Sangmoon Oh
 * @since 2016. 7. 27.
 *
 */
public class NumberTest4{

   @Test
   public void testDoubleValueOnInt(){

      Integer num = new Integer(100);
      Assert.assertEquals(num.doubleValue(), 100.0d);

      num = new Integer(-100);
      Assert.assertEquals(num.doubleValue(), -100.0d);

      num = new Integer(0);
      Assert.assertEquals(num.doubleValue(), 0.0d);
      Assert.assertNotEquals(num.doubleValue(), -0.0d);

      num = new Integer(Integer.MAX_VALUE);
      Assert.assertTrue(num.doubleValue() > 100000.0d);

      num = new Integer(Integer.MIN_VALUE);
      Assert.assertTrue(num.doubleValue() < -100000.0d);
   }

   @Test
   public void testDoubleValueOnLong(){

      Long num = new Long(1000);
      Assert.assertEquals(num.doubleValue(), 1000.0d);

      num = new Long(-1000);
      Assert.assertEquals(num.doubleValue(), -1000.0d);

      num = new Long(0);
      Assert.assertEquals(num.doubleValue(), 0.0d);
      Assert.assertNotEquals(num.doubleValue(), -0.0d);

      num = new Long(Long.MAX_VALUE);
      Assert.assertTrue(num.doubleValue() > 10000000000.0d);

      num = new Long(Long.MIN_VALUE);
      Assert.assertTrue(num.doubleValue() < -10000000000.0d);

   }

   @Test
   public void testDoubleValueOnFloat(){

      Float num = new Float(100.0f);
      Assert.assertEquals(num.doubleValue(), 100.0d);

      num = new Float(-100.0f);
      Assert.assertEquals(num.doubleValue(), -100.0d);

      num = new Float(0.0f);
      Assert.assertEquals(num.doubleValue(), 0.0d);
      Assert.assertNotEquals(num.doubleValue(), -0.0d);

      num = new Float(Float.MAX_VALUE);
      Assert.assertTrue(num.doubleValue() > 10000000000.0d);

      num = new Float(-Float.MAX_VALUE);
      Assert.assertTrue(num.doubleValue() < -10000000000.0d);
   }


}
