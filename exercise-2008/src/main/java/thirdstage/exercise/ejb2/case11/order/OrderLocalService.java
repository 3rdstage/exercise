/**
 * 
 */
package thirdstage.exercise.ejb2.case11.order;

import javax.ejb.EJBLocalObject;
import thirdstage.exercise.ejb2.case11.OrderValue;

/**
 * @author 3rdstage
 *
 */
public interface OrderLocalService extends EJBLocalObject{

	
	
	OrderValue makeOrder(OrderValue order);
	
	OrderValue cancelOrder(OrderValue order);

	
}
