/**
 * 
 */
package thirdstage.petstore1.services;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.support.TransactionTemplate;
import thirdstage.petstore1.domain.entities.Account;
import thirdstage.petstore1.domain.entities.Category;
import thirdstage.petstore1.domain.entities.Item;
import thirdstage.petstore1.domain.entities.Order;
import thirdstage.petstore1.domain.entities.Product;

/**
 * Implements PetStoreFacade interface using HibernateTemplate or TransactionTemplate
 * from Springframework and DataAccessException classes from Springframework
 * 
 * @author 3rdstage
 *
 */
public class PetStoreHibernateFacade1 implements PetStoreFacade{
	
	private HibernateTemplate hibernateTemplate;
	private TransactionTemplate transactionTemplate;
	
	
	//block start : accessers and mutators
	/**
	 * Note that HibernateTemplate will perform its own Session management, 
	 * not participating in a custom Hibernate CurrentSessionContext unless 
	 * you explicitly switch "allowCreate" to "false" 
	 * (from Springframework 2.5 API documentation)
	 * 
	 * @see <a href="http://static.springframework.org/spring/docs/2.5.x/api/org/springframework/orm/hibernate3/HibernateTemplate.html">HibernateTemplate</a>
	 */
	protected HibernateTemplate getHibernateTemplate(){
		return this.hibernateTemplate;
	}
	
	@org.springframework.beans.factory.annotation.Required
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
		this.hibernateTemplate = hibernateTemplate;
	}
	
	protected TransactionTemplate getTransactionTemplate(){
		return this.transactionTemplate;
	}
	
	@org.springframework.beans.factory.annotation.Required
	public void setTransactionTemplate(TransactionTemplate transactionTemplate){
		this.transactionTemplate = transactionTemplate;
	}
	
	//block end : accessers and mutators
	
	
	//block start : business methods
	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#addAccount(thirdstage.petstore1.domain.entities.Account)
	 */
	public void addAccount(Account account) throws DataAccessException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getAccount(java.lang.String)
	 */
	public Account getAccount(String username) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getAccount(java.lang.String, java.lang.String)
	 */
	public Account getAccount(String username, String password) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getAllCategorys()
	 */
	public List<Category> getAllCategorys() throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getAllUsernames()
	 */
	public List<String> getAllUsernames(){
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getCategory(java.lang.String)
	 */
	public Category getCategory(String categoryId) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getItem(java.lang.String)
	 */
	public Item getItem(String itemId) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getItemsByProduct(java.lang.String)
	 */
	public List<Item> getItemsByProduct(String productId) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getOrder(int)
	 */
	public Order getOrder(int orderId) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getOrdersByUsername(java.lang.String)
	 */
	public List<Order> getOrdersByUsername(String username) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getProduct(java.lang.String)
	 */
	public Product getProduct(String productId) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getProductsByCategory(java.lang.String)
	 */
	public List<Product> getProductsByCategory(String categoryId) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#isItemInStock(java.lang.String)
	 */
	public boolean isItemInStock(String itemId) throws DataAccessException{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#makeOrder(thirdstage.petstore1.domain.entities.Order)
	 */
	public void makeOrder(Order order) throws DataAccessException{
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#searchProductsByKeyword(java.lang.String)
	 */
	public List<Product> searchProductsByKeyword(String keyword) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#updateAccount(thirdstage.petstore1.domain.entities.Account)
	 */
	public void updateAccount(Account account) throws DataAccessException{
	// TODO Auto-generated method stub

	}
	//block end : business methods
}
