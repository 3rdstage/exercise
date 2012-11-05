package thirdstage.petstore1.entities.test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import thirdstage.petstore1.entities.Category;

public class CategoryTest extends BaseEntityTest{

	private static Logger logger = Logger.getLogger(CategoryTest.class);

	@Before
	public void setUp() throws Exception{}

	@After
	public void tearDown() throws Exception{}

	
	@Test
	public void testGetCategory() throws Exception{
		logger.debug("method started");
		
		Session sess = this.getHibernateSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			tx = sess.beginTransaction();
			Category cat = (Category)(sess.get(Category.class, "BIRDS"));
			tx.commit();
			
			assertEquals("Birds", cat.getName());
			
		}catch(Exception ex){
			if(tx != null) tx.rollback();
		}finally{
			if(sess != null) sess.close();
		}
		
		logger.debug("method ending");
	}
	
	
	
}
