/**
 * 
 */
package thirdstage.exercise.xml.schematron;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;
import thirdstage.exercise.xml.schema.FullCollectiveErrorHandler;

/**
 * @author 3rdstage
 *
 */
public class ServiceMetaValidationTest1{
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public final static String SCHEMA_PATH_IN_CLASSPATH = "thirdstage/exercise/xml/schematron/service.xsd";
	
	public final static String XML_PATH_IN_CLASSPATH = "thirdstage/exercise/xml/schematron/make-order-invalid1.service.xml";
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//System.setProperty("javax.xml.parsers.SAXParserFactory", "org.apache.xerces.jaxp.SAXParserFactoryImpl");
		//System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {  
	}


	@Test
	public void validateInvalidServiceMetaWithDomParser() throws Exception{
		
		logger.debug("start validateInvalidServiceMetaWithDomParser");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", 
				XMLConstants.W3C_XML_SCHEMA_NS_URI);
		dbf.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource",
				ClassLoader.getSystemResource(SCHEMA_PATH_IN_CLASSPATH).toString());
		dbf.setNamespaceAware(true);
		dbf.setValidating(true);
		
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		FullCollectiveErrorHandler errorHandler = new FullCollectiveErrorHandler();
		db.setErrorHandler(errorHandler);
		Document doc = null;
		try{
			doc = db.parse(
				new java.io.File(ClassLoader.getSystemResource(XML_PATH_IN_CLASSPATH).toURI()));
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
		}finally{
			errorHandler.printErrors(System.err);
		}
		
		logger.debug("complete validateInvalidServiceMetaWithDomParser");
		Assert.assertTrue(errorHandler.hasError());
	}
	
	@Test
	public void validateInvalidServiceMetaWithSaxParser() throws Exception{
		
		logger.debug("start validateInvalidServiceMetaWithSaxParser");

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
			ClassLoader.getSystemResource(XML_PATH_IN_CLASSPATH).toString());

		FullCollectiveErrorHandler errorHandler = new FullCollectiveErrorHandler();
		try{
		parser.parse(new java.io.File(ClassLoader.getSystemResource(XML_PATH_IN_CLASSPATH).toURI()),
			errorHandler);
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
		}finally{
			errorHandler.printErrors(System.err);
		}

		logger.debug("complete validateInvalidServiceMetaWithSaxParser");
		Assert.assertTrue(errorHandler.hasError());
	}	
	
	
	
	@Test
	public void validateInvalidServiceMetaWithValidatorAndStreamSource() throws Exception{
		
		logger.debug("start validateValidServiceMetaWithValidatorAndStreamSource");

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(ClassLoader.getSystemResource(SCHEMA_PATH_IN_CLASSPATH));
		Validator validator = schema.newValidator();
		
		FullCollectiveErrorHandler errorHandler = new FullCollectiveErrorHandler();
		validator.setErrorHandler(errorHandler);
		
		try{
			validator.validate(new StreamSource(
				new java.io.File(ClassLoader.getSystemResource(XML_PATH_IN_CLASSPATH).toURI())));
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			
		}finally{
			errorHandler.printErrors(System.err);
		}
		
		logger.debug("complete validateValidServiceMetaWithValidatorAndStreamSource");
		Assert.assertTrue(errorHandler.hasError());
		
	}	
		

}
