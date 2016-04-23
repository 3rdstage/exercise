package thirdstage.exercise.parsing.html.case1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import junit.framework.Assert;

import net.sf.saxon.Configuration;
import net.sf.saxon.lib.Validation;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.XQueryCompiler;
import net.sf.saxon.s9api.XQueryEvaluator;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;

import org.apache.commons.validator.routines.DoubleValidator;
import org.ccil.cowan.tagsoup.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class NaverFinanceParser2Test {
	
	public static Logger logger = LoggerFactory.getLogger(NaverFinanceParser2Test.class);

	@Test
	public void testParseDailySummaryByStock() throws Exception {

		URL url = ClassLoader.getSystemResource("thirdstage/exercise/parsing/html/case1/NaverFinanceMeta2.properties");

		NaverFinanceParser2 parser = new NaverFinanceParser2(new File(url.toURI()));

		DailySummaryByStock summary = parser.parseDailySummaryByStock("003920");
		
		logger.info(summary.toString());
		
		Assert.assertNotNull(summary.prevClosingPrice);
	}
	
	@Test
	public void testParseDailySummaryByStock2() throws Exception{
		
	}

	@Test
	public void testHtmlInputStream() throws Exception{

		URL url = new URL("http://finance.naver.com/item/fchart.nhn?code=003920");

		BufferedReader br = null;
		StringBuilder sb = null;
		try{
			br = new BufferedReader(new InputStreamReader(url.openStream(), "euc-kr"));
			sb = new StringBuilder();
			String str = null;
			while((str = br.readLine()) != null){
				sb.append(str).append("\n");
			}

			str = sb.toString().trim();
			Assert.assertTrue(str.endsWith("</html>"));
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			if(br != null){
				try{ br.close(); }
				catch(Exception ex){}
			}
		}
	}


	@Test
	public void testHtmlInputStream2() throws Exception{

		URL url = new URL("http://finance.naver.com/item/fchart.nhn?code=003920");

		URLConnection conn = null;
		BufferedReader br = null;
		try{
			conn = url.openConnection();
			conn.connect();
			int len = conn.getContentLength();

			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "euc-kr"));
			char[] chars = new char[len];
			br.read(chars);

			String str = new String(chars); 
			Assert.assertTrue(str.trim().endsWith("</html>"));

		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			if(br != null){
				try{ br.close(); }
				catch(Exception ex){}
			}
		}
	}


	/**
	 * This method is intended in ad-hoc usage, and so completely ignoring performance.
	 * 
	 * @param url
	 * @param qry
	 * @return
	 * @throws Exception
	 */
	public XdmValue getValueFromNaverFinanceDailySummary(URL url, String qry) throws Exception{

		Configuration cfg = new Configuration();
		cfg.setSchemaValidationMode(Validation.LAX);
		cfg.setValidation(false);
		cfg.setValidationWarnings(true);
		Processor xslProcessor = new Processor(cfg);
		DocumentBuilder docBuilder = xslProcessor.newDocumentBuilder();
		
		XMLReader xr = new Parser();
		InputSource in = new InputSource(url.openStream());
		in.setEncoding("euc-kr");
		Source src = new SAXSource(xr, in);
		XdmNode doc = docBuilder.build(src);

		String namespaceDecl = "declare default element namespace \"http://www.w3.org/1999/xhtml\";\n";
		XQueryEvaluator xqev 
			= xslProcessor.newXQueryCompiler().compile(namespaceDecl + qry).load();
		xqev.setSource(doc.asSource());

		return xqev.evaluate();
	}
	
	@Test
	public void testNaverFinanceDailySummary1() throws Exception{
		URL url = new URL("http://finance.naver.com/item/main.nhn?code=003920");
		String qry = "for $x in //div[@id='chart_area']/div[@class='rate_info']/table[@class='no_info']/tr[1]/td[1]/em[1]/span[@class='blind']/text() return fn:translate($x, ',', '')";

		XdmValue value = getValueFromNaverFinanceDailySummary(url, qry);
		
		Assert.assertTrue(value.size() > 0);
		System.out.printf("Value : %1$s\n", value.toString());
		System.out.printf("Value : %1$f\n", DoubleValidator.getInstance().validate(value.toString(), "0,000"));
		
	}
}
