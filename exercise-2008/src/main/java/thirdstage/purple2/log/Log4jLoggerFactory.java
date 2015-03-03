/**
 * 
 */
package thirdstage.purple2.log;

import org.apache.log4j.Logger;

/**
 * @author 3rdstage
 *
 */
public interface Log4jLoggerFactory{
	
	Logger getLogger(LoggingContext ctx);

}
