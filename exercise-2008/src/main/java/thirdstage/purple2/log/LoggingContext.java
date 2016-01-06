/**
 * 
 */
package thirdstage.purple2.log;

import org.apache.log4j.Level;

/**
 * @author 3rdstage
 *
 */
public interface LoggingContext{
	
	
	String[] getLoggerFactors();
	
	Level getLoggingLevel();
	

}
