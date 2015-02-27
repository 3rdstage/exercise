package thirdstage.sample.spring.shop1.dao;

import java.util.Date;
import java.util.List;
import thirdstage.sample.spring.shop1.entity.OrderHeader;

public interface OrderHeaderDao{

	void insertOrderHeader(OrderHeader orderHeader);
	
	List<OrderHeader> selectOrderHeadersByCustomerId(String customerId);
	
	List<OrderHeader> selectOrderHeadersByInterval(Date start, Date end);
	
	
}
