/**
 * 
 */
package thirdstage.exercise.reflection;

import java.lang.reflect.Constructor;

/**
 * @author 3rdstage
 *
 */
public class OrderConstructor{
	
	
	/**
	 * Consturcts order using reflection.
	 * 
	 * @param poNo
	 * @return
	 */
	public Order createOrderWithPurchaseOrderNo(String poNo) throws Exception{
		Class[] paramTypes = new Class[]{String.class};
		
		Constructor cnstr = Order.class.getDeclaredConstructor(paramTypes);
		
		return (Order)cnstr.newInstance(new String[]{poNo});
	}

	
	/**
	 * Consturcts order using reflection.<br/><br/>
	 * This method is expected to throw exception because it uses the private consturctor 
	 * to create an instant of Order. 
	 * 
	 * @param poNo
	 * @param orderId
	 * @return
	 */
	public Order createOrderWithPurchaseOrderNoAndOrderId(String poNo, String orderId) throws Exception{
		Class[] paramTypes = new Class[]{String.class, String.class};
		
		Constructor cnstr = Order.class.getDeclaredConstructor(paramTypes);
		
		return (Order)cnstr.newInstance(new String[]{poNo, orderId});
	}	
	

}
