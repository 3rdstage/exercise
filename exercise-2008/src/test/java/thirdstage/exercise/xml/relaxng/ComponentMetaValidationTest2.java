/**
 * 
 */
package thirdstage.exercise.xml.relaxng;


import java.io.PrintStream;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import thirdstage.exercise.xml.relaxng.FullCollectiveErrorHandler;

/**
 * @author 3rdstage
 *
 */
public class ComponentMetaValidationTest2 {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("javax.xml.validation.SchemaFactory:" + XMLConstants.RELAXNG_NS_URI, "com.thaiopensource.relaxng.jaxp.CompactSyntaxSchemaFactory");
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void testValidationForValidXml() throws Exception{
		
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("starting " + method);

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.RELAXNG_NS_URI);
		Schema schema = sf.newSchema(ClassLoader.getSystemResource("thirdstage/exercise/xml/relaxng/component.rnc"));
		Validator validator = schema.newValidator();
		
		FullCollectiveErrorHandler errorHandler = new FullCollectiveErrorHandler();
		validator.setErrorHandler(errorHandler);
		
		try{
			validator.validate(new StreamSource(ClassLoader.getSystemResourceAsStream("thirdstage/exercise/xml/relaxng/Order.component.xml")));
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			
		}finally{
			errorHandler.printErrors(System.err);
		}
		
		System.out.println("ending " + method);
		Assert.assertTrue(!errorHandler.hasError());
	}	
	
	@Test
	public void testValidationForInvalidXml() throws Exception{
		
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("starting " + method);

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.RELAXNG_NS_URI);
		Schema schema = sf.newSchema(ClassLoader.getSystemResource("thirdstage/exercise/xml/relaxng/component.rnc"));
		Validator validator = schema.newValidator();
		
		FullCollectiveErrorHandler errorHandler = new FullCollectiveErrorHandler();
		validator.setErrorHandler(errorHandler);
		
		try{
			validator.validate(new StreamSource(ClassLoader.getSystemResourceAsStream("thirdstage/exercise/xml/relaxng/Order-invalid.component.xml")));
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			
		}finally{
			errorHandler.printErrors(System.err);
		}
		
		System.out.println("ending " + method);
		Assert.assertTrue(!errorHandler.hasError());
	}
	
	
	@Test
	public void testValidationOverridingForValidXml() throws Exception{
		
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("starting " + method);
		
		boolean result = this.validateAndPrint("thirdstage/exercise/xml/relaxng/component.java.rnc", 
				"thirdstage/exercise/xml/relaxng/Order.component.java.xml", System.out);

		System.out.println("ending " + method);
		Assert.assertTrue(result);
	}
	
	
	@Test
	public void testValidationOverridingForInvalidXml1() throws Exception{
		
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("starting " + method);
		
		boolean result = this.validateAndPrint("thirdstage/exercise/xml/relaxng/component.java.rnc", 
				"thirdstage/exercise/xml/relaxng/Order.component.xml", System.out);

		System.out.println("ending " + method);
		Assert.assertTrue(result);
	}

	@Test
	public void testValidationOverridingForInvalidXml2() throws Exception{
		
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("starting " + method);
		
		boolean result = this.validateAndPrint("thirdstage/exercise/xml/relaxng/component.java.rnc", 
				"thirdstage/exercise/xml/relaxng/Order-invalid.component.java.xml", System.out);

		System.out.println("ending " + method);
		Assert.assertTrue(result);
	}	
	
	private boolean validateAndPrint(String pathForSchema, String pathForXml, PrintStream target) throws Exception{
		

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.RELAXNG_NS_URI);
		Schema schema = sf.newSchema(ClassLoader.getSystemResource(pathForSchema));
		Validator validator = schema.newValidator();
		
		FullCollectiveErrorHandler errorHandler = new FullCollectiveErrorHandler();
		validator.setErrorHandler(errorHandler);
		
		try{
			validator.validate(new StreamSource(ClassLoader.getSystemResourceAsStream(pathForXml)));
		}catch(Exception ex){
			throw ex;
		}finally{
			errorHandler.printErrors(target);
			
		}
		
		return !errorHandler.hasError();
	}
	
	
	
}
