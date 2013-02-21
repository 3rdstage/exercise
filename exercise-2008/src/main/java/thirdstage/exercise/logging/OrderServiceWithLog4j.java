/**
 * 
 */
package thirdstage.exercise.logging;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/**
 * @author 3rdstage
 *
 */
public class OrderServiceWithLog4j extends AbstractOrderServiceWithLogging{
	
	
	private final static String FQCN = OrderServiceWithLog4j.class.getName();
	
	private Logger logger = Logger.getLogger(this.getClass()); 

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

	/* (non-Javadoc)
	 * @see thirdstage.exercise.logging.OrderService#cancleOrder(thirdstage.exercise.logging.Order)
	 */
	public void cancleOrder(Order order){
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.logging.OrderService#makeOrder(thirdstage.exercise.logging.Order)
	 */
	public void makeOrder(Order order){
		this.logger.info("(Direct Log)New order is made successfully - order ID : " + order.getId());
		this.info("(Indirect Log)New order is made successfully -  order ID : " + order.getId() + "", null);
	}

}
