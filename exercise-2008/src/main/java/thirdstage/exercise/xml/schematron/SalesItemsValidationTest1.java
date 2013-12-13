package thirdstage.exercise.xml.schematron;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.oclc.purl.dsdl.svrl.FailedAssert;
import org.oclc.purl.dsdl.svrl.SchematronOutputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.phloc.schematron.ISchematronResource;
import com.phloc.schematron.pure.SchematronResourcePure;
import thirdstage.exercise.xml.schema.FullCollectiveErrorHandler;

public class SalesItemsValidationTest1 {


	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public final static String SCHEMA_PATH_IN_CLASSPATH = "thirdstage/exercise/xml/schematron/sales-items.xsd";
	
	public final static String SCHEMATRON_PATH_IN_CLASSPATH = "thirdstage/exercise/xml/schematron/sales-items.sch";
	
	public final static String VALID_XML_PATH_IN_CLASSPATH = "thirdstage/exercise/xml/schematron/sales-items-valid.xml";

	public final static String INVALID_XML_PATH_IN_CLASSPATH = "thirdstage/exercise/xml/schematron/sales-items-invalid.xml";

	@Test
	public void testValidSalesItemsWithSchema() throws Exception{
		
		logger.debug("start testValidSalesItemsWithSchema");

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(ClassLoader.getSystemResource(SCHEMA_PATH_IN_CLASSPATH));
		Validator validator = schema.newValidator();
		
		FullCollectiveErrorHandler errorHandler = new FullCollectiveErrorHandler();
		validator.setErrorHandler(errorHandler);
		
		try{
			validator.validate(new StreamSource(
				new java.io.File(ClassLoader.getSystemResource(VALID_XML_PATH_IN_CLASSPATH).toURI())));
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			
		}finally{
			errorHandler.printErrors(System.err);
		}
		
		logger.debug("complete testValidSalesItemsWithSchema");
		Assert.assertTrue(!errorHandler.hasError());
		
	}	

	/**
	 * The testee XML of this test contains invalid date in general view point.
	 * For example, the min value is greater than max value.
	 * But you can't detect those using XML schema.
	 *
	 * @throws Exception
	 */
	@Test
	public void testInvalidSalesItemsButNotDetectableWithXmlSchema() throws Exception{
		
		logger.debug("start testInvalidSalesItemsButNotDetectableWithXmlSchema");

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(ClassLoader.getSystemResource(SCHEMA_PATH_IN_CLASSPATH));
		Validator validator = schema.newValidator();
		
		FullCollectiveErrorHandler errorHandler = new FullCollectiveErrorHandler();
		validator.setErrorHandler(errorHandler);
		
		try{
			validator.validate(new StreamSource(
				new java.io.File(ClassLoader.getSystemResource(INVALID_XML_PATH_IN_CLASSPATH).toURI())));
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			
		}finally{
			errorHandler.printErrors(System.err);
		}
		
		logger.debug("complete testInvalidSalesItemsButNotDetectableWithXmlSchema");
		Assert.assertTrue(!errorHandler.hasError());
		
	}	
	

	/**
	 * Validate the invalid XML but can't detectable with XML schema only
	 * using Schematron.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInvalidSalesItemsUsingSchematron() throws Exception{
		
		logger.debug("start testInvalidSalesItemsUsingSchematron");

		File fSch = new File(ClassLoader.getSystemResource(SCHEMATRON_PATH_IN_CLASSPATH).toURI());
		File fXml = new File(ClassLoader.getSystemResource(INVALID_XML_PATH_IN_CLASSPATH).toURI());
		
		ISchematronResource sch = SchematronResourcePure.fromFile(fSch);
		
		if(!sch.isValidSchematron()){
			Assert.fail("Invalid schematron : " + fSch.getCanonicalPath());
		}
		
		SchematronOutputType output = sch.applySchematronValidationToSVRL(new StreamSource(fXml));
		if(output != null){
			List<Object> objs = output.getActivePatternAndFiredRuleAndFailedAssert(); //non-null
			List<FailedAssert> faileds = new ArrayList<FailedAssert>();
		
			for(Object obj : objs){
				if(obj instanceof FailedAssert) faileds.add((FailedAssert)obj);
			}
			for(FailedAssert failed : faileds){
				logger.error(failed.toString());
			}
			Assert.assertTrue(faileds.isEmpty());
		}else{
			Assert.assertTrue(true);
		}
	}	
	
}
