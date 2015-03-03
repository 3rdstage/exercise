package thirdstage.petstore1.daos;

import java.sql.SQLException;
import java.util.List;
import thirdstage.petstore1.domain.entities.Item;
import thirdstage.petstore1.domain.entities.Order;

public interface ItemDao{
	
	Item getItem(String id) throws SQLException;
	
	List<Item> getItemsByProduct(String productId) throws SQLException;
	
	boolean isItemInStock(String itemId) throws SQLException;
	
	/**
	 * Decrease the stocks of items in given order in inventory.
	 * 
	 * @param order
	 * @throws SQLException
	 */
	void updateQuantity(Order order) throws SQLException;
}
