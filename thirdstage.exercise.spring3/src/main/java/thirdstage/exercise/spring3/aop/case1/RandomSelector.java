/**
 * 
 */
package thirdstage.exercise.spring3.aop.case1;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author 3rdstage
 * 
 */
public class RandomSelector implements Callable<String> {
	
	private Random random = new Random(); 
	 
	private String[] list = null; 
	
	private int maxSleep = 1000; //in milli-seconds
	
	public RandomSelector(String[] list, int maxSleep){ 
		this.list = list;
		this.maxSleep = maxSleep;
	}   
	
	public String call() throws Exception{

		if(this.list == null) return null;
		Thread.currentThread().sleep(random.nextInt(this.maxSleep));
		return this.list[random.nextInt(this.list.length)];
	}

}
