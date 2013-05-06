package thirdstage.exercise.parsing.html.case1;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StockCodeParserTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test(enabled=true)
	public void testParseStockCodes() throws Exception{

		URL url = ClassLoader.getSystemResource("thirdstage/exercise/parsing/html/case1/krx-stock-code-20130503.html");

		List<StockCode> codes = StockCodeParser.parseStockCodes(new File(url.toURI()),  "EUC-KR");
		Assert.assertTrue(codes.size() > 100);
	}

	@Test
	public void testParseStockCodesIntoJSONArry() throws Exception{

		URL url = ClassLoader.getSystemResource("thirdstage/exercise/parsing/html/case1/krx-stock-code-20130503.html");

		JSONArray codes = StockCodeParser.parseStockCodesIntoJSONArry(new File(url.toURI()), "EUC-KR");
		System.out.println(codes.toString(2));
		Assert.assertTrue(codes.length() > 100);
	}

	@Test(enabled=true)
	public void testParseStockCodesIntoFile() throws Exception{
		URL url = ClassLoader.getSystemResource("thirdstage/exercise/parsing/html/case1/krx-stock-code-20130503.html");
		String trgPath = System.getProperty("user.dir") + "/target/krx-stock-code-20130503.json";

		StockCodeParser.parseStockCodesIntoFile(new File(url.toURI()), "EUC-KR", trgPath, "UTF-8", true);

	}

	@Test
	public void testSlf4jLogger(){

		Logger logger = LoggerFactory.getLogger(this.getClass());
		Logger logger2 = LoggerFactory.getLogger(StockCodeParserTest.class);

		Assert.assertEquals(logger2, logger);
		Assert.assertEquals(logger2.hashCode(), logger.hashCode());
		Assert.assertTrue(logger2 == logger);
	}

	@Test
	public void testSystemVariables(){

		Properties props = System.getProperties();
		Set<Map.Entry<Object, Object>> entries = props.entrySet();

		for(Map.Entry<Object, Object> entry: entries){
			System.out.printf("%1s = %2s\n", entry.getKey(), entry.getValue());
		}
	}

	@Test
	public void testJsoup() throws Exception{
		URL url = ClassLoader.getSystemResource("thirdstage/exercise/parsing/html/case1/krx-stock-code-only-10.html");
		File f = new File(url.toURI());

		Document doc = Jsoup.parse(f, "EUC-KR");

		Elements issuerCodes = doc.select("tr:gt(0) > td:eq(0)");
		Assert.assertEquals(issuerCodes.size(), 10);

		issuerCodes = doc.select("body table tr:gt(0) > td:eq(0)");
		Assert.assertEquals(issuerCodes.size(), 10);

		issuerCodes = doc.select("body > table > tr"); //You can't use multiple child operator in a expression
		Assert.assertEquals(issuerCodes.size(), 0); //the result is 0 not 11.

		issuerCodes = doc.select("body > table > tr:gt(0)"); //You can't use multiple child operator in a expression
		Assert.assertEquals(issuerCodes.size(), 0);

		issuerCodes = doc.select("table > tr:gt(0)"); //Can't understand ???. See the next one.
		Assert.assertEquals(issuerCodes.size(), 0); //Don't use child combinator except very simple case.

		issuerCodes = doc.select("table tr:gt(0)"); //Just as expected.
		Assert.assertEquals(issuerCodes.size(), 10);

		issuerCodes = doc.select("table tr:eq(1) td:eq(0)");
		Assert.assertEquals(issuerCodes.size(), 1);
		logger.info("selector : 'table tr:eq(1) td:eq(0)' -" + issuerCodes.toString());

		issuerCodes = doc.select("table:eq(0) tr:eq(1) td");
		Assert.assertEquals(issuerCodes.size(), 6);
		logger.info("selector : 'table:eq(0) tr:eq(1) td' -" + issuerCodes.toString());

	}


	@Test
	public void testHtmlToJson() throws Exception{
		URL url = ClassLoader.getSystemResource("thirdstage/exercise/parsing/html/case1/krx-stock-code-only-10.html");
		File f = new File(url.toURI());

		Document doc = Jsoup.parse(f, "EUC-KR");
		Elements codes = doc.select("table tr:gt(0)");

		JSONArray codes2 = new JSONArray();
		JSONObject code2 = new JSONObject();
		Element code = null;
		for(int i = 0, n = codes.size(); i < n; i++){
			code = codes.get(i);
			code2.put("issuerCode", code.child(0).ownText());
			code2.put("issue", code.child(1).ownText());
			code2.put("issueInEng", code.child(2).ownText());
			code2.put("code", code.child(3).ownText());
			code2.put("shortCode", code.child(4).ownText());
			code2.put("marketType", code.child(5).ownText());
			codes2.put(code2);
		}

		JSONObject result = new JSONObject();
		result.put("codes", codes2);

		System.out.println(result.toString(2));
		Assert.assertEquals(codes2.length(), 10);
	}

}
