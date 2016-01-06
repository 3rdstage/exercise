/**
 * 
 */
package thirdstage.exercise.logging;

import static org.junit.Assert.*;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

/**
 * @author 3rdstage
 *
 */
public class AdvancedOrderServiceWithLog4jTest{

	protected OrderService orderService;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		Properties props = new Properties();
		props.load((new ClassPathResource("thirdstage/exercise/logging/conf/log4j.properties"))
		           .getInputStream());
		org.apache.log4j.LogManager.resetConfiguration();
		org.apache.log4j.PropertyConfigurator.configure(props);  

	}
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception{}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		this.orderService = new AdvancedOrderServiceWithLog4j();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{}

	/**
	 * Test method for {@link thirdstage.exercise.logging.AdvancedOrderServiceWithLog4j#makeOrder(thirdstage.exercise.logging.Order)}.
	 */
	@Test
	public void testMakeOrder(){
		Order order = new Order();
		order.setId("ORD100001");
		order.setPoNo("PO2339990");
		
		this.orderService.makeOrder(order);
		
		Assert.assertTrue(true);
	}

}
