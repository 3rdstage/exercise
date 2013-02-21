/**
 * 
 */
package thirdstage.exercise.logging;

/**
 * @author 3rdstage
 *
 */
public class AdvancedOrderServiceWithLog4j extends AbstractOrderServiceWithLog4j{

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
