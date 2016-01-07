/**
 * 
 */
package thirdstage.exercise.xml.schema;



import java.io.PrintStream;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
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
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author 3rdstage
 *
 */
public class ComponentMetaValidationTest {

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
	public void testComponentValidationWithDom() throws Exception{
		
		System.out.println("start testComponentValidationWithDom");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		dbf.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource",
				ClassLoader.getSystemResource("thirdstage/exercise/xml/schema/component-1.0.xsd").toString());
		dbf.setNamespaceAware(true);
		dbf.setValidating(true);
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = db.parse(ClassLoader.getSystemResourceAsStream("thirdstage/exercise/xml/schema/Order.component.xml"));

		System.out.println("complete testComponentValidationWithDom");
		Assert.assertTrue(true);

	}
	
	@Test
	public void testComponentValidationWithDomForInvalidXml() throws Exception{
		
		System.out.println("start testComponentValidationWithDomForInvalidXml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", 
				XMLConstants.W3C_XML_SCHEMA_NS_URI);
		dbf.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource",
				ClassLoader.getSystemResource("thirdstage/exercise/xml/schema/component-1.0.xsd").toString());
		dbf.setNamespaceAware(true);
		dbf.setValidating(true);
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = db.parse(ClassLoader.getSystemResourceAsStream("thirdstage/exercise/xml/schema/Order-invalid.component.xml"));

		System.out.println("complete testComponentValidationWithDomForInvalidXml");
		Assert.assertTrue(true);
		
	}	
	
	
	@Test
	public void testComponentValidationWithSax() throws Exception{
		
		System.out.println("start testComponentValidationWithSax");

		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);
		spf.setValidating(true);
		spf.setFeature("http://xml.org/sax/features/validation", true);
		spf.setFeature("http://apache.org/xml/features/validation/schema", true);
		spf.setFeature("http://apache.org/xml/features/validation/schema-full-checking", true);
		
		SAXParser parser = spf.newSAXParser();
		parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", 
				XMLConstants.W3C_XML_SCHEMA_NS_URI);
		parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaSource",
			ClassLoader.getSystemResource("thirdstage/exercise/xml/schema/component-1.0.xsd").toString());

		parser.parse(ClassLoader.getSystemResourceAsStream("thirdstage/exercise/xml/schema/Order.component.xml"),
				new DefaultHandler());
		
		
		System.out.println("complete testComponentValidationWithSax");
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void testComponentValidationWithSaxForInvalidXml() throws Exception{
		
		System.out.println("start testComponentValidationWithSaxForInvalidXml");

		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);
		spf.setValidating(true);
		spf.setFeature("http://xml.org/sax/features/validation", true);
		spf.setFeature("http://apache.org/xml/features/validation/schema", true);
		spf.setFeature("http://apache.org/xml/features/validation/schema-full-checking", true);
		
		SAXParser parser = spf.newSAXParser();
		parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", 
				XMLConstants.W3C_XML_SCHEMA_NS_URI);
		parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaSource",
			ClassLoader.getSystemResource("thirdstage/exercise/xml/schema/component-1.0.xsd").toString());

		parser.parse(ClassLoader.getSystemResourceAsStream("thirdstage/exercise/xml/schema/Order-invalid.component.xml"),
				new DefaultHandler());
		
		
		System.out.println("complete testComponentValidationWithSaxForInvalidXml");
		Assert.assertTrue(true);
		
	}
	
	
	@Test
	public void testComponentValidationWithValidatorAndDomSourceForInvalidXml() throws Exception{
		
		System.out.println("start testComponentValidationWithValidatorAndDomSourceForInvalidXml");

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(ClassLoader.getSystemResource("thirdstage/exercise/xml/schema/component-1.0.xsd"));
		Validator validator = schema.newValidator();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(ClassLoader.getSystemResourceAsStream("thirdstage/exercise/xml/schema/Order-invalid.component.xml"));
		
		FullCollectiveErrorHandler errorHandler = new FullCollectiveErrorHandler();
		validator.setErrorHandler(errorHandler);
		
		try{
			validator.validate(new DOMSource(doc));
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			
		}finally{
			errorHandler.printErrors(System.err);
		}
		
		System.out.println("complete testComponentValidationWithValidatorAndDomSourceForInvalidXml");
		Assert.assertTrue(!errorHandler.hasError());
		
	}
	
	@Test
	public void testComponentValidationWithValidatorAndSaxSourceForInvalidXml() throws Exception{
		
		System.out.println("start testComponentValidationWithValidatorAndSaxSourceForInvalidXml");

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(ClassLoader.getSystemResource("thirdstage/exercise/xml/schema/component-1.0.xsd"));
		Validator validator = schema.newValidator();
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);
		spf.setValidating(false);
		spf.setFeature("http://xml.org/sax/features/validation", false);
		
		SAXSource src = new SAXSource(spf.newSAXParser().getXMLReader(), 
				new InputSource(ClassLoader.getSystemResourceAsStream("thirdstage/exercise/xml/schema/Order-invalid.component.xml")));
		
		FullCollectiveErrorHandler errorHandler = new FullCollectiveErrorHandler();
		validator.setErrorHandler(errorHandler);
		
		try{
			validator.validate(src);
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			
		}finally{
			errorHandler.printErrors(System.err);
		}
		
		System.out.println("complete testComponentValidationWithValidatorAndSaxSourceForInvalidXml");
		Assert.assertTrue(!errorHandler.hasError());
		
	}

	@Test
	public void testComponentValidationWithValidatorAndStreamSourceForInvalidXml() throws Exception{
		
		System.out.println("start testComponentValidationWithValidatorAndStreamSourceForInvalidXml");

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(ClassLoader.getSystemResource("thirdstage/exercise/xml/schema/component-1.0.xsd"));
		Validator validator = schema.newValidator();
		
		FullCollectiveErrorHandler errorHandler = new FullCollectiveErrorHandler();
		validator.setErrorHandler(errorHandler);
		
		try{
			validator.validate(new StreamSource(ClassLoader.getSystemResourceAsStream("thirdstage/exercise/xml/schema/Order-invalid.component.xml")));
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			
		}finally{
			errorHandler.printErrors(System.err);
		}
		
		System.out.println("complete testComponentValidationWithValidatorAndStreamSourceForInvalidXml");
		Assert.assertTrue(!errorHandler.hasError());
		
	}

	@Test
	public void testComponentValidationWithValidatorAndStreamSourceForValidXml() throws Exception{
		
		System.out.println("start testComponentValidationWithValidatorAndStreamSourceForInvalidXml");

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(ClassLoader.getSystemResource("thirdstage/exercise/xml/schema/component-1.0.xsd"));
		Validator validator = schema.newValidator();
		
		FullCollectiveErrorHandler errorHandler = new FullCollectiveErrorHandler();
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



