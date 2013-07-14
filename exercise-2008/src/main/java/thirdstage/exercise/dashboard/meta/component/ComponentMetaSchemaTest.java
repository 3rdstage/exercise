/**
 * 
 */
package thirdstage.exercise.dashboard.meta.component;

import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

/**
 * @author 3rdstage
 *
 */
public class ComponentMetaSchemaTest {
	
	private static DocumentBuilder docBuilder;
	private static SchemaFactory w3cSchemaFactory;
	private static SchemaFactory relaxSchemaFactory;
	
	
	@BeforeTest
	public void beforeTest() throws Exception{
		docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		w3cSchemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
	}

	@Test
	public void testSimpleValid() throws Exception{
		
		URL url = ClassLoader.getSystemResource("thirdstage/exercise/dashboard/meta/component/component-meta-valid.xml");
		Document doc = docBuilder.parse(new java.io.File(url.toURI()));
		
		URL url2 = ClassLoader.getSystemResource("thirdstage/exercise/dashboard/meta/component/component-meta.xsd");
		Schema schema = w3cSchemaFactory.newSchema(new StreamSource(new java.io.File(url2.toURI())));
		Validator validator = schema.newValidator();
		validator.validate(new DOMSource(doc));
		
	}
	
}
