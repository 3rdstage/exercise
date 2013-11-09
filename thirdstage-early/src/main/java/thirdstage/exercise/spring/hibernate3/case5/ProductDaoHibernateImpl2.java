package thirdstage.exercise.spring.hibernate3.case5;

import org.hibernate.Session;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * DAO implementation for Hibernate 2.x
 * 
 * @author 3rdstage
 * @since 2006-07-07
 */
public class ProductDaoHibernateImpl2 extends HibernateDaoSupport implements ProductDao {
	
	/** Creates a new instance of ProductDaoHibernateImpl */
	public ProductDaoHibernateImpl2() {
	}
	
	public java.util.Collection getProductsByCategory(String category) throws DataAccessException{
		Session session = this.getSession(false);
		
		try{
			java.util.List result = session.createQuery("from Product as product where product.category = ?")
			                               .setString(0, category)
													 .list();
			if(result == null){
				result = new java.util.ArrayList();
			}
			return result;
		}
		catch(HibernateException ex){
			throw this.convertHibernateAccessException(ex);
		}
	}
	
	public java.util.List<Product> getProductsByCategory2(String category) throws DataAccessException{
		
		return null;
	}
	
}
