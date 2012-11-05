package thirdstage.sample.spring.shop1.manager;

import java.util.Date;
import java.util.List;
import thirdstage.sample.spring.shop1.entity.Order;

/**
 * Sample application to give the basic understanding and importance of
 * dependency injection to Java programmers new to Spring framework.
 * 
 * @version 1.0 2010-03-23 3rdstage Initial revision
 * @author 3rdstage
 * @since 2010-03-23
 */

public interface OrderManager{
	
	void makeOrder(Order order);
	
	List<Order> findOrdersByCustomer(String customerId);
	
	List<Order> findOrdersByInterval(Date start, Date end);
	
	
	

}
