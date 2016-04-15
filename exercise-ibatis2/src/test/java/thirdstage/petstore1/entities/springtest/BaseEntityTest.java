package thirdstage.petstore1.entities.springtest;

import static org.junit.Assert.*;
import java.io.File;
import java.util.Properties;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import thirdstage.petstore1.entities.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/thirdstage/petstore1/confs/hibernate/spring-petstore.xml" })
@TransactionConfiguration(transactionManager="defaultTransactionManager", defaultRollback=false)
public class BaseEntityTest{

	private static Logger logger = Logger.getLogger(BaseEntityTest.class);
	
	@Resource
	private SessionFactory defaultHibernateSessionFactory;

	@Resource
	private BasicDataSource dataSource;

	private ReplacementDataSet testData;

	@BeforeTransaction
	public void setUpBase() throws Exception{
		// init Log4j
		Properties props = new Properties();
		props.load((new ClassPathResource("thirdstage/petstore1/test/confs/log4j-petstore.properties")).getInputStream());
		org.apache.log4j.LogManager.resetConfiguration();
		org.apache.log4j.PropertyConfigurator.configure(props);

		synchronized(this){
			if(testData == null){
				IDatabaseConnection conn = new MySqlConnection(dataSource.getConnection(), "petstore1d");

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
		}

	}

	@AfterTransaction
	public void tearDownBase() throws Exception{

	}

	protected SessionFactory getSessionFactory(){
		return this.defaultHibernateSessionFactory;
	}

	protected DataSource getDataSource(){
		return this.dataSource;
	}

	protected IDataSet getTestData(){
		return this.testData;
	}
	
	@Test
	public void testToSuceess(){
		assertTrue(true);
	}
	


}
