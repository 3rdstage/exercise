/**
 * 
 */
package thirdstage.exercise.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * @author 3rdstage
 *
 */
public class IoTest{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void testUnclosedStream1() throws Exception{
		
		String dir = System.getProperty("user.home");

		System.out.println("Press [Enter] key to start.");
		int cnt;
		while((cnt = System.in.available()) < 1){
			Thread.currentThread().sleep(500);
		}
		while(cnt-- > 0) System.in.read();

		String path1 = dir + "\\.m2\\settings.xml";
		long n1 = this.getNumberOfBytes(path1);
	
		System.out.printf("The size of %1$s : %2$d\n", path1, n1);
		System.out.println("Press [Enter] key to proceed.");
		while((cnt = System.in.available()) < 1){
			Thread.currentThread().sleep(500);
		}
		while(cnt-- > 0) System.in.read();
 
		String path2 = dir + "\\.m2\\settings-security.xml";
		long n2 = this.getNumberOfBytesLeavingUnclosedStream(path2);

		System.out.printf("The size of %1$s : %2$d\n", path2, n2);
		System.out.println("Press [Enter] key to end.");
		while((cnt = System.in.available()) < 1){
			Thread.currentThread().sleep(500);
		}
		while(cnt-- > 0) System.in.read();

	}
	
	
	private long getNumberOfBytes(String path) throws Exception{
		
		File f = new File(path);
		FileInputStream fis = null;
		long result = 0;
		
		try{
			fis = new FileInputStream(f);
			while(fis.read() != -1) result++;

			System.out.println("Press [Enter] key to proceed.");
			int cnt;
			while((cnt = System.in.available()) < 1){
				Thread.currentThread().sleep(500);
			}
			while(cnt-- > 0) System.in.read();			
			
			return result;
		}catch(Exception ex){
			throw ex;
		}finally{
			if(fis != null){
				try{ fis.close(); }catch(Exception ex){}
			}
		}
	}
	
	private long getNumberOfBytesLeavingUnclosedStream(String path) throws Exception{
		
		FileInputStream fis = new FileInputStream(path);
		long result = 0;
		while(fis.read() != -1) result++;
		return result;
	}
	
	
	
	/** 
	 * Run this method in debug mode, and
	 * monitor the conn.connected field (which is protected)
	 * and the closed field of underlying input stream object.
	 */
	@Test
	public void testUrlConnection() throws Exception{
		
		// references
		// http://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html
		// http://docs.oracle.com/javase/6/docs/api/java/net/URLConnection.html
		// http://docs.oracle.com/javase/6/docs/api/java/net/HttpURLConnection.html

		URL url = new URL("http://www.google.com/");
		HttpURLConnection conn = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try{
			// "A new connection is opened every time by 
			// calling the openConnection method" - from Java SE API  
			conn = (HttpURLConnection)(url.openConnection());
			
			// "Operations that depend on being connected, 
			// like getContentLength, will implicitly perform 
			// the connection, if necessary."
			// - from Java SE API
			//
			// "The connection is opened implicitly by calling 
			// getInputStream." - from The Java Tutorials
			isr = new InputStreamReader(conn.getInputStream());
			br = new BufferedReader(isr);
			
			String line;
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
			
		}catch(Exception ex){
			throw ex;
		}finally{
			
			if(conn != null){
				try{ conn.disconnect(); }
				catch(Exception ex){
					this.logger.error("The connection is not diconnected.", ex);
				}
			}
			
			// "Invoking the close() methods on the InputStream or 
			// OutputStream of an URLConnection after a request may 
			// free network resources associated with this instance"
			// - from Java SE API
			if(isr != null){
				try{ isr.close(); }
				catch(Exception ex){
					this.logger.error("The output stream is not closed.", ex);
				}
			}
			
			if(br != null){
				try{ br.close(); }
				catch(Exception ex){
					this.logger.error("The output stream is not closed.", ex);
				}
			}
		}
	}
	
	private void waitEnterOnConsole(String msg) throws Exception{
		int cnt;
		System.out.println(msg);
		while((cnt = System.in.available()) < 1){
			Thread.currentThread().sleep(500);
		}
		while(cnt-- > 0) System.in.read();		
	}
	
	
}
