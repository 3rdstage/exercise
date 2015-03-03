/**
 * 
 */
package thirdstage.exercise.tuning.attach;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.Random;
import java.util.concurrent.Executors;

/**
 * @author 3rdstage
 *
 */
public class AttachTestee {
	
	
	public static void main(String[] args) throws Exception{
	
		String runtimeName = ManagementFactory.getRuntimeMXBean().getName();
		String pid = runtimeName.substring(0, runtimeName.indexOf('@'));
		
		String[] names = {"Claire", "Peter", "Nathan", "Noah", "Niki", "Matt", "Hiro", "Ando"};
		
		for(String name : names){
			
			Executors.newSingleThreadExecutor().execute(new RepetativeGreetings(name + "@" + pid));
		}
		
		System.out.println("Infinitly running threads are started. To stop those and me, press Ctrl+C");
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
