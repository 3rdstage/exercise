/**
 * 
 */
package thirdstage.exercise.jmx.spring.case2;

import java.lang.management.ManagementFactory;
import java.util.Random;
import java.util.concurrent.Executors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import thirdstage.exercise.jmx.spring.case1.ComponentMeta;
import thirdstage.exercise.jmx.spring.case1.ComponentMetaImpl;
import thirdstage.exercise.jmx.spring.case1.ComponentMetaRegistry;

/**
 * @author 3rdstage
 *
 */
public class SpringJmxConnectorServerTest {

	public static void main(String[] args) throws Exception{
		
		String runtimeName = ManagementFactory.getRuntimeMXBean().getName();
		String pid = runtimeName.substring(0, runtimeName.indexOf('@'));

		String[] names = {"Claire", "Peter", "Nathan", "Noah", "Niki", "Matt", "Hiro", "Ando"};
		
		for(String name : names){
			
			Executors.newSingleThreadExecutor().execute(new RepetativeGreetings(name + "@" + pid));
		}		

		ApplicationContext springCtx = new ClassPathXmlApplicationContext("thirdstage/exercise/jmx/spring/case2/spring.xml");
		
		System.out.println("JMX Connector Server is started.");
		System.out.println("Sleeping... Press Ctrl+C to quit.");
		Thread.sleep(Long.MAX_VALUE);
	}
	
}


class RepetativeGreetings implements Runnable{
	
	private boolean requestedToStop = false;
	private String name = "None"; 
	
	public RepetativeGreetings(String name){
		this.name = name;
	}
	
	public boolean getRquestedToStop(){
		return this.requestedToStop;
	}
	
	public void requestToStop(){
		this.requestedToStop = true;
	}

	public String getName(){ return this.name; }
	
	public void run(){
		
		Random rd = new Random();
		
		String[] strs = {"Hi.", "Nice to meet you.", "Nice meeting you.", "Longtime no see.", "What's up!"};
		String str = null;
		
		while(!this.requestedToStop){
			str = strs[rd.nextInt(strs.length)];
			
			System.out.println(this.name + " : " + str);
			
			try{
				Thread.sleep(rd.nextInt(9)*300);
			}catch(InterruptedException ex){
				System.out.println("Unexpected Error. " + this.name + " would stop.");
				break;
			}
			
		}
	}
	
}

