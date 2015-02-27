package thirdstage.sample.spring.shop1.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import thirdstage.sample.spring.shop1.dao.LineItemDao;
import thirdstage.sample.spring.shop1.dao.OrderHeaderDao;
import thirdstage.sample.spring.shop1.dao.ibatis.LineItemDaoIBatisImpl;
import thirdstage.sample.spring.shop1.dao.ibatis.OrderHeaderDaoIBatisImpl;
import thirdstage.sample.spring.shop1.dao.jdbc.LineItemDaoJdbcImpl;
import thirdstage.sample.spring.shop1.dao.jdbc.OrderHeaderDaoJdbcImpl;
import thirdstage.sample.spring.shop1.entity.LineItem;
import thirdstage.sample.spring.shop1.entity.Order;
import thirdstage.sample.spring.shop1.entity.OrderHeader;

/**
 * @author 3rdstage
 *
 */
public class OrderManagerImpl implements OrderManager{

	private OrderHeaderDao orderHeaderDao = null;

	private LineItemDao lineItemDao = null;

	public OrderManagerImpl(){}

	/**
	 * @return the orderHeaderDao
	 */
	protected OrderHeaderDao getOrderHeaderDao(){
		return orderHeaderDao;
	}

	/**
	 * @param orderHeaderDao the orderHeaderDao to set
	 */
	public void setOrderHeaderDao(OrderHeaderDao orderHeaderDao){
		this.orderHeaderDao = orderHeaderDao;
	}

	/**
	 * @return the lineItemDao
	 */
	public LineItemDao getLineItemDao(){
		return lineItemDao;
	}

	/**
	 * @param lineItemDao the lineItemDao to set
	 */
	public void setLineItemDao(LineItemDao lineItemDao){
		this.lineItemDao = lineItemDao;
	}

	public List<Order> findOrdersByCustomer(String customerId){
		if(StringUtils.isBlank(customerId)){
			throw new IllegalArgumentException("Customer ID should is not specified.");
		}
		

		List<Order> orders = new ArrayList<Order>();

		List<OrderHeader> orderHeaders = this.getOrderHeaderDao().selectOrderHeadersByCustomerId(customerId);

		Order order = null;
		String orderId = null;
		List<LineItem> lineItems = null;
		for(OrderHeader orderHeader : orderHeaders){
			orderId = orderHeader.getOrderId();
			lineItems = lineItemDao.selectLineItemsByOrder(orderId);

			order = new Order();
			order.setOrderHeader(orderHeader);
			order.setLineItems(lineItems);
			orders.add(order);
		}

		return orders;
	}

	public void makeOrder(Order order){
		if(order == null){
			throw new IllegalArgumentException("Order to make is not specified.");
		}

		OrderHeader orderHeader = order.getOrderHeader();
		List<LineItem> lineItems = order.getLineItems();
		
		this.getOrderHeaderDao().insertOrderHeader(orderHeader);
		for(LineItem lineItem : lineItems){
			this.getLineItemDao().insertLineItem(lineItem);
		}

	}

	public List<Order> findOrdersByInterval(Date start, Date end){
		List<Order> orders = new ArrayList<Order>();

		List<OrderHeader> orderHeaders = this.getOrderHeaderDao().selectOrderHeadersByInterval(start, end);

		Order order = null;
		String orderId = null;
		List<LineItem> lineItems = null;
		for(OrderHeader orderHeader : orderHeaders){
			orderId = orderHeader.getOrderId();
			lineItems = lineItemDao.selectLineItemsByOrder(orderId);

			order = new Order();
			order.setOrderHeader(orderHeader);
			order.setLineItems(lineItems);
			orders.add(order);
		}

		return orders;
	}

}
