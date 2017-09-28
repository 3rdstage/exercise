package thirdstage.exercise.spring.case1;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2007.11.07, 3rdstage
 * @since 2007.11.07
 */
public class OrderImpl {
	
	String id = null;
	Customer customer = null;
	java.util.List<OrderItem> orderItems = null;
	
	/** Creates a new instance of OrderImpl */
	public OrderImpl() {
		
	}
	
	public String getId(){ return this.id; }
	public void setId(String id){ this.id = id; }
	
	public Customer getCustomer(){ return this.customer; }
	public void setCustomer(Customer customer){ this.customer = customer; }
	

	public java.util.List<OrderItem> getAllOrderItems(){ return this.orderItems; }
	public void setOrderItem(java.util.List<OrderItem> orderItems){ this.orderItems = orderItems; }
	public void addOrderItem(OrderItem orderItem){ this.orderItems.add(orderItem); }
	
}
