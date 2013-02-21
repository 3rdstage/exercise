/**
 * 
 */
package thirdstage.exercise.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * Testee class to confirm various and detailed features of Apache Commons Logging(ACL) and Log4j.
 * <br/><br/>
 * Features include : 
 * <ul>
 * <li>Position or line number information of the log</li>
 * <li></li>
 * </ul>
 * </p>
 * 
 * @author 3rdstage
 * @version 1.0, 2009-12-07, Sangmoon Oh, Initial revision
 *
 */
public class OrderServiceWithACLAndLog4j extends AbstractOrderServiceWithLogging{
	
	private Log logger = LogFactory.getLog(this.getClass());
	
	@Override
	protected void debug(Object msg, Throwable th){
		if(th != null) this.logger.debug(msg, th);
		else this.logger.debug(msg);
	}
	
	@Override
	protected void info(Object msg, Throwable th){
		if(th != null) this.logger.info(msg, th);
		else this.logger.info(msg);
		
	}
	
	@Override
	protected void error(Object msg, Throwable th){
		if(th != null) this.logger.error(msg, th);
		else this.logger.error(msg);
	}
	

	
	
	public void makeOrder(Order order){
		this.logger.info("(Direct Log)New order is made successfully - order ID : " + order.getId());
		this.info("(Indirect Log)New order is made successfully -  order ID : " + order.getId() + "", null);
	}
	
	
	/**
	 * If the order id is specified, this method will cancle the order or return silently.
	 * If not, this method throws an <code>IllegalArgumentException</code>.
	 * 
	 * @param order
	 */
	public void cancleOrder(Order order){
		
		
	}
	
}
