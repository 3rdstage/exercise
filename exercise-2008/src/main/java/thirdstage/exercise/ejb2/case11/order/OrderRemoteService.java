/**
 * 
 */
package thirdstage.exercise.ejb2.case11.order;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;
import thirdstage.exercise.ejb2.case11.OrderValue;

/**
 * @author 3rdstage
 *
 */
public interface OrderRemoteService extends EJBObject{ 
	
	OrderValue makeOrder(OrderValue order) throws RemoteException;
	
	OrderValue cancelOrder(OrderValue order) throws RemoteException;
	
}
