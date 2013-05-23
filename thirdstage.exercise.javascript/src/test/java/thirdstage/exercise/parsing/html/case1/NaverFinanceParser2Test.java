package thirdstage.exercise.parsing.html.case1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import junit.framework.Assert;

import org.testng.annotations.Test;

public class NaverFinanceParser2Test {

  @Test
  public void parseDailySummaryByStock() throws Exception {
    
    URL url = ClassLoader.getSystemResource("thirdstage/exercise/parsing/html/case1/NaverFinanceMeta2.properties");
    
    NaverFinanceParser2 parser = new NaverFinanceParser2(new File(url.toURI()));
    
    DailySummaryByStock summary = parser.parseDailySummaryByStock("003920");
    
    
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
}
