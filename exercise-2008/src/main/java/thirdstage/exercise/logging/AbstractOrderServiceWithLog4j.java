/**
 * 
 */
package thirdstage.exercise.logging;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author 3rdstage
 *
 */
public abstract class AbstractOrderServiceWithLog4j extends AbstractOrderServiceWithLogging{

	private final static String FQCN = AbstractOrderServiceWithLog4j.class.getName();
	
	protected Logger logger = Logger.getLogger(this.getClass()); 

	/* (non-Javadoc)
	 * @see thirdstage.exercise.logging.AbstractOrderServiceWithLogging#debug(java.lang.Object, java.lang.Throwable)
	 */
	@Override
	protected void debug(Object msg, Throwable th){
		if(th != null) logger.log(Level.DEBUG, msg);
		else logger.log(FQCN, Level.DEBUG, msg, null);
		
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.logging.AbstractOrderServiceWithLogging#error(java.lang.Object, java.lang.Throwable)
	 */
	@Override
	protected void error(Object msg, Throwable th){
		if(th != null) logger.log(Level.ERROR, msg);
		else logger.log(FQCN, Level.ERROR, msg, null);
		
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.logging.AbstractOrderServiceWithLogging#info(java.lang.Object, java.lang.Throwable)
	 */
	@Override
	protected void info(Object msg, Throwable th){
		if(th != null) logger.log(this.getClass().getName(), Level.INFO, msg, th);
		else logger.log(FQCN, Level.INFO, msg, null);
		
	}


}
