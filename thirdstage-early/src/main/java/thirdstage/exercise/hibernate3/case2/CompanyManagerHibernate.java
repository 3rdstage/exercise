
package thirdstage.exercise.hibernate3.case2;


import java.util.List;
import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import thirdstage.framework.mars.exceptions.SystemException;
/**
 * Hibernate One-to-Many Collection Example
 *
 * @author 3rdstage
 * @version 1.0, 2005-11-16, 3rdstage
 * @since 2005-11-16
 */
public class CompanyManagerHibernate implements CompanyManager, thirdstage.framework.mars.Manager{
	
	private SessionFactory sessionFactory = null;
	
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CompanyManagerHibernate.class);
	
	/**
	 * Creates a new instance of CompanyManagerHibernate
	 * This class has no default constructor
	 */
	public CompanyManagerHibernate(SessionFactory factory) {
		this.sessionFactory = factory;
	}
	
	public Company findCompany(String id) throws SystemException{
		logger.info(Thread.currentThread().getName() + " : findCompany method entered");
		
		Session sess = null;
		Company company = null;
		
		try{
			sess = sessionFactory.openSession();
			company = (Company)(sess.get(Company.class, id));
		} catch(Exception ex){
			logger.error(ex);
			throw new SystemException("Exception in CompanyManagerHibernate.findCompany method", ex);
		} finally{
			if(sess != null){
				try{ sess.close(); }catch(Exception ex){ logger.error(ex); }
			}
		}
		
		logger.info(Thread.currentThread().getName() + " : findCompany method leaving");
		return company;
	}
	
}
