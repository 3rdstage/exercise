package thirdstage.petstore1.daos;

import java.sql.SQLException;
import java.util.List;
import thirdstage.petstore1.domain.entities.Order;

public interface OrderDao{
	
	Order getOrder(int id) throws SQLException;

	List<Order> getOrdersByUser(String username) throws SQLException;
	
	void makeOrder(Order order) throws SQLException;
}
