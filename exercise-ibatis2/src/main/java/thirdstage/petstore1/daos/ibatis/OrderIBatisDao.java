/**
 * 
 */
package thirdstage.petstore1.daos.ibatis;

import java.sql.SQLException;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ibatis.sqlmap.client.SqlMapClient;
import thirdstage.petstore1.daos.OrderDao;
import thirdstage.petstore1.daos.SequenceDao;
import thirdstage.petstore1.domain.entities.LineItem;
import thirdstage.petstore1.domain.entities.Order;

/**
 * @author 3rdstage
 * 
 */
public class OrderIBatisDao implements OrderDao{

	private SqlMapClient sqlMapClient;
	private SequenceDao sequenceDao;

	public OrderIBatisDao(){
		super();
	}

	protected SqlMapClient getSqlMapClient(){
		return this.sqlMapClient;
	}

	@org.springframework.beans.factory.annotation.Required
	public void setSqlMapClient(SqlMapClient sqlMapClient){
		this.sqlMapClient = sqlMapClient;
	}

	protected SequenceDao getSequenceDao(){
		return this.sequenceDao;
	}

	@org.springframework.beans.factory.annotation.Required
	public void setSequenceDao(SequenceDao sequenceDao){
		this.sequenceDao = sequenceDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.daos.OrderDao#getOrder(int)
	 */
	public Order getOrder(int id) throws SQLException{
		Order order = (Order)(this.getSqlMapClient().queryForObject("getOrder", new Integer(id)));
		if(order != null){
			order.setLineItems((List<LineItem>)(this.getSqlMapClient().queryForList("getLineItemsByOrder", new Integer(id))));
		}

		return order;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.daos.OrderDao#getOrdersByUsername(java.lang.String)
	 */
	public List<Order> getOrdersByUser(String username) throws SQLException{
		return (List<Order>)(this.getSqlMapClient().queryForList("getOrdersByUser", username));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.daos.OrderDao#makeOrder(thirdstage.petstore1.domain.entities.Order)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, 
			rollbackFor = {java.sql.SQLException.class})
	public void makeOrder(Order order) throws SQLException{
		order.setId(this.getSequenceDao().getNextId("ordernum"));
		this.getSqlMapClient().insert("insertOrder", order);
		this.getSqlMapClient().insert("insertOrderStatus", order);

		List<LineItem> lineItems = order.getLineItems();
		for(LineItem lineItem : lineItems){
			lineItem.setOrderId(order.getId());
			this.getSqlMapClient().insert("insertLineItem", lineItem);
		}
	}

}
