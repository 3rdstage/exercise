/**
 * 
 */
package thirdstage.exercise.spring.transaction.case2.entities.test;

import static org.junit.Assert.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import thirdstage.exercise.spring.transaction.case2.entities.Building;
import thirdstage.exercise.spring.transaction.case2.entities.Company;
import thirdstage.exercise.spring.transaction.case2.entities.Factory;

/**
 * @author 3rdstage
 *
 */
public class CompanyJUnit4Test extends BaseJUnit4Test{

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{}

	

	/**
	 * Test method for {@link thirdstage.exercise.spring.transaction.case2.entities.Company#getName()}.
	 */
	@Test
	public void testGetName(){

		Company company = null;
		Session session = this.getHibernateSessionFactory().openSession();
		
		try{
			session.beginTransaction();
			company = (Company)session.load(Company.class, new Long(1L));
			session.getTransaction().commit();
		}catch(Exception ex){
			session.getTransaction().rollback();
		}

		assertEquals("Google", company.getName());
	}

	
	/**
	 * Test method for {@link thirdstage.exercise.spring.transaction.case2.entities.Company#getBuildings()}.
	 */
	@Test
	public void testGetBuildings(){
		Company company = null;
		List<Building> buildings = null;
		Session session = this.getHibernateSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			company = (Company)session.load(Company.class, new Long(1L));
	
			/* IMPORTANT Loading of eager initializing collection.
			 * 
			 * If the following line is located after the session.close, it would fire
			 * an exception. It is not an expected behavior because the buildins collection
			 * is set to eager fetch.
			 * 
			 * Check the reason and the generated queries.
			 */
			buildings = company.getBuildings();
			
			tx.commit();
		}catch(Exception ex){
			if(tx != null) tx.rollback();
		}finally{
			session.close();
		}

	
		assertEquals("Main Tower", buildings.get(0).getName());
		assertEquals("Main R&D Tower", buildings.get(1).getName());
		assertEquals("Seoul Office", buildings.get(2).getName());
	}

	/**
	 * Test method for {@link thirdstage.exercise.spring.transaction.case2.entities.Company#getFactories()}.
	 */
	@Test
	public void testGetFactories(){
		Company company = null;
		List<Factory> factories = null;
		Session session = this.getHibernateSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			company = (Company)session.load(Company.class, new Long(3L));

			// load collection which is set to lazy fetch
			factories = company.getFactories();

			
			/* IMPORTANT Loading of lazy initializing collection.
			 *
			 * Without the following code block, exception would arise.
			 * Check the behind and the generated queries.
			 * 
			 * Check the difference with above test which would load
			 * buildings which are eager initialized collection.
			 */
			factories.size();

			tx.commit();
		}catch(Exception ex){
			if(tx != null) tx.rollback();
		}finally{
			session.close();
		}
	
		assertEquals("Printer Factory at California", factories.get(0).getName());
		assertEquals("Copy Machine Factory 1 at China", factories.get(1).getName());
	}

}
