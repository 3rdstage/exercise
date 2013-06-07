package thirdstage.exercise.parsing.html.case1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;

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
		String trg = System.getProperty("user.home") + "/krx-100.xls";
		
		System.out.println(System.getProperty("user.dir"));
		InputStream is = null;
		FileOutputStream fos = null;
		
		URLConnection conn = url.openConnection();
		Object obj = conn.getContent();
		
		ObjectOutputStream oos = null;
	}	
	
}
