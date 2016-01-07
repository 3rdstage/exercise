/**
 * 
 */
package thirdstage.exercise.dto.case3.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import thirdstage.exercise.dto.case3.ItemValue;
import thirdstage.exercise.dto.case3.SimpleType;

/**
 * @author 3rdstage
 *
 */
public class SimpleTypeTest{

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

	
	@Before
	public void setUp(){
		
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testItemValue(){
		SimpleType value = new ItemValue();
		
		boolean b = value.isSimpleType(value.getClass());
		
		assertTrue(b);
	}
	
	
}
