/**
 * 
 */
package thirdstage.exercise.ibatis.case15.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import thirdstage.exercise.ibatis.case15.EmployeeDaoJdbcSimplest;

/**
 * @author 3rdstage
 *
 */
public class EmployeeDaoJdbcSimplestTest extends EmployeeDaoTest{

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
		super.setUp();
		
		this.setEmployeeDao(new EmployeeDaoJdbcSimplest());
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{
		super.tearDown();
		
	}

}
