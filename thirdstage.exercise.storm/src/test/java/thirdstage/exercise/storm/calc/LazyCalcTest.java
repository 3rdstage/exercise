package thirdstage.exercise.storm.calc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LazyCalcTest {
   
   private final Logger logger = LoggerFactory.getLogger(this.getClass());

   @Test
   public void sumBetween() {
      
      LazyCalc calc = new LazyCalc(0);
      
      double a = 1.0;
      double b = 100.0;
      double step = 1.0;
      double sum = calc.sumBetween(a, b, step);

      this.logger.info("Sum integers between 0 to 100 is : {}", sum);
      
      Assert.assertEquals(sum, 5050.0);
      
   }
}
