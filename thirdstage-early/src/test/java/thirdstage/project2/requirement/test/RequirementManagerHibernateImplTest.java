/*
 * RequirementManagerHibernateImplTest.java
 * JUnit based test
 *
 * Created on September 15, 2006, 3:48 PM
 */

package thirdstage.project2.requirement.test;

import junit.framework.*;
import org.hibernate.HibernateException;
import org.apache.commons.configuration.ConfigurationUtils;

import thirdstage.project2.requirement.Requirement;
import thirdstage.project2.requirement.RequirementManagerHibernateImpl;

/**
 *
 * @author 3rdstage
 */
public class RequirementManagerHibernateImplTest extends TestCase {

   private static org.apache.commons.logging.Log log =
        org.apache.commons.logging.LogFactory.getLog(RequirementManagerHibernateImplTest.class);

	protected org.hibernate.SessionFactory sessionFactory = null;
	protected org.dbunit.IDatabaseTester databaseTester = null;

	
	public RequirementManagerHibernateImplTest(String testName) {
		
		super(testName);
		
		java.util.Properties props = new java.util.Properties();
		props.setProperty("hibernate.connection.driver_class", "org.gjt.mm.mysql.Driver");
		props.setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/project2?useUnicode=true&characterEncoding=utf-8");
		props.setProperty("hibernate.connection.username", "tester");
		props.setProperty("hibernate.connection.password", "testhh");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.use_sql_comments", "true");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		//need not add subclasses explicitly mapped in the hbm.xml file of superclass
		//in this case Individual.class, Corporation.class
		org.hibernate.cfg.Configuration conf = new org.hibernate.cfg.Configuration()
		.addClass(thirdstage.project2.requirement.Requirement.class)
		.setProperties(props);
		sessionFactory = conf.buildSessionFactory();
		
	}
	
	protected void setUp() throws Exception {
		
		databaseTester = new org.dbunit.JdbcDatabaseTester(
				"org.gjt.mm.mysql.Driver", 
				"jdbc:mysql://127.0.0.1:3306/project2?useUnicode=true&characterEncoding=utf-8",
				"tester", "testhh");
			
		org.dbunit.dataset.IDataSet dataSet = null;
		
		try{
			String dataFile = "thirdstage/project2/requirement/Requirement2.data.xml";
			dataSet = new org.dbunit.dataset.xml.FlatXmlDataSet(
					new java.io.File(ConfigurationUtils.locate(dataFile).toURI()));
			
			log.info("DataSet XML file is found.");
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}
	
	protected void tearDown() throws Exception {
		databaseTester.onTearDown();
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite(RequirementManagerHibernateImplTest.class);
		
		return suite;
	}
	
	
	/**
	 * Test of createRequirement method, of class thirdstage.project2.requirement.test.RequirementManagerHibernateImpl.
	 */
	public void testCreateRequirement() throws Exception{
		log.info("Start testing createRequirement.");
		
		RequirementManagerHibernateImpl instance = new RequirementManagerHibernateImpl();
		instance.setSessionFactory(this.sessionFactory);
		
		Requirement requirement = new thirdstage.project2.requirement.Requirement();
		requirement.setId("RQ-TEST-001");
		requirement.setTitle("Register Product");
		requirement.setRequestedDate(new java.util.Date());
		
		try{
			instance.createRequirement(requirement);
			assertTrue(true);
		} catch(Exception ex){
			ex.printStackTrace(System.err);
			fail();
		}
	}
	
	
	
	/**
	 * Test of getRequirement method, of class thirdstage.project2.requirement.test.RequirementManagerHibernateImpl.
	 */
	public void testGetRequirementById() throws Exception {
		log.info("Start testing getRequirement.");
		
		String id = "";
		RequirementManagerHibernateImpl instance = new RequirementManagerHibernateImpl();
		instance.setSessionFactory(this.sessionFactory);
		
		Requirement result = instance.getRequirementById("FRQ-ORDER-0001");
		
		if(result == null) System.out.println("There's no requirement with given Id.");
		else System.out.println(result.getTitle());
		
		assertEquals(result.getTitle(), "View Orders");
	}
	
	
	
}
