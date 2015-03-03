package thirdstage.exercise.parsing.html.case1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.ContentEncodingHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KrxIndexTest {


	/**
	 * Useless. The URL ending with '?' is wrong !!!
	 * 
	 * @throws Exception
	 */
	@Test
	public void testKrx100Download() throws Exception{

		String str = "http://www.krx.co.kr/por_kor/m1/m1_4/m1_4_2/m1_4_2_1/JHPKOR01004_02_01_05.jsp?";
		URL url = new URL(str);
		String trg = System.getProperty("user.home") + "/krx-100.xls";
		
		System.out.println(System.getProperty("user.dir"));
		InputStream is = null;
		FileOutputStream fos = null;

		try{
			File f = new File(trg);
			f.createNewFile();
			is = url.openStream();
			fos = new FileOutputStream(f);

			int b = -1;
			while((b = is.read()) != -1){
				fos.write(b);
			}
		}catch(Exception ex){
			throw ex;
		}finally{
			if(is != null) is.close();
			if(fos != null) fos.close();
		}

		Assert.assertTrue(true);
	}

	/**
	 * Useless. The URL ending with '?' is wrong !!!
	 * 
	 * @throws Exception
	 */
	@Test
	public void testKrx100Download2() throws Exception{

		String src = "http://www.krx.co.kr/por_kor/m1/m1_4/m1_4_2/m1_4_2_1/JHPKOR01004_02_01_05.jsp?";
		URL url = new URL(src);
		String trg = System.getProperty("user.dir") + "/target/krx-100.xls";
		
		InputStream is = null;
		FileOutputStream fos = null;
		
		URLConnection conn = url.openConnection();
		Object obj = conn.getContent();
		
		ObjectOutputStream oos = null;
	}
	

	/**
	 * Okay. the response is gzipped. So, we need more than java.net.URL 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testKrx100Download3() throws Exception{
		String src = "http://www.krx.co.kr/por_kor/m1/m1_4/m1_4_2/m1_4_2_1/JHPKOR01004_02_01_05.jsp?noScript=Y&work_dt=";
		URL url = new URL(src);
		String trg = System.getProperty("user.dir") + "/target/krx-100.html";
		
		InputStream is = null;
		FileOutputStream fos = null;

		try{
			File f = new File(trg);
			f.createNewFile();
			is = url.openStream();
			fos = new FileOutputStream(f);

			int b = -1;
			while((b = is.read()) != -1){
				fos.write(b);
			}
		}catch(Exception ex){
			throw ex;
		}finally{
			if(is != null) is.close();
			if(fos != null) fos.close();
		}

		Assert.assertTrue(true);		
	}
	
	
	@Test
	public void testKrx100Download4() throws Exception{
		String url = "http://www.krx.co.kr/por_kor/m1/m1_4/m1_4_2/m1_4_2_1/JHPKOR01004_02_01_05.jsp?noScript=Y&work_dt=";
		
		HttpClient hc = new ContentEncodingHttpClient();
		HttpGet hg = new HttpGet(url);
		String trg = System.getProperty("user.dir") + "/target/krx-100.html";
		
		HttpResponse resp = hc.execute(hg);
		InputStream is = null;
		FileOutputStream fos = null;
		
		try{
			HttpEntity ent = resp.getEntity();
			is = ent.getContent();
			
			File f = new File(trg);
			fos = new FileOutputStream(f);
			
			int b = -1;
			while((b = is.read()) != -1){
				fos.write(b);
			}
		}catch(Exception ex){
			throw ex;
		}finally{
			if(is != null){
				try{ is.close(); }catch(Exception ex){}
			}
			if(fos != null){
				try{ fos.close(); }catch(Exception ex){}
			}
			if(hg != null) hg.releaseConnection();
		}
		
	}
	
}
