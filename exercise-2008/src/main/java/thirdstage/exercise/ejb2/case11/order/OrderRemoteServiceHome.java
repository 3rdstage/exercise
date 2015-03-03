/**
 * 
 */
package thirdstage.exercise.ejb2.case11.order;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 * @author 3rdstage
 *
 */
public interface OrderRemoteServiceHome extends EJBHome{
	
	public OrderRemoteService create() throws CreateException, RemoteException;

}
