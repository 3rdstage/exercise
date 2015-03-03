/**
 * 
 */
package thirdstage.exercise.aspectj.case4;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author 3rdstage
 *
 */
//public class DefaultLoggingAspect extends LoggingAspect{
public class DefaultLoggingAspect{

	/* (non-Javadoc)
	 * @see thirdstage.exercise.aspectj.case4.LoggingAspect#journalLoggingPoint()
	 */
	@Pointcut("execution(* thirdstage.exercise.aspectj.case4.*(..))")
	public void journalLoggingPoint(){
		
	}
		
	/* (non-Javadoc)
	 * @see thirdstage.exercise.aspectj.case4.LoggingAspect#traceLoggingPoint()
	 */
	@Pointcut
	public void traceLoggingPoint(){
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.aspectj.case4.LoggingAspect#transactionLoggingPoint()
	 */
	@Pointcut
	public void transactionLoggingPoint(){
	// TODO Auto-generated method stub

	}

}
