package thirdstage.exercise.parsing.html.case1;

import java.io.File;
import java.net.URL;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import net.sf.saxon.Configuration;
import net.sf.saxon.lib.Validation;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.XdmNode;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.xml.sax.InputSource;

public class Krx100ParserTest {
	@BeforeClass
	public void beforeClass() {
	}


	@Test
	public void testGetLatestItemsOfKrx100() throws Exception{

		Krx100Parser parser = new Krx100Parser();
		
		
		List<Krx100Item> items = parser.getLatestItemsOfKrx100();


	}
	
	
	@Test
	public void testKrx100XmlPage() throws Exception{
		
		Configuration cfg = new Configuration();
		cfg.setSchemaValidationMode(Validation.LAX);
		cfg.setValidation(false);
		cfg.setValidationWarnings(true);
		Processor xslProcessor = new Processor(cfg);
		DocumentBuilder docBuilder = xslProcessor.newDocumentBuilder();
		
		URL url = ClassLoader.getSystemResource("thirdstage/exercise/parsing/html/case1/krx-100-list-20130606.xml");
		XdmNode doc = docBuilder.build(new File(url.toURI()));
	
	}
}
