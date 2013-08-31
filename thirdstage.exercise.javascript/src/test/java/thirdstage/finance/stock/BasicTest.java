package thirdstage.finance.stock;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTest {
	
	
	@Test
	public void testLoadSpringContainer(){
		
		ApplicationContext cntx = new ClassPathXmlApplicationContext("thirdstage/finance/stock/spring.xml");
		
		Assert.assertNotNull(cntx);
	}

}
