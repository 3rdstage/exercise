package thirdstage.petstore1.entities.test;

import java.io.File;
import java.util.Properties;
import javax.sql.DataSource;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public abstract class BaseEntityTest{

	private static ApplicationContext springContext;
	private static ReplacementDataSet testData;
	private static SessionFactory hibernateSessionFactory;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		
		// init Log4j
		Properties props = new Properties();
		props.load((new ClassPathResource("thirdstage/petstore1/test/confs/log4j-petstore.properties")).getInputStream());
		org.apache.log4j.LogManager.resetConfiguration();
		org.apache.log4j.PropertyConfigurator.configure(props);
		
		// load spring's application context
		springContext = new ClassPathXmlApplicationContext("thirdstage/petstore1/confs/hibernate/spring-petstore.xml");

		// load hibernate session factory
		hibernateSessionFactory = (SessionFactory)(springContext.getBean("defaultHibernateSessionFactory"));
		
		// load test data
		DataSource ds = (DataSource)(springContext.getBean("defaultDataSource"));
		IDatabaseConnection conn = new MySqlConnection(ds.getConnection(), "petstore1d");
		
		File f = new ClassPathResource("thirdstage/petstore1/test/dataset/dataset-seed-petstore1.xml").getFile();
		testData = new ReplacementDataSet(new FlatXmlDataSet(f));
		testData.addReplacementObject("[null]", null);

		boolean isAutoCommit = conn.getConnection().getAutoCommit();
		conn.getConnection().setAutoCommit(true);
		conn.getConfig().setFeature(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);
		
		try{
			DatabaseOperation.TRUNCATE_TABLE.execute(conn, testData);
			DatabaseOperation.INSERT.execute(conn, testData);
		}finally{
			conn.getConnection().setAutoCommit(isAutoCommit);
			conn.close();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		testData = null;
		hibernateSessionFactory = null;
		springContext = null;
	}


	protected ApplicationContext getSpringContext(){
		return springContext;
	}
	
	protected IDataSet getTestData(){
		return testData;
	}
	
	protected SessionFactory getHibernateSessionFactory(){
		return hibernateSessionFactory;
	}
	
}
