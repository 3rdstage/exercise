package thirdstage.exercise.spring.transaction.case2.entities.test;

import static org.junit.Assert.*;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import thirdstage.exercise.spring.transaction.case2.CompanyService;

public abstract class BaseJUnit4Test{

	private static Logger logger = Logger.getLogger(BaseJUnit4Test.class);
	private static ApplicationContext springContext;
	private static IDataSet seedDataSet;
	private static SessionFactory hibernateSessionFactory;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		// initialize Log4j
		Properties props = new Properties();
		props.load((new ClassPathResource("confs/log4j-exercise.properties", CompanyService.class)).getInputStream());
		org.apache.log4j.PropertyConfigurator.configure(props);
		
		logger.info("Loading spring's application context and hibernate's session factory");

		// load spring's application framework
		springContext = new ClassPathXmlApplicationContext("thirdstage/exercise/spring/transaction/case2/confs/spring-exercise-hibernate.xml");
		
		// create DbUnit core components
		IDatabaseConnection conn = new DatabaseDataSourceConnection((DataSource)springContext.getBean("dataSource"));
		seedDataSet = new FlatXmlDataSet((new ClassPathResource("thirdstage/exercise/spring/transaction/case2/test/dataset/company-building-factory-seed-01.xml")).getFile());

		// clean target tables and load test data
		try{
			DatabaseOperation.CLEAN_INSERT.execute(conn, seedDataSet);
		}finally{
			conn.close();
		}
		
		// load hibernate's session factory
		hibernateSessionFactory = (SessionFactory)(springContext.getBean("hibernateSessionFactory")); 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		seedDataSet = null;
		hibernateSessionFactory = null;
		springContext = null;
	}

	protected IDataSet getSeedDataSet(){
		return seedDataSet;
	}
	
	protected SessionFactory getHibernateSessionFactory(){
		return hibernateSessionFactory;
	}
	
	@Test
	@Ignore("This method is only dummy, not for real test")
	public void testNothing(){
		assertTrue(true);
	}

}
