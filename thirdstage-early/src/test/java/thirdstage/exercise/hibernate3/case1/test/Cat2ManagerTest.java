/*
 * Cat2ManagerTest.java
 * JUnit based test
 *
 * Created on 2006년 7월 15일 (토), 오후 9:25
 */

package thirdstage.exercise.hibernate3.case1.test;

import junit.framework.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import thirdstage.exercise.hibernate3.case1.Cat2;
import thirdstage.exercise.hibernate3.case1.Cat2Manager;

/**
 *
 * @author 3rdstage
 */
public class Cat2ManagerTest extends TestCase {
	
	public Cat2ManagerTest(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
	}

	protected void tearDown() throws Exception {
	}

	public static Test suite() {
		TestSuite suite = new TestSuite(Cat2ManagerTest.class);
		
		return suite;
	}

	/**
	 * Test of getAllCats method, of class thirdstage.exercise.hibernate3.case1.Cat2Manager.
	 */
	public void testGetAllCats() {
		System.out.println("getAllCats");
		
		Cat2Manager instance = new Cat2Manager();
		
		java.util.List<Cat2> expResult = null;
		java.util.List<Cat2> result = instance.getAllCats();
		
		for(Cat2 cat : result){
			System.out.println("ID : " + cat.getId() + ", Name : " + cat.getName() + ", Sex : " + cat.getSex());
			
		}
		
		assertTrue(result != null && result.size() > 0);
		
	}
	
}
