/**
 * 
 */
package thirdstage.petstore1.services;

// to use SessionFatory.convertHibernateAccessException static method
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.toplink.SessionFactory;

import java.util.List;
import org.springframework.dao.DataAccessException;
import thirdstage.petstore1.domain.entities.Account;
import thirdstage.petstore1.domain.entities.Category;
import thirdstage.petstore1.domain.entities.Item;
import thirdstage.petstore1.domain.entities.Order;
import thirdstage.petstore1.domain.entities.Product;

/**
 * <p>Implements PetStoreFacade interface using plain HibernateSession
 * to access entities and using DataAccessExceptions from Springframework.</p>
 * <p>This implementation has no explicit programmatic transaction 
 * management and so needs external transaction declaration.</p> 
 * 
 * @author 3rdstage
 * 
 */
public class PetStoreHibernateFacade2 implements PetStoreFacade{

	private SessionFactory hibernateSessionFactory;
	
	
	//block start : constructors
	public PetStoreHibernateFacade2(){
		super();
	}
	//block end : constructors
	
	
	
	//start of block : accessers and mutators
	/**
	 * To inject dependency for SessionFactory
	 */
	@org.springframework.beans.factory.annotation.Required
	public void setHibernateSessionFactory(SessionFactory sessionFactory){
		this.hibernateSessionFactory = sessionFactory;
	}

	protected SessionFactory getHibernateSessionFactory(){
		return this.hibernateSessionFactory;
	}
	//end of block : accessors and mutators
	
	
	//start of block : business methods
	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#addAccount(thirdstage.petstore1.domain.entities.Account)
	 */
	public void addAccount(Account account) throws DataAccessException{
	
		try{
			//TODO
			
		}
		catch(HibernateException ex){
			SessionFactoryUtils.convertHibernateAccessException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getAccount(java.lang.String)
	 */
	public Account getAccount(String username) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getAccount(java.lang.String,
	 *      java.lang.String)
	 */
	public Account getAccount(String username, String password) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getAllCategorys()
	 */
	public List<Category> getAllCategorys() throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getAllUsernames()
	 */
	public List<String> getAllUsernames(){
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getCategory(java.lang.String)
	 */
	public Category getCategory(String categoryId) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getItem(java.lang.String)
	 */
	public Item getItem(String itemId) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getItemsByProduct(java.lang.String)
	 */
	public List<Item> getItemsByProduct(String productId) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getOrder(int)
	 */
	public Order getOrder(int orderId) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getOrdersByUsername(java.lang.String)
	 */
	public List<Order> getOrdersByUsername(String username) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getProduct(java.lang.String)
	 */
	public Product getProduct(String productId) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#getProductsByCategory(java.lang.String)
	 */
	public List<Product> getProductsByCategory(String categoryId) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#isItemInStock(java.lang.String)
	 */
	public boolean isItemInStock(String itemId) throws DataAccessException{
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#makeOrder(thirdstage.petstore1.domain.entities.Order)
	 */
	public void makeOrder(Order order) throws DataAccessException{
	// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#searchProductsByKeyword(java.lang.String)
	 */
	public List<Product> searchProductsByKeyword(String keyword) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.domain.logic.PetStoreFacade#updateAccount(thirdstage.petstore1.domain.entities.Account)
	 */
	public void updateAccount(Account account) throws DataAccessException{
	// TODO Auto-generated method stub

	}
	//end of block : business methods
}
