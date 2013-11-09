
package thirdstage.sample.insurance.managers;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import thirdstage.framework.mars.exceptions.*;
import thirdstage.sample.insurance.entities.*;
import thirdstage.sample.insurance.values.*;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005년 10월 23일 (일)
 * @since 2005년 10월 23일 (일)
 */
public class PersonManagerHibernate implements PersonManager, thirdstage.framework.mars.Manager{
	
	/**
	 * factory for hibernate session
	 */
	private SessionFactory sessionFactory = null;
	
	/**
	 * logger for this object
	 */
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PersonManagerHibernate.class);
	
	/**
	 * Creates a new instance of PersonManagerHibernate using a session
	 *
	 */
	public PersonManagerHibernate() {	}
	
	/**
	 * Creates a new instance of PersonManagerHibernate with given database session
	 */
	public PersonManagerHibernate(SessionFactory factory){
		this.sessionFactory = factory;
	}
	
	public void createPerson(Person person) throws SystemException{ }
	
	public void createIndividual(Individual individual) throws SystemException{
		logger.info(Thread.currentThread().getName() + " : createIndividual() method entered");
				
		Session sess = null;
		Transaction tx = null;
		
		try{
			sess = sessionFactory.openSession();
			tx = sess.beginTransaction();
			sess.save(individual);
			tx.commit();
		}
		catch(Exception ex){
			if(tx != null){
				try{ tx.rollback(); }
				catch(Exception ex2){ this.logger.error(ex2); }
			}
			this.logger.error(ex);
		   throw new SystemException("Exception in PersonManagerHibernate.crateIndividual()", ex);
		}
		finally{
			if(sess != null){
				try{ sess.close(); }
				catch(Exception ex){ this.logger.error(ex); }
			}
		}
		
		logger.info(Thread.currentThread().getName() + " : createIndividual() method leaving");
	}
	
	public void createCorporation(Corporation corporation) throws SystemException{ }
	
	public Person[] findAllPersons() throws SystemException{
		return null;
	}
	
	public Person findPerson(String id) throws SystemException{
		this.logger.info(Thread.currentThread().getName() + " : findPerson method entered");
		
		return null;
	}
	
	public Individual[] findAllIndividuals() throws SystemException{
		logger.info("findAllIndividuals() method entered");
		
		Session sess = null;
		List individuals = new ArrayList();
		DetachedCriteria queryAll = null;
		
		try{
			queryAll = DetachedCriteria.forClass(thirdstage.sample.insurance.entities.Individual.class)
			.addOrder(Order.asc("id"));
			
			sess = sessionFactory.openSession();
			individuals = queryAll.getExecutableCriteria(sess).setMaxResults(10).list();
		} catch(Exception ex){
			logger.error(ex);
			throw new SystemException("Exception in PersonManagerHibernate.findAllIndividuals()", ex);
		} finally{
			if(sess != null){
				try{ sess.close(); } catch(Exception ex){ logger.error(ex); }
			}
		}
		
		logger.info(Thread.currentThread().getName() + " : findAllIndividuals() method leaving");
		return (Individual[])(individuals.toArray(new Individual[individuals.size()]));
	}
	
	/**
	 * Finds individual object having a given <code>id</code>.
	 * Returns <code>null</code> if there's no individual with the given <code>id</code>
	 *
	 */
	public Individual findIndividual(String id) throws SystemException{
		logger.info(Thread.currentThread().getName() + " : findIndividual() method entered");
		
		org.hibernate.classic.Session sess = null;
		java.util.List results = null;
		
		try{
			sess = this.sessionFactory.openSession();
			results = sess.find("select p from " + Individual.class.getName() + " as p where p.id = ?", id, org.hibernate.Hibernate.STRING);
		}
		catch(Exception ex){
			logger.error("Exception in PersonManagerHibernate.findIndividual()", ex);
		}
		finally{
			if(sess != null){
				try{ sess.close(); }
				catch(Exception ex){ logger.error(ex); }
			}
		}
		
		logger.info(Thread.currentThread().getName() + " : findIndividual() method leaving");
		if(results != null && results.size() > 0) return (Individual)(results.get(0));
		else return null;
	}
	
	public Corporation[] findAllCorporations() throws SystemException{
		return null;
	}
	
	
}
