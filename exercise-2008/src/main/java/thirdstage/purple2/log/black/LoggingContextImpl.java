/**
 * 
 */
package thirdstage.purple2.log.black;

import org.apache.log4j.Level;
import thirdstage.purple2.log.LoggingContext;

/**
 * @author 3rdstage
 *
 */
public class LoggingContextImpl implements LoggingContext{
	
	private String[] loggerFactors;
	
	private Level loggingLevel;
	

	/* (non-Javadoc)
	 * @see thirdstage.purple2.log.LoggingContext#getLoggerFactors()
	 */
	public String[] getLoggerFactors(){
		return this.loggerFactors;
	}
	
	public void setLoggerFactors(String... factors){
		this.loggerFactors = factors;
	}
	

	/* (non-Javadoc)
	 * @see thirdstage.purple2.log.LoggingContext#getLoggingLevel()
	 */
	public Level getLoggingLevel(){
		return this.loggingLevel;
	}

	public void setLoggingLevel(Level level){
		this.loggingLevel = level;
	}
}
