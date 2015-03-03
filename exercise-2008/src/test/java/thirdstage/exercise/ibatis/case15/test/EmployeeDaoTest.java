/**
 * 
 */
package thirdstage.exercise.ibatis.case15.test;

import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import thirdstage.exercise.ibatis.case15.Employee;
import thirdstage.exercise.ibatis.case15.EmployeeDao;
import thirdstage.exercise.ibatis.case15.EmployeeDaoIBatis;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author 3rdstage
 *
 */
public class EmployeeDaoTest{

	private EmployeeDao dao;
	
	protected EmployeeDao getEmployeeDao(){
		return this.dao;
	}
	
	public void setEmployeeDao(EmployeeDao dao){
		this.dao = dao;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClassBase() throws Exception{
		System.setProperty("spy.properties", "thirdstage/exercise/ibatis/case15/confs/spy.properties");

		Properties props = new Properties();
		props.load((new ClassPathResource("thirdstage/exercise/ibatis/case15/test/log4j.properties")).getInputStream());
		//props.load(EmployeeDaoTest.class.getResourceAsStream("thirdstage/exercise/ibatis/case15/test/log4j.properties"));
		org.apache.log4j.LogManager.resetConfiguration();
		org.apache.log4j.PropertyConfigurator.configure(props);		

		com.ibatis.common.logging.LogFactory.selectLog4JLogging();

		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClassBase() throws Exception{}

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
	 * Test method for {@link thirdstage.exercise.ibatis.case15.EmployeeDaoIBatis#addEmployee(thirdstage.exercise.ibatis.case15.Employee)}.
	 */
	@Test
	public void testAddEmployee() throws Exception{
		try{
			//EMPLOYEES_MIN table should not have a row whose id is 11 or 12
			Employee emp1 = new Employee();
			emp1.setId(11L);
			emp1.setName("Maruchi");
			Employee emp2 = new Employee();
			emp2.setId(12L);
			emp2.setName("Arachi");
			emp2.setManager(emp1);

			this.dao.addEmployee(emp1);
			this.dao.addEmployee(emp2);

			Assert.assertTrue(true);
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			Assert.assertTrue(false);
			throw ex;

		}
	}

	/**
	 * Test method for {@link thirdstage.exercise.ibatis.case15.EmployeeDaoIBatis#addEmployees(java.util.List)}.
	 */
	@Test
	public void testAddEmployees() throws Exception{
		try{
			long initId = 1001L;
			int cnt = 100;
			Employee emp = null;
			List<Employee> emps = new ArrayList<Employee>(cnt);
			
			for(int i = 0; i < cnt; i++){
				emp = new Employee();
				emp.setId(initId + i);
				emp.setName("병사 " + i);
				emps.add(emp);
			}
			
			this.dao.addEmployees(emps);

			Assert.assertTrue(true);
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			Assert.assertTrue(false);
			throw ex;

		}
	}

	/**
	 * Test method for {@link thirdstage.exercise.ibatis.case15.EmployeeDaoIBatis#findEmployee(java.lang.Long)}.
	 */
	@Test
	public void testFindEmployee() throws Exception{
		try{
			Employee emp1 = dao.findEmployee(1L);
			Employee emp3 = dao.findEmployee(3L);

			System.out.println(emp1.toString());
			System.out.println(emp3.toString());

			Assert.assertTrue(true);

		}
		catch(Exception ex){
			ex.printStackTrace(System.err);
			Assert.assertTrue(false);
			throw ex;
		}

	}

	/**
	 * Test method for {@link thirdstage.exercise.ibatis.case15.EmployeeDaoIBatis#removeEmployees(java.util.List)}.
	 */
	@Test
	public void testRemoveEmployees(){
		fail("Not yet implemented");
	}
	
	
}
