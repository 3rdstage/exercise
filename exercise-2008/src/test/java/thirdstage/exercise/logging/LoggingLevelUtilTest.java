/**
 * 
 */
package thirdstage.exercise.logging;

import static org.junit.Assert.*;
import org.apache.log4j.Level;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import thirdstage.exercise.logging.LoggingLevelUtil.CompareResult;

/**
 * @author 3rdstage
 *
 */
public class LoggingLevelUtilTest{
	
	protected static LoggingLevelUtil testee;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		testee = new LoggingLevelUtil();
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
	public void setUp() throws Exception{}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{}

	/**
	 * Test method for {@link thirdstage.exercise.logging.LoggingLevelUtil#compareLog4jLevel(org.apache.log4j.Level, org.apache.log4j.Level)}.
	 */
	@Test
	public void testCompareLog4jLevel(){
		
		CompareResult r = testee.compareLog4jLevel(Level.ERROR, Level.INFO);
		assertEquals(CompareResult.FIRST_GREATER, r); //Error is greater than info
		
		r = testee.compareLog4jLevel(Level.INFO, Level.DEBUG);
		assertEquals(CompareResult.FIRST_GREATER, r); //Info is greater than debug
	}

}
