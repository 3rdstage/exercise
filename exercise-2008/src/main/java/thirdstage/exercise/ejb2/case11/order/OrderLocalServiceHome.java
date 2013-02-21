/**
 * 
 */
package thirdstage.exercise.ejb2.case11.order;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import thirdstage.exercise.ejb2.case11.OrderValue;

/**
 * @author 3rdstage
 *
 */
public interface OrderLocalServiceHome extends EJBLocalHome{

	OrderLocalService create() throws CreateException;
}
