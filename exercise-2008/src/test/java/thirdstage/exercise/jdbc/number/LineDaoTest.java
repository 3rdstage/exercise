/**
 * 
 */
package thirdstage.exercise.jdbc.number;

import org.junit.Assert;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 3rdstage
 *
 */
public class LineDaoTest {

	protected static ApplicationContext springContext = null;

	protected LineDaoUsingBigDecimalForNumberColumn dao1 = null;
	protected LineDaoUsingDoubleForNumberColumn dao2 = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		springContext = new ClassPathXmlApplicationContext("thirdstage/exercise/jdbc/number/confs/spring.xml");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		dao1 = new LineDaoUsingBigDecimalForNumberColumn();
		dao2 = new LineDaoUsingDoubleForNumberColumn();
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link thirdstage.exercise.jdbc.number.LineDaoUsingBigDecimalForNumberColumn#getLength(int)}.
	 */
	@Test
	public void testGetLengthUsingBigDecimalForNumberColumnWithOracle() {
		DataSource ds = (DataSource)springContext.getBean("oracleDataSource");
		this.dao1.setDataSource(ds);
		
		String len = this.dao1.getLength(100);
		
		System.out.println("Get Length Using BigDecimal for Number Column with Oracle");
		System.out.println("Length of Line with ID = 100 : " + len);
		System.out.println("");
		
		Assert.assertTrue(true);
	}

	@Test
	public void testGetLengthUsingDoubleForNumberColumnWithOracle() {
		DataSource ds = (DataSource)springContext.getBean("oracleDataSource");
		this.dao2.setDataSource(ds);
		
		String len = this.dao2.getLength(100);
		
		System.out.println("Get Length Using Double for Number Column with Oracle");
		System.out.println("Length of Line with ID = 100 : " + len);
		System.out.println("");
		
		Assert.assertTrue(true);
	}
	
}
