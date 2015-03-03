/**
 * 
 */
package thirdstage.exercise.spring3.aop.case2;

import java.util.HashMap;
import java.util.Map;
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
public class ElapsedTimeLoggerAspect {
 
	private String name = "N/A";
	
	private ElapsedTimeLogHandler handler = null;
 
	public String getName(){ return this.name; }
	
	@Required
	public void setName(String name){ this.name = name; }
	
	@Required
	public void setLogHandler(ElapsedTimeLogHandler handler){ this.handler = handler; }
	
	
	@Around("execution(* thirdstage.exercise.spring3.aop.case2.RandomSelector.call())")
	public Object logTimeElapsed(ProceedingJoinPoint joinPoint) throws Throwable{
		Object result = null; 
		
		long start = System.currentTimeMillis();
		result = joinPoint.proceed();
		String[] context = new String[]{joinPoint.getSignature().getDeclaringTypeName(), 
			joinPoint.getSignature().getName(), Thread.currentThread().getName()};
		this.handler.handleLog(context, start, System.currentTimeMillis());
		return result;
	}   
}  
