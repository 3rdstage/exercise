/**
 * 
 */
package thirdstage.exercise.ejb2.case11.order;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import thirdstage.exercise.ejb2.case11.OrderValue;

/**
 * @author 3rdstage
 *
 */
public class OrderServiceBean implements SessionBean{
	
	
	private SessionContext sessionContext;
	
	private Random random;
	
	public OrderValue makeOrder(OrderValue order){
		if(order == null) return null;
		else{
			int orderNo = 100000000 + this.random.nextInt(10000000);
			order.setOrderNo(String.valueOf(orderNo));
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS z");
			order.setOrderedDate(df.format(new Date()));
			return order;
		}
	}
	
	public OrderValue cancelOrder(OrderValue order){
		//TODO not yet implemented
		return null;
	}
	
	
	public void ejbCreate(){
		this.random = new Random(System.currentTimeMillis());
	}

	/* (non-Javadoc)
	 * @see javax.ejb.SessionBean#ejbActivate()
	 */
	public void ejbActivate() throws EJBException, RemoteException{

	}

	/* (non-Javadoc)
	 * @see javax.ejb.SessionBean#ejbPassivate()
	 */
	public void ejbPassivate() throws EJBException, RemoteException{

	}

	/* (non-Javadoc)
	 * @see javax.ejb.SessionBean#ejbRemove()
	 */
	public void ejbRemove() throws EJBException, RemoteException{

	}

	/* (non-Javadoc)
	 * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
	 */
	public void setSessionContext(SessionContext ctx) throws EJBException, RemoteException{
		this.sessionContext = ctx;
	}

}
