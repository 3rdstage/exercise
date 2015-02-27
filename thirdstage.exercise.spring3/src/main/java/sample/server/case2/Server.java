package sample.server.case2;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.Properties;
import java.util.zip.GZIPOutputStream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 
 * @question Is there any way to make thread pool create threads initially.
 */
public class Server {
	
	private ApplicationContext springContext;
	private ThreadPoolTaskExecutor threadPool;
	private byte[] data;
	
	public Server() throws Exception{

		this.springContext = new ClassPathXmlApplicationContext("sample/server/case2/spring-server.xml");
		this.threadPool = springContext.getBean("threadPool", ThreadPoolTaskExecutor.class);
		this.prepareData();
		
		System.out.println("Press 'Enter' key to end this programm.");
		while(true){
			if(System.in.available() > 0) break;
			Thread.currentThread().sleep(1000);
		}
		this.threadPool.shutdown();
		System.out.println("The program ends.");
		
	}
	
	/**
	 * Compress data in advance for clients to download.
	 */
	private void prepareData() throws Exception{
		Properties props = System.getProperties(); //uncompressed data to download
		
		ByteArrayOutputStream baos = null;
		GZIPOutputStream gzos = null;
		ObjectOutputStream oos = null;
		
		try{
			baos = new ByteArrayOutputStream();
			gzos = new GZIPOutputStream(baos);
			oos = new ObjectOutputStream(gzos);
			oos.writeObject(props);
			gzos.finish(); //don't miss this
			
			this.data = baos.toByteArray();
			System.out.printf("The size of compressed data is %1$d.\n", this.data.length);
		}catch(Exception ex){
			throw ex;
		}finally{
			if(baos != null){ try{ baos.close(); }catch(Exception ex){} }
			if(gzos != null){ try{ gzos.close(); }catch(Exception ex){} }
			if(oos != null){ try{ oos.close(); }catch(Exception ex){} }
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		Server server = new Server();
	}
}
