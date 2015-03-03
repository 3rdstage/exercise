/**
 * 
 */
package thirdstage.purple2.log.black;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import thirdstage.purple2.log.Log4jLoggerFactory;
import thirdstage.purple2.log.LoggingContext;

/**
 * @author 3rdstage
 *
 */
public class Log4jLoggerFactoryImpl implements Log4jLoggerFactory{
	
	private Map<String, Logger> cachedLoggers = new HashMap<String, Logger>();

	/* (non-Javadoc)
	 * @see thirdstage.purple2.log.Log4jLoggerFactory#getLogger(thirdstage.purple2.log.LoggingContext)
	 */
	public Logger getLogger(LoggingContext ctx){
		// TODO Auto-generated method stub
		return null;
	}

}
