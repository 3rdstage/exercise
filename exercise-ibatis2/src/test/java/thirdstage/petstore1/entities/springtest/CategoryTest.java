package thirdstage.petstore1.entities.springtest;

import static org.junit.Assert.*;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import thirdstage.petstore1.entities.Category;

@TransactionConfiguration(transactionManager="defaultTransactionManager", defaultRollback=false)
@Transactional
public class CategoryTest extends BaseEntityTest{

	private static Logger logger = Logger.getLogger(CategoryTest.class);
	
	@Test
	public void testGetCategory(){
		logger.debug("method started");
		
		SessionFactory fac = this.getSessionFactory();
		
		try{
			fac.getCurrentSession().beginTransaction();
			Category cat = (Category)(fac.getCurrentSession().load(Category.class, "BIRDS"));
			fac.getCurrentSession().getTransaction().commit();
			
			assertEquals("Birds", cat.getName());
		}catch(Exception ex){
			fac.getCurrentSession().getTransaction().rollback();
		}
		
		logger.debug("method ending");		
	}
	
	
	
}
