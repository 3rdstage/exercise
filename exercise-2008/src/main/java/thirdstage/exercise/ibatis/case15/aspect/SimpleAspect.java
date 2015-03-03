package thirdstage.exercise.ibatis.case15.aspect;

import java.util.Date;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * @author 3rdstage
 * @since 2009-09-04
 */
@Aspect
public class SimpleAspect{
	
//	@Around("thirdstage.exercise.ibatis.case15.EmployeeDaoJdbcSimple.findEmployee()")
//	public Object printExecutionTimeInterval(ProceedingJoinPoint pjp) throws Throwable{
//		
//		long t1 = System.nanoTime();
//		Object result = pjp.proceed();
//		long t2 = System.nanoTime();
//		
//		System.out.println("The time interval to proceed method : " + pjp.toShortString() + " is : " + (t2 - t1) + " nano-seconds");
//		
//		return result;
//		
//	}
	
//	@Before("thirdstage.exercise.ibatis.case15.EmployeeDaoJdbcSimple.findEmployee(Long)")
//	public void printExecutionStartTimestamp() throws Throwable{
//		
//		Date startT = new Date();
//		System.out.println("The start time is : " + startT);
//		
//	}
	
	

}
