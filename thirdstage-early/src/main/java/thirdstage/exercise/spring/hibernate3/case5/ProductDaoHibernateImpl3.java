

package thirdstage.exercise.spring.hibernate3.case5;

/**
 * DAO implementation for Hibernate 3.x
 *
 * @author 3rdstage
 * 
 * @spring.bean id="productDao3"
 * @spring.property name="sessionFactory" ref="hibernateSessionFactory"
 */
public class ProductDaoHibernateImpl3 implements ProductDao{
	
	private org.hibernate.SessionFactory sessionFactory = null;
	
	/** Creates a new instance of ProductDaoHibernateImpl3 */
	public ProductDaoHibernateImpl3() {
	}
	
	public org.hibernate.SessionFactory getSessionFactory(){ return this.sessionFactory; }
	public void setSessionFactory(org.hibernate.SessionFactory factory){ 
		this.sessionFactory = factory;
	}
	
	public java.util.Collection getProductsByCategory(String category) throws Exception{
		org.hibernate.Session session = null;
		java.util.Collection products = null;
		
		try{
			//session = this.getSessionFactory().getCurrentSession();
			session = this.getSessionFactory().openSession();
			
			products = session.createQuery("from Product as product where product.category = ?")
						 .setParameter(0, category)
						 .list();
			
			return products;
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			if(session != null & session.isOpen()){
				try{ session.close(); }
				catch(Exception ex2){}
			}
		}
		
	}
	
	public java.util.List<Product> getProductsByCategory2(String category) throws Exception{
		org.hibernate.Session session = null;
		java.util.List<Product> products = null;
		
		try{
			session = this.getSessionFactory().openSession();
			
			products = session.getNamedQuery("findProductsByCategory")
			                  .setParameter("category", category)
									.list();
			
			if(products == null) products = new java.util.ArrayList<Product>();
			
			return products;
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			if(session != null){
				try{ session.close(); }
				catch(Exception ex2){}
			}
		}
	}

}
