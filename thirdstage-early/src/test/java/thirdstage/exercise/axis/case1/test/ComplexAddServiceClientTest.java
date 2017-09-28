/*
 * ComplexAddServiceClientTest.java
 * JUnit based test
 *
 * Created on 2006년 7월 22일 (토), 오전 11:16
 */

package thirdstage.exercise.axis.case1.test;

import junit.framework.*;
import javax.xml.namespace.QName;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import thirdstage.exercise.axis.case1.Complex;
import thirdstage.exercise.axis.case1.ComplexAddServiceClient;

/**
 *
 * @author 3rdstage
 */
public class ComplexAddServiceClientTest extends TestCase {
	
	public ComplexAddServiceClientTest(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
	}

	protected void tearDown() throws Exception {
	}

	public static Test suite() {
		TestSuite suite = new TestSuite(ComplexAddServiceClientTest.class);
		
		return suite;
	}

	/**
	 * Test of add method, of class thirdstage.exercise.axis.case1.ComplexAddServiceClient.
	 */
	public void testAdd() throws Exception {
		System.out.println("add");
		
		Complex c1 = new Complex(2, 5);
		Complex c2 = new Complex(10, 33);
		String endpoint = "http://127.0.0.1:8080/thirdstage/services/CalculatorService";
		ComplexAddServiceClient instance = new ComplexAddServiceClient(endpoint);
		
		Complex expResult = new Complex(12, 58);
		Complex result = instance.add(c1, c2);
		assertEquals(expResult, result);
	}
	
}
