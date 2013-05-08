/**
 *
 */
package thirdstage.exercise.xml.saxon;

import java.io.File;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.dom.DOMSource;

import net.sf.saxon.Configuration;
import net.sf.saxon.dom.DocumentBuilderImpl;
import net.sf.saxon.lib.ParseOptions;
import net.sf.saxon.lib.Validation;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.XQueryCompiler;
import net.sf.saxon.s9api.XQueryEvaluator;
import net.sf.saxon.s9api.XQueryExecutable;
import net.sf.saxon.s9api.XdmValue;

import org.testng.annotations.Test;
import org.w3c.dom.Document;

/**
 * @author 3rdstage
 *
 */
public class Saxon4HtmlTest {

	@Test
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

		DocumentBuilder docBuilder = new DocumentBuilderImpl();
		URL url = ClassLoader.getSystemResource("thirdstage/exercise/xml/saxon/krx-stock-code-only-10.html");
		Document doc = docBuilder.parse(new File(url.toURI()));

		XQueryCompiler xqc = proc.newXQueryCompiler();
		XQueryExecutable xqe = xqc.compile("for $x in //body/table/tr/td[1]/child::text() return $x");
		XQueryEvaluator xqev = xqe.load();
		xqev.setSource(new DOMSource(doc));

		XdmValue result = xqev.evaluate();


	}

}
