package thirdstage.exercise.doxygen.case1;

import java.util.List;

public class OrderService {
	
	private OrderHeaderDao ohDao = new OrderHeaderDao();
	private LineItemDao liDao = new LineItemDao();
	private DeliveryService dvSvc = new DeliveryService(); 
	
	/**
	 * 
	 * \param header header information of the order to make
	 * \param items line items included in the order
	 * \callgraph
	 */
	public void makeOrder(OrderHeader header, List<LineItem> items){
		
		String orderNo = ohDao.insertOrderHeader(header);
		
		for(LineItem item : items){
			liDao.insertLineItem(item);
		}
		
		String dvNo = dvSvc.arrangeDelivery(orderNo, header);
		
	}

}
