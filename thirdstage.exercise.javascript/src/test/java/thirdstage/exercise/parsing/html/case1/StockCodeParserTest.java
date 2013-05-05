package thirdstage.exercise.parsing.html.case1;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StockCodeParserTest {

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
		Assert.assertEquals(issuerCodes.size(), 11);
		
		issuerCodes = doc.select("body > table > tr:gt(0)"); //You can't use multiple child operator in a expression
		Assert.assertEquals(issuerCodes.size(), 0);
		
		issuerCodes = doc.select("table > tr:gt(0)"); //Can't understand ???. See the next one.
		Assert.assertEquals(issuerCodes.size(), 0); //Don't use child combinator except very simple case.
		
		issuerCodes = doc.select("table tr:gt(0)"); //Just as expected.
		Assert.assertEquals(issuerCodes.size(), 10);
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
