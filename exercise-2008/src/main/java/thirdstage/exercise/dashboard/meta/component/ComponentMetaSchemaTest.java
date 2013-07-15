/**
 * 
 */
package thirdstage.exercise.dashboard.meta.component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.ext.Locator2Impl;

/**
 * @author 3rdstage
 *
 */
public class ComponentMetaSchemaTest {
	
	private static DocumentBuilder docBuilder;
	private static SAXParser saxParser;
	private static SchemaFactory w3cSchemaFactory;
	private static SchemaFactory relaxSchemaFactory;
	
	
	@BeforeTest
	public void beforeTest() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		dbf.setValidating(false);
		docBuilder = dbf.newDocumentBuilder();
		
		SAXParserFactory spf = SAXParserFactory.newInstance(); 
		spf.setNamespaceAware(true);
		spf.setValidating(false);
		saxParser = spf.newSAXParser();
		saxParser.getXMLReader().getContentHandler().setDocumentLocator(new Locator2Impl());
		
		w3cSchemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
	}

	@Test
	public void testSimpleValid() throws Exception{
		
		URL url = ClassLoader.getSystemResource("thirdstage/exercise/dashboard/meta/component/component-meta-valid.xml");
		Document doc = docBuilder.parse(new java.io.File(url.toURI()));
		//doc.renameNode(doc, "http://www.3rdstage.org/schema/component-meta", doc.getNodeName());
		
		URL url2 = ClassLoader.getSystemResource("thirdstage/exercise/dashboard/meta/component/component-meta.xsd");
		Schema schema = w3cSchemaFactory.newSchema(new StreamSource(new java.io.File(url2.toURI())));
		Validator validator = schema.newValidator();
		validator.setErrorHandler(new DefaultHandler2());
		validator.validate(new DOMSource(doc));
		
	}
	
	
	@Test
	public void testSimpleValidDocUsingSax() throws Exception{
		
		URL url = ClassLoader.getSystemResource("thirdstage/exercise/dashboard/meta/component/component-meta-valid.xml");

		InputStream fis = new FileInputStream(new java.io.File(url.toURI()));

		URL url2 = ClassLoader.getSystemResource("thirdstage/exercise/dashboard/meta/component/component-meta.xsd");
		Schema schema = w3cSchemaFactory.newSchema(new StreamSource(new java.io.File(url2.toURI())));
		Validator validator = schema.newValidator();
		validator.validate(new SAXSource(saxParser.getXMLReader(), new InputSource(fis)));
		
	}
}
