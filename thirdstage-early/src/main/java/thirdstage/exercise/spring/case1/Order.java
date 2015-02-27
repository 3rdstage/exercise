package thirdstage.exercise.spring.case1;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2007.11.07, 3rdstage
 * @since 2007.11.07
 */
public interface Order {
	
	public String getId();
	public void setId(String id);
	
	public Customer getCustomer();
	public void setCustomer(Customer customer);
	
	public java.util.List<OrderItem> getAllOrderItems();
	public void addOrderItem(OrderItem orderItem);
	
}
