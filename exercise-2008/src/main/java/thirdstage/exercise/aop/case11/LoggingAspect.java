/**
 * 
 */
package thirdstage.exercise.aop.case11;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author 3rdstage
 *
 */
@Aspect 
public class LoggingAspect {   

	private static ExecutorService threadPool = Executors.newCachedThreadPool();

	@Around("execution(* thirdstage.exercise.aop.case11.RandomSelector.call())")
	public Object logTimeElapsed(ProceedingJoinPoint joinPoint) throws Throwable{
		Object result; 
		
		long start = System.currentTimeMillis();
		result = joinPoint.proceed();
		long duration = System.currentTimeMillis() - start;
		this.threadPool.submit(new ElapsedTimeLoggingTask(start, System.currentTimeMillis()));
		return result;
	}   
}  

class ElapsedTimeLoggingTask implements Runnable{
	
	private long start = 0L;
	private long end = 0L;

	private Random random = new Random();

	public ElapsedTimeLoggingTask(long start, long end){
		this.start = start;
		this.end = end;
	}

	public void run(){
		try{
			Thread.currentThread().sleep(random.nextInt(10000) + 100);
		}catch(Exception ex){
			//do nothing.
		}
		
		System.out.printf("Time elapsed : %1$,d millisec.\n", end - start);
	}
}
