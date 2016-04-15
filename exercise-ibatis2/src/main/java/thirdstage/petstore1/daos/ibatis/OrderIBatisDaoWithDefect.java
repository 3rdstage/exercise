package thirdstage.petstore1.daos.ibatis;

import java.sql.SQLException;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import thirdstage.petstore1.domain.entities.LineItem;
import thirdstage.petstore1.domain.entities.Order;

/**
 * This class has intentional defect in makeOrder method to
 * test transaction roll-back.
 * 
 * @author 3rdstage
 *
 */
public class OrderIBatisDaoWithDefect extends OrderIBatisDao{

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false,
			rollbackFor = {java.sql.SQLException.class})
	public void makeOrder(Order order) throws SQLException{
		order.setId(this.getSequenceDao().getNextId("ordernum"));
		this.getSqlMapClient().insert("insertOrder", order);
		this.getSqlMapClient().insert("insertOrderStatus", order);
		
		if(true) throw new UnsupportedOperationException();
		
		// Yes, below codes would never be executed
		List<LineItem> lineItems = order.getLineItems();
		for(LineItem lineItem : lineItems){
			lineItem.setOrderId(order.getId());
			this.getSqlMapClient().insert("insertLineItem", lineItem);
		}
	}

	
}
