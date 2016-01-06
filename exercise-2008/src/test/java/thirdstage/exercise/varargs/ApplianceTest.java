package thirdstage.exercise.varargs;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import thirdstage.exercise.varargs.Appliance;

/**
 * 
 */

/**
 * @author 3rdstage
 *
 */
public class ApplianceTest{

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
	public void setUp() throws Exception{}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{}
	
	@Test
	public void testConstructor(){
		Appliance appl = new Appliance("10001", "Transparent LED 100", "Model = TRLEDTV00100A", "Size = 42 inch", "Resolution = 1920x1080");
		
		System.out.println(appl);
		
		Assert.assertTrue(true);
		
	}
	
	
	@Test
	public void testInstanceOf(){
		String str = null;
		
		if(str instanceof String){
			Assert.assertTrue(false);
		}
		else{
			Assert.assertTrue(true);
		}
	}

}
