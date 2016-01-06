/**
 * 
 */
package thirdstage.exercise.reflection;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author 3rdstage
 *
 */
public class OrderConstructorTest{
	
	protected OrderConstructor tester;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{}

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
		this.tester = new OrderConstructor();
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{}

	/**
	 * Test method for {@link thirdstage.exercise.reflection.OrderConstructor#createOrderWithPurchaseOrderNo(java.lang.String)}.
	 */
	@Test
	public void testCreateOrderWithPurchaseOrderNo() throws Exception{
		Order order = tester.createOrderWithPurchaseOrderNo("PO1000");
		
		System.out.println("The created order is : ");
		System.out.println(order.toString());
		
		Assert.assertTrue(true);
		
	}

	/**
	 * The testee method is expected to throw exception because it uses the private consturctor 
	 * to create an instant of Order. 
	 * 
	 * Test method for {@link thirdstage.exercise.reflection.OrderConstructor#createOrderWithPurchaseOrderNoAndOrderId(java.lang.String, java.lang.String)}.
	 */
	@Test(expected=IllegalAccessException.class)
	public void testCreateOrderWithPurchaseOrderNoAndOrderId() throws Exception{
		try{
			tester.createOrderWithPurchaseOrderNoAndOrderId("PO1001", "ORD20091225000003");
		}catch(Exception ex){
			System.err.println("The expected exception is : ");
			ex.printStackTrace(System.err);
			throw ex;
		}
		
		Assert.assertTrue(false);
	}

}
