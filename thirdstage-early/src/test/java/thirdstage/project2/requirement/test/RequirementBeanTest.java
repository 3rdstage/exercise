
package thirdstage.project2.requirement.test;

import junit.framework.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import thirdstage.project2.requirement.Requirement;
import thirdstage.project2.requirement.RequirementBean;
import thirdstage.project2.requirement.RequirementManager;

import junit.framework.*;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-09-17, 3rdstage
 * @since 2006-09-17
 */
public class RequirementBeanTest extends TestCase {

	private BeanFactory beanFactory = null;	
	
	public RequirementBeanTest(String testName) {
		super(testName);
		
		this.beanFactory = new XmlBeanFactory(new ClassPathResource("spring-project2.xml"));
	}
	
	protected void setUp() throws Exception {
	}
	
	protected void tearDown() throws Exception {
	}
	
	/**
	 * Test of getRequirementManager method, of class thirdstage.project2.requirement.test.RequirementBean.
	 */
	public void testGetRequirementManager() {
		System.out.println("getRequirementManager");
		
		RequirementBean instance = new RequirementBean();
		
		RequirementManager expResult = null;
		RequirementManager result = instance.getRequirementManager();
		assertEquals(expResult, result);
		
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setRequirementManager method, of class thirdstage.project2.requirement.test.RequirementBean.
	 */
	public void testSetRequirementManager() {
		System.out.println("setRequirementManager");
		
		RequirementManager manager = null;
		RequirementBean instance = new RequirementBean();
		
		instance.setRequirementManager(manager);
		
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of create method, of class thirdstage.project2.requirement.test.RequirementBean.
	 */
	public void testCreate() throws Exception {
		System.out.println("create");
		
		RequirementBean instance = new RequirementBean();
		
		instance.create();
		
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAll method, of class thirdstage.project2.requirement.test.RequirementBean.
	 */
	public void testGetAll() throws Exception {
		System.out.println("getAll");
		
		RequirementBean instance = new RequirementBean();
		
		java.util.List<Requirement> expResult = null;
		java.util.List<Requirement> result = instance.getAll();
		assertEquals(expResult, result);
		
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	
}
