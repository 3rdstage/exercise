/**
 * 
 */
package thirdstage.exercise.aspectj.case4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author 3rdstage
 *
 */
@Aspect
public abstract class LoggingAspect{
	
	//@Important 
	//You cann't specify @Apsect annotation to interface.

	@Pointcut
	public void journalLoggingPoint(){}
	
	@Pointcut
	public void transactionLoggingPoint(){}
	
	@Pointcut
	public void traceLoggingPoint(){}
	
}
