/**
 * 
 */
package thirdstage.purple2.log;

/**
 * @author 3rdstage
 *
 */
public interface ApplicationLogger{
	
	/**
	 * @param ctx
	 * @param msg
	 * @param msgParams
	 */
	void debug(LoggingContext ctx, String msg, String... msgParams);
	
	
	void info(LoggingContext ctx, String msg, String... msgParams);
	
	
	void error(LoggingContext ctx, Throwable th, String msg, String... msgParams);

}
