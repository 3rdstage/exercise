package thirdstage.petstore1.services;

import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import thirdstage.petstore1.daos.AccountDao;
import thirdstage.petstore1.daos.CategoryDao;
import thirdstage.petstore1.daos.ItemDao;
import thirdstage.petstore1.daos.OrderDao;
import thirdstage.petstore1.daos.ProductDao;
import thirdstage.petstore1.domain.entities.Account;
import thirdstage.petstore1.domain.entities.Category;
import thirdstage.petstore1.domain.entities.Item;
import thirdstage.petstore1.domain.entities.Order;
import thirdstage.petstore1.domain.entities.Product;

@ManagedResource(objectName="beans:name=petStoreIBatisFacade")
public class PetStoreIBatisFacade implements PetStoreFacade{

	private AccountDao accountDao;
	private CategoryDao categoryDao;
	private ItemDao itemDao;
	private ProductDao productDao;
	private OrderDao orderDao;

	/*
	 * TODO need to check whether the SQLExceptionTranslator.translate is
	 * thread-safe or not
	 */
	private SQLExceptionTranslator sqlExceptionTranslator;

	// constructors
	public PetStoreIBatisFacade(){
		super();
		sqlExceptionTranslator = new SQLStateSQLExceptionTranslator();
	}
	// end of constructors

	
	// accessers and mutators
	@ManagedAttribute(description="account DAO")
	public AccountDao getAccountDao(){
		return accountDao;
	}

	@org.springframework.beans.factory.annotation.Required
	public void setAccountDao(AccountDao accountDao){
		this.accountDao = accountDao;
	}

	@ManagedAttribute(description="category DAO")
	public CategoryDao getCategoryDao(){
		return categoryDao;
	}

	@org.springframework.beans.factory.annotation.Required
	public void setCategoryDao(CategoryDao categoryDao){
		this.categoryDao = categoryDao;
	}

	@ManagedAttribute(description="item DAO")
	protected ItemDao getItemDao(){
		return itemDao;
	}

	@org.springframework.beans.factory.annotation.Required
	public void setItemDao(ItemDao itemDao){
		this.itemDao = itemDao;
	}

	protected ProductDao getProductDao(){
		return productDao;
	}

	@org.springframework.beans.factory.annotation.Required
	public void setProductDao(ProductDao productDao){
		this.productDao = productDao;
	}

	protected OrderDao getOrderDao(){
		return this.orderDao;
	}

	@org.springframework.beans.factory.annotation.Required
	public void setOrderDao(OrderDao orderDao){
		this.orderDao = orderDao;
	}

	protected SQLExceptionTranslator getSQLExceptionTranslator(){
		return this.sqlExceptionTranslator;
	}
	// end of accessers and mutators

	
	// business methods
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<String> getAllUsernames() throws DataAccessException{
		try{
			return this.getAccountDao().getAllUsernames();
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get all usernames", null, ex);
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Account getAccount(String username){
		try{
			return this.getAccountDao().getAccount(username);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get the account with given id : " + username, null, ex);
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Account getAccount(String username, String password){
		try{
			return this.getAccountDao().getAccount(username, password);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get the account with given id : " + username + " and password", null, ex);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void addAccount(Account account){
		try{
			this.getAccountDao().addAccount(account);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Add a new account", null, ex);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateAccount(Account account){
		try{
			this.getAccountDao().updateAccount(account);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Update the account with given id : " + account.getUsername(), null, ex);
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Category> getAllCategorys(){
		try{
			return this.getCategoryDao().getAllCategories();
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get all categories", null, ex);
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Category getCategory(String categoryId){
		try{
			return this.getCategoryDao().getCategory(categoryId);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get the category with given id : " + categoryId, null, ex);
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Product> getProductsByCategory(String categoryId){
		try{
			return this.getProductDao().getProductsByCategory(categoryId);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get products with given category : " + categoryId, null, ex);
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Product> searchProductsByKeyword(String keyword){
		try{
			return this.getProductDao().searchProducts(keyword);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Search products with given keyword : " + keyword, null, ex);
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Product getProduct(String productId){
		try{
			return this.getProductDao().getProduct(productId);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get the product with given id " + productId, null, ex);
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Item> getItemsByProduct(String productId){
		try{
			return this.getItemDao().getItemsByProduct(productId);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get items with given product : " + productId, null, ex);
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Item getItem(String itemId){
		try{
			return this.getItemDao().getItem(itemId);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get the item with given id : " + itemId, null, ex);
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public boolean isItemInStock(String itemId){
		try{
			return this.getItemDao().isItemInStock(itemId);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Check the availability of the item with given id : " + itemId, null, ex);
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Order> getOrdersByUsername(String username){
		try{
			return this.getOrderDao().getOrdersByUser(username);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get orders with given username : " + username, null, ex);
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Order getOrder(int orderId){
		try{
			return this.getOrderDao().getOrder(orderId);

		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get the order with given id : " + orderId, null, ex);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void makeOrder(Order order){
		try{
			this.getOrderDao().makeOrder(order);
			this.getItemDao().updateQuantity(order);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Add a new order", null, ex);
		}
	}
	// end of business methods
}
