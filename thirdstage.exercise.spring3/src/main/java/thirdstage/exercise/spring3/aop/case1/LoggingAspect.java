/**
 * 
 */
package thirdstage.exercise.spring3.aop.case1;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author 3rdstage
 *
 */
@Aspect 
public class LoggingAspect {
 
	private static ExecutorService threadPool = Executors.newCachedThreadPool();

	private String name = "N/A";

	public String getName(){ return this.name; }
	
	@Required
	public void setName(String name){ this.name = name; }
	
	
	@Around("execution(* thirdstage.exercise.spring3.aop.case1.RandomSelector.call())")
	public Object logTimeElapsed(ProceedingJoinPoint joinPoint) throws Throwable{
		Object result = null; 
		
		long start = System.currentTimeMillis();
		result = joinPoint.proceed();
		long duration = System.currentTimeMillis() - start;
		this.threadPool.submit(new ElapsedTimeLoggingTask(this.name, start, System.currentTimeMillis()));
		return result;
	}   
}  

class ElapsedTimeLoggingTask implements Runnable{
	
	private String name = "";
	private long start = 0L; 
	private long end = 0L;

	private Random random = new Random();

	public ElapsedTimeLoggingTask(String name, long start, long end){
		this.name = name;
		this.start = start;
		this.end = end;
	}

	public void run(){
		try{
			Thread.currentThread().sleep(random.nextInt(10000) + 100);
		}catch(Exception ex){
			//do nothing.
		}
		
		System.out.printf("[%1$s]Time elapsed : %2$,d millisec.\n",  this.name, this.end - this.start);
	}
}
