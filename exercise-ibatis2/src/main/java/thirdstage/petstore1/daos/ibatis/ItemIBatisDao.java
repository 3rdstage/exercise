package thirdstage.petstore1.daos.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.sqlmap.client.SqlMapClient;
import thirdstage.petstore1.daos.ItemDao;
import thirdstage.petstore1.domain.entities.Item;
import thirdstage.petstore1.domain.entities.LineItem;
import thirdstage.petstore1.domain.entities.Order;

public class ItemIBatisDao implements ItemDao{

	private SqlMapClient sqlMapClient;

	public ItemIBatisDao(){
		super();
	}

	protected SqlMapClient getSqlMapClient(){
		return this.sqlMapClient;
	}
	
	@org.springframework.beans.factory.annotation.Required
	public void setSqlMapClient(SqlMapClient sqlMapClient){
		this.sqlMapClient = sqlMapClient;
	}

	public Item getItem(String id) throws SQLException{
		return (Item)(this.getSqlMapClient().queryForObject("getItem", id));
	}

	public List<Item> getItemsByProduct(String productId) throws SQLException{
		return (List<Item>)(this.getSqlMapClient().queryForList("getItemsByProduct", productId));
	}

	public boolean isItemInStock(String itemId) throws SQLException{
		Integer i = (Integer)(this.getSqlMapClient().queryForObject("getInventoryQuantity", itemId));
		return(i != null && i.intValue() > 0);
	}

	public void updateQuantity(Order order) throws SQLException{
		if(order != null && order.getLineItems() != null){
			String itemId = null;
			Integer increment = null;
			Map param = null;
			for(LineItem lineItem : order.getLineItems()){
				param = new HashMap(2);
				param.put("itemId", lineItem.getItem().getId());
				param.put("increment", new Integer(lineItem.getQuantity()));
				this.getSqlMapClient().update("updateInventoryQuantity", param);
			}
		}
	}

}
