/**
 * 
 */
package thirdstage.exercise.xml.schema;

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

/**
 * @author 3rdstage
 *
 */
public class ComponentMetaValidationWithRedefinedSchemaTest {
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("javax.xml.parsers.SAXParserFactory", "org.apache.xerces.jaxp.SAXParserFactoryImpl");
		System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");
		
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
	public void testGeneralValidMetaWithRedefinedSchema() throws Exception{
		
		System.out.println("start testGeneralValidMetaWithRedefinedSchema");

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(ClassLoader.getSystemResource("thirdstage/exercise/xml/schema/component-1.0.java.xsd"));
		Validator validator = schema.newValidator();
		
		NormalCollectiveErrorHandler errorHandler = new NormalCollectiveErrorHandler();
		validator.setErrorHandler(errorHandler);
		
		try{
			validator.validate(new StreamSource(ClassLoader.getSystemResourceAsStream("thirdstage/exercise/xml/schema/Order.component.xml")));
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			
		}finally{
			errorHandler.printErrors(System.err);
		}
		
		System.out.println("complete testComponentValidationWithValidatorAndStreamSourceForInvalidXml");
		Assert.assertTrue(!errorHandler.hasError());
		
	}	
}
