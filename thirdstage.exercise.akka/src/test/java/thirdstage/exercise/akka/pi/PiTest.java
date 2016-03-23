package thirdstage.exercise.akka.pi;

import org.testng.annotations.Test;

public class PiTest {

  @Test
  public void testCalculate1() {

	  Pi pi = new Pi();

	  pi.calculate(5, 10000, 10000);
  }
}
