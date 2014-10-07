/**
 * 
 */
package thirdstage.exercise.ibatis.case15.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thirdstage.exercise.ibatis.case15.EmployeeDao;

/**
 * @author 3rdstage
 *
 */
public class EmployeeDaoJdbcPreparedTest extends EmployeeDaoTest{

	
	protected static ApplicationContext springContext; 
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		springContext = new ClassPathXmlApplicationContext("thirdstage/exercise/ibatis/case15/confs/spring.xml");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		if(springContext != null) ((ConfigurableApplicationContext)springContext).close();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		super.setUp();
		this.setEmployeeDao((EmployeeDao)springContext.getBean("employeeDaoJdbcPrepared"));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{
		super.tearDown();
		
		
	}

}
