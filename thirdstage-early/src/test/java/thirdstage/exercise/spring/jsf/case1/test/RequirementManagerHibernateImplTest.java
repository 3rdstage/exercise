/*
 * RequirementManagerHibernateImplTest.java
 * JUnit based test
 *
 * Created on 2006년 8월 7일 (월), 오전 3:43
 */

package thirdstage.exercise.spring.jsf.case1.test;

import junit.framework.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import thirdstage.exercise.spring.jsf.case1.Requirement;
import thirdstage.exercise.spring.jsf.case1.RequirementManager;
import thirdstage.exercise.spring.jsf.case1.RequirementManagerHibernateImpl;
import thirdstage.exercise.spring.jsf.case1.RequirementMinValue;

/**
 *
 * @author 3rdstage
 */
public class RequirementManagerHibernateImplTest extends TestCase {

	private BeanFactory beanFactory = null;

	public RequirementManagerHibernateImplTest(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
		this.beanFactory = new XmlBeanFactory(new ClassPathResource("spring-exercise-spring-jsf-case1.xml"));
	}

	protected void tearDown() throws Exception {
	}

	public static Test suite() {
		TestSuite suite = new TestSuite(RequirementManagerHibernateImplTest.class);
		
		return suite;
	}


	/**
	 * Test of createRequirement method, of class thirdstage.exercise.spring.jsf.case1.RequirementManagerHibernateImpl.
	 */
	public void testCreateRequirement() throws Exception {
		System.out.println("createRequirement");
		
		RequirementManager manager = (RequirementManager)(this.beanFactory.getBean("requirementManager"));
		Requirement req = new Requirement();
		req.setId("FR-EDU-0006");
		req.setTitle("과정 수정");
		req.setRequest("과정관리자는 기존과정 내용을 시스템에 수정한다.");
		req.setAnswer("구현 가능");
		req.setStatus("ACCEPTED");
		req.setSignificance("MID");
		req.setHardness("MID");
		req.setSource("RFP");
		
		try{
			manager.createRequirement(req);
			System.err.println("What's the problem");
			assertTrue(true);
			
		}
		catch(Exception ex){
			ex.printStackTrace(System.err);
			fail();
		}
	}

	/**
	 * Test of createRequirements method, of class thirdstage.exercise.spring.jsf.case1.RequirementManagerHibernateImpl.
	 */
	public void testCreateRequirements() throws Exception {
		System.out.println("createRequirements");
		
		java.util.List<Requirement> requirements = null;
		RequirementManagerHibernateImpl instance = new RequirementManagerHibernateImpl();
		
		instance.createRequirements(requirements);
		
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getRequirement method, of class thirdstage.exercise.spring.jsf.case1.RequirementManagerHibernateImpl.
	 */
	public void testGetRequirement() throws Exception {
		System.out.println("getRequirement");
		
		String id = "";
		RequirementManagerHibernateImpl instance = new RequirementManagerHibernateImpl();
		
		Requirement expResult = null;
		Requirement result = instance.getRequirement(id);
		assertEquals(expResult, result);
		
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllRequirement method, of class thirdstage.exercise.spring.jsf.case1.RequirementManagerHibernateImpl.
	 */
	public void testGetAllRequirement() throws Exception {
		System.out.println("getAllRequirement");
		
		RequirementManager manager = (RequirementManager)(this.beanFactory.getBean("requirementManager"));
		java.util.List<Requirement> reqs = null;
		
		try{
				reqs = manager.getAllRequirement();
				
				System.out.println("Number of requirements : " + reqs.size());
				assertTrue(reqs != null && reqs.size() > 0);
		}
		catch(Exception ex){
			ex.printStackTrace(System.err);
			fail();
		}
	}

	/**
	 * Test of modifyRequirement method, of class thirdstage.exercise.spring.jsf.case1.RequirementManagerHibernateImpl.
	 */
	public void testModifyRequirement() throws Exception {
		System.out.println("modifyRequirement");
		
		Requirement requirement = null;
		RequirementManagerHibernateImpl instance = new RequirementManagerHibernateImpl();
		
		instance.modifyRequirement(requirement);
		
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getSessionFactory method, of class thirdstage.exercise.spring.jsf.case1.RequirementManagerHibernateImpl.
	 */
	public void testGetSessionFactory() {
		System.out.println("getSessionFactory");
		
		RequirementManagerHibernateImpl instance = new RequirementManagerHibernateImpl();
		
		org.hibernate.SessionFactory expResult = null;
		org.hibernate.SessionFactory result = instance.getSessionFactory();
		assertEquals(expResult, result);
		
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setSessionFactory method, of class thirdstage.exercise.spring.jsf.case1.RequirementManagerHibernateImpl.
	 */
	public void testSetSessionFactory() {
		System.out.println("setSessionFactory");
		
		org.hibernate.SessionFactory sessionFactory = null;
		RequirementManagerHibernateImpl instance = new RequirementManagerHibernateImpl();
		
		instance.setSessionFactory(sessionFactory);
		
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllRequirementInMinValue method, of class thirdstage.exercise.spring.jsf.case1.RequirementManagerHibernateImpl.
	 */
	public void testGetAllRequirementInMinValue() throws Exception {
		System.out.println("getAllRequirementInMinValue");
		
		RequirementManager manager = (RequirementManager)(this.beanFactory.getBean("requirementManager"));
		java.util.List<RequirementMinValue> reqs = null;
		
		try{
				reqs = manager.getAllRequirementInMinValue();
				
				System.out.println("Number of requirements : " + reqs.size());
				assertTrue(reqs != null && reqs.size() > 0);
		}
		catch(Exception ex){
			ex.printStackTrace(System.err);
			fail();
		}
		
		
	}
	
}
