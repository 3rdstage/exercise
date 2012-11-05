package thirdstage.petstore1.services;

import java.util.List;
import org.springframework.dao.DataAccessException;

import thirdstage.petstore1.domain.entities.Account;
import thirdstage.petstore1.domain.entities.Category;
import thirdstage.petstore1.domain.entities.Item;
import thirdstage.petstore1.domain.entities.Order;
import thirdstage.petstore1.domain.entities.Product;

/**
 * Pet store main business logics
 * Modified the implementation from the Spring Framework 2.5 
 * 
 * @version 1.0
 * @author Sang-Moon Oh
 * @since 2008-05-29
 */

public interface PetStoreFacade{
	
	List<String> getAllUsernames();
	Account getAccount(String username) throws DataAccessException;
	Account getAccount(String username, String password) throws DataAccessException;
	void addAccount(Account account) throws DataAccessException;
	void updateAccount(Account account) throws DataAccessException;

	List<Category> getAllCategorys() throws DataAccessException;
	Category getCategory(String categoryId) throws DataAccessException;

	List<Product> getProductsByCategory(String categoryId) throws DataAccessException;
	List<Product> searchProductsByKeyword(String keyword) throws DataAccessException;
	Product getProduct(String productId) throws DataAccessException;

	List<Item> getItemsByProduct(String productId) throws DataAccessException;
	Item getItem(String itemId) throws DataAccessException;
	boolean isItemInStock(String itemId) throws DataAccessException;
	
	void makeOrder(Order order) throws DataAccessException;
	Order getOrder(int orderId) throws DataAccessException;
	List<Order> getOrdersByUsername(String username) throws DataAccessException;
	
	
}
