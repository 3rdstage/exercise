/*
 * PersonManagerHibernateTest.java
 * JUnit based test
 *
 * Created on 2005년 10월 23일 (일), 오전 5:57
 */

package thirdstage.sample.insurance.managers.test;

import java.util.Properties;
import junit.framework.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import thirdstage.framework.mars.exceptions.*;
import thirdstage.sample.insurance.entities.*;
import thirdstage.sample.insurance.managers.PersonManager;
import thirdstage.sample.insurance.managers.PersonManagerHibernate;

/**
 * Tests <code>thirdstage.sample.insurance.managers.test.PersonManagerHibernate</code> class.
 * This is the first JUnit classes I write.
 *
 * @version 0.2, 3rdstage, 2005-11-01, implements and tests <code>testGetAllIndividuals</code> method successfully
 * @version 0.1, 3rdstage, 2005-10-23, bare class
 * @author 3rdstage
 * @since 2005-10-23
 */
public class PersonManagerHibernateTest extends TestCase {
	
	/**
	 * session factory for hibernate
	 */
	protected SessionFactory sessionFactory = null;
	
	
	public PersonManagerHibernateTest(String testName) {
		super(testName);
	}

    protected void setUp() throws Exception {
		 Properties props = new Properties();
		 props.setProperty("hibernate.connection.driver_class", "org.gjt.mm.mysql.Driver");
		 props.setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/sample?useUnicode=true&characterEncoding=utf-8");
		 props.setProperty("hibernate.connection.username", "tester");
		 props.setProperty("hibernate.connection.password", "testhh");
		 props.setProperty("hibernate.show_sql", "true");
		 props.setProperty("hibernate.use_sql_comments", "true");
		 
		 //need not add subclasses explicitly mapped in the hbm.xml file of superclass
		 //in this case Individual.class, Corporation.class
		 Configuration conf = new Configuration()
		                     .addClass(thirdstage.sample.insurance.entities.Person.class)
									.setProperties(props);
		 sessionFactory = conf.buildSessionFactory();
		 
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PersonManagerHibernateTest.class);
        
        return suite;
    }

    /**
     * Test of createPerson method, of class thirdstage.sample.insurance.managers.test.PersonManagerHibernate.
     */
    public void testCreatePerson() throws Exception {
        System.out.println("createPerson");
        
        Person person = null;
        PersonManagerHibernate instance = new PersonManagerHibernate();
        
        instance.createPerson(person);
        
        // TODO add your test code below by replacing the default call to fail.
        fail("The test case is empty.");
    }

    /**
     * Test of createIndividual method, of class thirdstage.sample.insurance.managers.test.PersonManagerHibernate.
     */
    public void testCreateIndividual() throws Exception {
        System.out.println("createIndividual");
        
        Individual individual = null;
        PersonManagerHibernate instance = new PersonManagerHibernate();
        
        instance.createIndividual(individual);
        
        // TODO add your test code below by replacing the default call to fail.
        fail("The test case is empty.");
    }

    /**
     * Test of createCorporation method, of class thirdstage.sample.insurance.managers.test.PersonManagerHibernate.
     */
    public void testCreateCorporation() throws Exception {
        System.out.println("createCorporation");
        
        Corporation corporation = null;
        PersonManagerHibernate instance = new PersonManagerHibernate();
        
        instance.createCorporation(corporation);
        
        // TODO add your test code below by replacing the default call to fail.
        fail("The test case is empty.");
    }

    /**
     * Test of findAllPersons method, of class thirdstage.sample.insurance.managers.test.PersonManagerHibernate.
     */
    public void testFindAllPersons() throws Exception {
        System.out.println("findAllPersons");
        
        PersonManagerHibernate instance = new PersonManagerHibernate(this.sessionFactory);
		  
        Person[] expResult = null;
        Person[] result = instance.findAllPersons();
        assertEquals(expResult, result);
        
        // TODO add your test code below by replacing the default call to fail.
        fail("The test case is empty.");
    }

    /**
     * Test of findAllIndividuals method, of class thirdstage.sample.insurance.managers.test.PersonManagerHibernate.
     */
    public void testFindAllIndividuals() throws Exception {
        System.out.println("findAllIndividuals");
        
        PersonManager instance = new PersonManagerHibernate(this.sessionFactory);
        
        Individual[] expResult = null;
        Individual[] result = instance.findAllIndividuals();
		  
		   
		  if(result == null || result.length < 2){ fail("There should be at least two individuals but thers's not"); }
		  else{
			  assertTrue("The first individual has id : 1, first name : Tom and the second individual has id : 2, second name : Russel", 
					         "1".equals(result[0].getId()) && "Tom".equals(result[0].getFirstName()) &&
					         "2".equals(result[1].getId()) && "Russel".equals(result[1].getFirstName()));
		  }
			  
    }
	 
	 /**
	  * Test of findIndividual method
	  */
	 public void testFindIndividual() throws Exception{
		 System.out.println("findIndividuals");
		 
		 PersonManager instance = new PersonManagerHibernate(this.sessionFactory);
		 
		 Individual result = instance.findIndividual("1");
		 
		 assertTrue("The first name of individual whose id is 1 is Tom as is expected", (result != null) && "Tom".equals(result.getFirstName()));
	 }

    /**
     * Test of findAllCorporations method, of class thirdstage.sample.insurance.managers.test.PersonManagerHibernate.
     */
    public void testFindAllCorporations() throws Exception {
        System.out.println("findAllCorporations");
        
        PersonManagerHibernate instance = new PersonManagerHibernate();
        
        Corporation[] expResult = null;
        Corporation[] result = instance.findAllCorporations();
        assertEquals(expResult, result);
        
        // TODO add your test code below by replacing the default call to fail.
        fail("The test case is empty.");
    }
	
}
