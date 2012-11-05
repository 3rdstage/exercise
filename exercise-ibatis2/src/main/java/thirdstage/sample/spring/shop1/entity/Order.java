package thirdstage.sample.spring.shop1.entity;

import java.util.ArrayList;
import java.util.List;

public class Order{

	private OrderHeader orderHeader = null;
	
	private List<LineItem> lineItems = new ArrayList<LineItem>();

	public Order(){
		
	}

	/**
	 * @return the orderHeader
	 */
	public OrderHeader getOrderHeader(){
		return orderHeader;
	}

	/**
	 * @param orderHeader the orderHeader to set
	 */
	public void setOrderHeader(OrderHeader orderHeader){
		this.orderHeader = orderHeader;
	}

	/**
	 * @return the lineItems
	 */
	public List<LineItem> getLineItems(){
		return lineItems;
	}

	/**
	 * @param lineItems the lineItems to set
	 */
	public void setLineItems(List<LineItem> lineItems){
		this.lineItems = lineItems;
	}
	
	
	
}
