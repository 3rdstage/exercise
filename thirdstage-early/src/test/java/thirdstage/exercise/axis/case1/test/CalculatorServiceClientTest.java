/*
 * CalculatorServiceClientTest.java
 * JUnit based test
 *
 * Created on 2006-07-22
 */

package thirdstage.exercise.axis.case1.test;

import junit.framework.*;
import javax.xml.namespace.QName;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import thirdstage.exercise.axis.case1.CalculatorServiceClient;

/**
 *
 * @author 3rdstage
 */
public class CalculatorServiceClientTest extends TestCase {
	
	public CalculatorServiceClientTest(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
	}

	protected void tearDown() throws Exception {
	}

	public static Test suite() {
		TestSuite suite = new TestSuite(CalculatorServiceClientTest.class);
		
		return suite;
	}

	/**
	 * Test of add method, of class thirdstage.exercise.axis.case1.CalculatorServiceClient.
	 */
	public void testAdd() throws Exception {
		System.out.println("add");
		
		int i1 = 3;
		int i2 = 4;
		String endpoint = "http://127.0.0.1:8080/thirdstage/services/CalculatorService";
		CalculatorServiceClient instance = new CalculatorServiceClient(endpoint);
		
		int expResult = 7;
		int result = instance.add(i1, i2);
		assertEquals(expResult, result);
	}
	
}
