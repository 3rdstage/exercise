package sample.server.case2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 
 * 
 * @question Is there any way to make thread pool create threads initially.
 */
public class Server {
	
	private ApplicationContext springContext;
	private ThreadPoolTaskExecutor threadPool;
	
	public Server() throws Exception{
		this.springContext = new ClassPathXmlApplicationContext("sample/server/case2/spring-server.xml");
		this.threadPool = springContext.getBean("threadPool", ThreadPoolTaskExecutor.class);
		
		
		System.out.println("Press 'Enter' key to end this programm.");
		while(true){
			if(System.in.available() > 0) break;
			Thread.currentThread().sleep(1000);
		}
		System.out.println("The program ends.");
		
	}
	
	public static void main(String[] args) throws Exception{
		
		Server server = new Server();
	}
}
