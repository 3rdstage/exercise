/**
 * 
 */
package thirdstage.exercise.xml.schematron;

import java.io.File;
import java.util.ArrayList;
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
import org.oclc.purl.dsdl.svrl.FailedAssert;
import org.oclc.purl.dsdl.svrl.SchematronOutputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;
import com.phloc.schematron.ISchematronResource;
import com.phloc.schematron.pure.SchematronResourcePure;
import thirdstage.exercise.xml.schema.FullCollectiveErrorHandler;

/**
 * @author 3rdstage
 *
 */
public class ServiceMetaValidationTest2{
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public final static String SCHEMA_PATH_IN_CLASSPATH = "thirdstage/exercise/xml/schematron/service.xsd";
	
	public final static String SCHEMATRON_PATH_IN_CLASSPATH = "thirdstage/exercise/xml/schematron/service.sch"; 
	
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
	public void validateInvalidServiceMetaWithSchematron() throws Exception{
		
		logger.debug("start validateValidServiceMetaWithValidatorAndStreamSource");

		File fSch = new File(ClassLoader.getSystemResource(SCHEMATRON_PATH_IN_CLASSPATH).toURI());
		File fXml = new File(ClassLoader.getSystemResource(XML_PATH_IN_CLASSPATH).toURI());
		
		ISchematronResource sch = SchematronResourcePure.fromFile(fSch);
		
		if(!sch.isValidSchematron()){
			Assert.fail("Invalid schematron : " + fSch.getCanonicalPath());
		}
		
		boolean isValid = sch.getSchematronValidity(new StreamSource(fXml)).isValid();
		
		Assert.assertTrue(isValid);
	}	
	
	
	@Test
	public void validateInvalidServiceMetaWithSchematron2() throws Exception{
		
		logger.debug("start validateValidServiceMetaWithValidatorAndStreamSource");

		File fSch = new File(ClassLoader.getSystemResource(SCHEMATRON_PATH_IN_CLASSPATH).toURI());
		File fXml = new File(ClassLoader.getSystemResource(XML_PATH_IN_CLASSPATH).toURI());
		
		ISchematronResource sch = SchematronResourcePure.fromFile(fSch);
		
		if(!sch.isValidSchematron()){
			Assert.fail("Invalid schematron : " + fSch.getCanonicalPath());
		}
		
		SchematronOutputType output = sch.applySchematronValidationToSVRL(new StreamSource(fXml));
		List<Object> objs = output.getActivePatternAndFiredRuleAndFailedAssert();
		List<FailedAssert> faileds = new ArrayList<FailedAssert>();
		
		for(Object obj : objs){
			if(obj instanceof FailedAssert) faileds.add((FailedAssert)obj);
		}
		
		for(FailedAssert failed : faileds){
			System.out.println(failed.toString());
		}
		
		
		
		
		
	}

}
