package thirdstage.exercise.eclipse.jface.case5;

import org.testng.annotations.Test;

public class SetupInputWindowTest {

	@Test
  public void test1() {
		
		
		String f = System.getProperty("java.io.tmpdir") + "input.properties";
		SetupInputWindow.exec(f);
		System.out.println(f);
		
  }
}
