/*
 * AnnotationReaderTest.java
 * JUnit based test
 *
 * Created on 2007년 9월 4일 (화), 오전 10:07
 */

package thirdstage.exercise.annotation.set2.test;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import junit.framework.*;
import org.w3c.dom.Document;

import thirdstage.exercise.annotation.set2.AnnotationReader;

/**
 *
 * @author 3rdstage
 */
public class AnnotationReaderTest extends TestCase {
	
	public AnnotationReaderTest(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
	}

	protected void tearDown() throws Exception {
	}

	/**
	 * Test of getProcessIds method, of class thirdstage.exercise.annotation.set2.AnnotationReader.
	 */
	public void testGetProcessIds() throws Exception {
		System.out.println("getProcessIds");
		
		Class controller = thirdstage.exercise.annotation.set2.CatalogManager.class;
		AnnotationReader instance = new AnnotationReader();
		
		String[] expResult = new String[]{"PR-CAT-001", "PR-CAT-002", "PR-CAT-003"};
		String[] result = instance.getProcessIds(controller);
		
		assertTrue("Test for controller class with 3 process annotated :", java.util.Arrays.equals(expResult, result));

		controller = thirdstage.exercise.annotation.set2.CatalogManagerWithoutAnnotation.class;
		result = instance.getProcessIds(controller);
		
		assertTrue("Test for controller class with no process annotation which returns empty array", (result != null) && (result.length == 0));
		
		
	}
	
	public void testGetProcessControllerMapXML() throws Exception{
		System.out.println("getProcessControllerMapXML");
		
		//TO-DO
		assertTrue("TO-DO", false);
		
		
		
	}

	
	public static Test suite() {
		TestSuite suite = new TestSuite(AnnotationReaderTest.class);
		
		return suite;
	}

	
}
