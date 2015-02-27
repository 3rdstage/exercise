/**
 * 
 */
package thirdstage.exercise.spring.transaction.case2;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import thirdstage.exercise.spring.transaction.case2.entities.Company;

/**
 * @author 3rdstage
 *
 */
public class CompanyHibernateService implements CompanyService{

	
	private SessionFactory sessionFactory;
	
	
	protected SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	
	@Required
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see thirdstage.exercise.spring.transaction.case2.CompanyService#addCompany(thirdstage.exercise.spring.transaction.case2.Company)
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void addCompany(Company company) throws DataAccessException{
		
		SessionFactory sessFactory = this.getSessionFactory();
		sessFactory.getCurrentSession().persist(company);
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.spring.transaction.case2.CompanyService#getCompany(java.lang.String)
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Company getCompany(Long id) throws DataAccessException{
		
		Company company = (Company)this.getSessionFactory().getCurrentSession().load(Company.class, id);
		
		// load collection set to lazy initialization 
		company.getFactories().size();
		
		return company;
	
	}

}
