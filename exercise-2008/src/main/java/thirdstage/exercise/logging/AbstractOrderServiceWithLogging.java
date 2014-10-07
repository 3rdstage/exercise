/**
 * 
 */
package thirdstage.exercise.logging;

/**
 * @author 3rdstage
 *
 */
public abstract class AbstractOrderServiceWithLogging implements OrderService{
	
	abstract protected void debug(Object msg, Throwable th);
	
	abstract protected void info(Object msg, Throwable th);
	
	abstract protected void error(Object msg, Throwable th);
}
