
package thirdstage.exercise.hibernate3.case2.test;

import java.util.Properties;
import junit.framework.*;
import thirdstage.exercise.hibernate3.case2.Company;
import thirdstage.exercise.hibernate3.case2.CompanyManager;
import thirdstage.exercise.hibernate3.case2.CompanyManagerHibernate;
import thirdstage.framework.mars.exceptions.*;

/**
 * Unit test-case for the class CompanyManagerTest
 *
 * @version 1.0, 2005-11-16, 3rdstage
 * @author 3rdstage
 * @since 2005-11-16
 */
public class CompanyManagerTest extends TestCase {
	
	protected org.hibernate.SessionFactory sessionFactory = null;
	
	public CompanyManagerTest(String testName) {
		super(testName);
	}
	
	protected void setUp() throws Exception {
		Properties props = new Properties();
		props.setProperty("hibernate.connection.driver_class", "org.gjt.mm.mysql.Driver");
		props.setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8");
		props.setProperty("hibernate.connection.username", "tester");
		props.setProperty("hibernate.connection.password", "testhh");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.use_sql_comments", "true");
		
		//need not add subclasses explicitly mapped in the hbm.xml file of superclass
		//in this case Individual.class, Corporation.class
		org.hibernate.cfg.Configuration conf = new org.hibernate.cfg.Configuration()
		                                           .addClass(thirdstage.exercise.hibernate3.case2.Company.class)
																 .addClass(thirdstage.exercise.hibernate3.case2.Building.class)
																 .addClass(thirdstage.exercise.hibernate3.case2.Factory.class)
																 .addClass(thirdstage.exercise.hibernate3.case2.Employee.class)
		                                           .setProperties(props);
		sessionFactory = conf.buildSessionFactory();
	}
	
	protected void tearDown() throws Exception {
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite(CompanyManagerTest.class);
		
		return suite;
	}
	
	/**
	 * Test of findCompany method, of class thirdstage.test.hibernate2.CompanyManager.
	 */
	public void testFindCompany() throws Exception{
		System.out.println("findCompany");
		
		String id = "1";
		CompanyManager instance = new CompanyManagerHibernate(this.sessionFactory);
		
		Company expResult = null;
		Company result = instance.findCompany(id);

		if(result != null){
			System.out.println("ID :" + result.getId());
			System.out.println("Name : " + result.getName());
			System.out.println("# of Buildings : " + result.getBuildings().length);
			System.out.println("# of Factories : " + result.getFactories().size());
			System.out.println("# of Employees : " + result.getEmployees().size());
			
			assertEquals("LK Telecom", result.getName());
		}
		else{
			fail("Test data is not prepared properly or class is not coded properly.");
		}
	}
	
	/**
	 * Generated implementation of abstract class thirdstage.test.hibernate2.CompanyManager. Please fill dummy bodies of generated methods.
	 */
	private class CompanyManagerImpl implements CompanyManager {
		
		public thirdstage.exercise.hibernate3.case2.Company findCompany(java.lang.String id) {
			// TODO fill the body in order to provide useful implementation
			
			return null;
		}
	}
	
	
	public static void main(java.lang.String[] argList) {
		junit.textui.TestRunner.run(suite());
	}
	
}
