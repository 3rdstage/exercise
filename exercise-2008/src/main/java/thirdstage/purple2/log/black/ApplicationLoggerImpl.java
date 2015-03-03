/**
 * 
 */
package thirdstage.purple2.log.black;

import org.springframework.beans.factory.annotation.Required;
import thirdstage.purple2.log.ApplicationLogger;
import thirdstage.purple2.log.Log4jLoggerFactory;
import thirdstage.purple2.log.LoggingContext;

/**
 * @author 3rdstage
 *
 */
public class ApplicationLoggerImpl implements ApplicationLogger{
	
	private Log4jLoggerFactory loggerFactory;
	
	@Required
	public void setLog4jLoggerFactory(Log4jLoggerFactory factory){
		this.loggerFactory = factory;
	}
	
	protected Log4jLoggerFactory getLog4jLoggerFactory(){
		return this.loggerFactory;
	}

	/* (non-Javadoc)
	 * @see thirdstage.purple2.log.ApplicationLogger#debug(thirdstage.purple2.log.LoggingContext, java.lang.String, java.lang.String[])
	 */
	public void debug(LoggingContext ctx, String msg, String... msgParams){
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see thirdstage.purple2.log.ApplicationLogger#error(thirdstage.purple2.log.LoggingContext, java.lang.Throwable, java.lang.String, java.lang.String[])
	 */
	public void error(LoggingContext ctx, Throwable th, String msg, String... msgParams){
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see thirdstage.purple2.log.ApplicationLogger#info(thirdstage.purple2.log.LoggingContext, java.lang.String, java.lang.String[])
	 */
	public void info(LoggingContext ctx, String msg, String... msgParams){
	// TODO Auto-generated method stub

	}

}
