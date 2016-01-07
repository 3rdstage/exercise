/**
 * 
 */
package thirdstage.exercise.xml.relaxng;

import static org.junit.Assert.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * @author 3rdstage
 *
 */
public class ComponentMetaValidatorTest {
	
	protected ComponentMetaValidator validator = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		try{
			validator = new ComponentMetaValidator();
			validator.setResourceNameOfSchema("thirdstage/exercise/xml/relaxng/component.rnc");
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link thirdstage.exercise.xml.relaxng.ComponentMetaValidator#isValidComponentMeta(org.xml.sax.InputSource)} 
	 * using DOM representation of the testee XML internally.
	 * This method is expected to throw <code>IllegalArgumentException</code>, because the <code>Jing</code> library doesn't 
	 * support DOM and support only SAX2 parsers.
	 */
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void testIsValidComponentMetaUsingDOM() throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(ClassLoader.getSystemResourceAsStream("thirdstage/exercise/xml/relaxng/Order.component.xml"));
		
		
		try{
			this.validator.isValidComponentMeta(new DOMSource(doc));
			Assert.assertTrue(true);
		}
		catch(Exception ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
		
	}
	
	/**
	 * Test method for {@link thirdstage.exercise.xml.relaxng.ComponentMetaValidator#isValidComponentMeta(org.xml.sax.InputSource)}.
	 */
	@Test(expected=java.lang.Exception.class)
	public void testIsValidComponentMetaUsingDOMWithInvalidXML() throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(ClassLoader.getSystemResourceAsStream("thirdstage/exercise/xml/relaxng/Order-invalid.component.xml"));
		
		try{
			this.validator.isValidComponentMeta(new DOMSource(doc));
		}
		catch(Exception ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
		
	}
	
	
	/**
	 * Test method for {@link thirdstage.exercise.xml.relaxng.ComponentMetaValidator#isValidComponentMeta(org.xml.sax.InputSource)}.
	 */
	@Test
	public void testIsValidComponentMetaUsingSAXWithValidXML() throws Exception {

		SAXSource meta = new SAXSource(new InputSource(ClassLoader.getSystemResourceAsStream("thirdstage/exercise/xml/relaxng/Order.component.xml")));
		
		try{
			this.validator.isValidComponentMeta(meta);
			Assert.assertTrue(true);
		}
		catch(Exception ex){
			ex.printStackTrace(System.err);
			throw ex;
		}		
	}
	

	/**
	 * Test method for {@link thirdstage.exercise.xml.relaxng.ComponentMetaValidator#isValidComponentMeta(org.xml.sax.InputSource)}.
	 */
	//@Ignore
	@Test(expected=java.lang.Exception.class)
	public void testIsValidComponentMetaUsingSAXWithInvalidXML() throws Exception {

		SAXSource meta = new SAXSource(new InputSource(ClassLoader.getSystemResourceAsStream("thirdstage/exercise/xml/relaxng/Order-invalid.component.xml")));
		
		try{
			this.validator.isValidComponentMeta(meta);
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}
}
