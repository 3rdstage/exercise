/**
 *
 */
package thirdstage.exercise.xml.saxon;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;

import net.sf.saxon.Configuration;
import net.sf.saxon.dom.DocumentBuilderImpl;
import net.sf.saxon.lib.ParseOptions;
import net.sf.saxon.lib.Validation;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.XPathCompiler;
import net.sf.saxon.s9api.XPathExecutable;
import net.sf.saxon.s9api.XQueryCompiler;
import net.sf.saxon.s9api.XQueryEvaluator;
import net.sf.saxon.s9api.XQueryExecutable;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;

import org.ccil.cowan.tagsoup.Parser;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * @author 3rdstage
 *
 */
public class Saxon4HtmlTest {

	/**
	 * This test is expected to throw exception, 'cause Saxson can't parse pure HTML directly.
	 * But Saxon alongside with TagSoup seems to make it possible to parse HTML.
	 *
	 * @throws Exception
	 */
	@Test(expectedExceptions={Exception.class})
	public void testXqueryOnHtml() throws Exception{

		Configuration cfg = new Configuration();
		cfg.setSchemaValidationMode(Validation.LAX);
		cfg.setValidation(false);
		cfg.setValidationWarnings(true);
		Processor proc = new Processor(cfg);

		ParseOptions po = new ParseOptions();
		po.setCheckEntityReferences(false);
		po.setContinueAfterValidationErrors(true);
		po.setDTDValidationMode(Validation.LAX);
		po.setUseXsiSchemaLocation(false);

		DocumentBuilderImpl db = new DocumentBuilderImpl();
		db.setParseOptions(po);

		URL url = ClassLoader.getSystemResource("thirdstage/exercise/xml/saxon/krx-stock-code-only-10.html");
		Document doc = db.parse(new File(url.toURI()));

		XQueryCompiler xqc = proc.newXQueryCompiler();
		XQueryExecutable xqe = xqc.compile("for $x in //body/table/tr/td[1]/child::text() return $x");
		XQueryEvaluator xqev = xqe.load();
		xqev.setSource(new DOMSource(doc));

		XdmValue result = xqev.evaluate();
	}


	@Test
	public void testXqueryOnHtmlAlongWithTagSoup() throws Exception{

		Configuration cfg = new Configuration();
		cfg.setSchemaValidationMode(Validation.LAX);
		cfg.setValidation(false);
		cfg.setValidationWarnings(true);
		Processor proc = new Processor(cfg);

		URL url = ClassLoader.getSystemResource("thirdstage/exercise/xml/saxon/krx-stock-code-only-10.html");
		XMLReader xr = new Parser();
		//xr.setFeature(Parser.namespacesFeature, false);
		Source src = new SAXSource(xr, new InputSource(new FileInputStream(new File(url.toURI()))));
		net.sf.saxon.s9api.DocumentBuilder db = proc.newDocumentBuilder();
		XdmNode input = db.build(src);

		String qr = new StringBuilder()
			.append("declare default element namespace \"http://www.w3.org/1999/xhtml\";\n")
			.append("for $x in /html/body[1]/table[1]/tr/td[1]/child::text() return $x").toString();
		XQueryCompiler xqc = proc.newXQueryCompiler();
		XQueryExecutable xqe = xqc.compile(qr);
		XQueryEvaluator xqev = xqe.load();
		xqev.setSource(input.asSource());

		XdmValue result = xqev.evaluate();

		System.out.printf("The result of query contains %1$d items.\n", result.size());
		System.out.printf(result.toString());
	}



	@Test
	public void testXpathOnHtmlAlongWithTagSoup() throws Exception{

		Configuration cfg = new Configuration();
		cfg.setSchemaValidationMode(Validation.LAX);
		cfg.setValidation(false);
		cfg.setValidationWarnings(true);
		Processor proc = new Processor(false);

		URL url = ClassLoader.getSystemResource("thirdstage/exercise/xml/saxon/krx-stock-code-only-10.html");
		XMLReader xr = new Parser();
		xr.setFeature(Parser.namespacesFeature, false);
		xr.setFeature("http://xml.org/sax/features/namespaces", false);
		xr.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
		Source src = new SAXSource(xr, new InputSource(new FileInputStream(new File(url.toURI()))));
		net.sf.saxon.s9api.DocumentBuilder db = proc.newDocumentBuilder();
		XdmNode input = db.build(src);

		XPathCompiler xpc = proc.newXPathCompiler();
		XdmValue result = xpc.evaluate("//*[local-name()='tr']", input);

		System.out.printf("The result of query contains %1$d items.\n", result.size());
		System.out.printf(result.toString());
	}
}
