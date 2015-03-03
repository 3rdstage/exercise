package thirdstage.sample.spring.shop1.dao.ibatis;

import java.util.Date;
import java.util.List;
import thirdstage.sample.spring.shop1.dao.OrderHeaderDao;
import thirdstage.sample.spring.shop1.entity.OrderHeader;

public class OrderHeaderDaoIBatisImpl implements OrderHeaderDao{

	public void insertOrderHeader(OrderHeader order){
	// TODO Auto-generated method stub

	}

	public List<OrderHeader> selectOrderHeadersByCustomerId(String customerId){
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderHeader> selectOrderHeadersByInterval(Date start, Date end){
		// TODO Auto-generated method stub
		return null;
	}

}
