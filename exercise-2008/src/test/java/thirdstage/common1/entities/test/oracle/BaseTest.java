/**
 * 
 */
package thirdstage.common1.entities.test.oracle;


import java.io.File;
import java.util.Properties;
import java.util.Set;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.oracle.OracleConnection;
import org.dbunit.ext.oracle.OracleDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import thirdstage.purple.sql.DatabaseMetaDataMap;

/**
 * @author 3rdstage
 *
 */
public class BaseTest {
	
	protected static ApplicationContext springContext;
	protected static SessionFactory sessionFactory;
	protected static IDataSet testDataSet;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClassBase() throws Exception {
		Properties props = new Properties();
		props.load((new ClassPathResource("thirdstage/common1/confs/log4j-common.properties")).getInputStream());
		org.apache.log4j.LogManager.resetConfiguration();
		org.apache.log4j.PropertyConfigurator.configure(props);

		springContext = new ClassPathXmlApplicationContext("thirdstage/common1/confs/spring-common.oracle.xml");
		sessionFactory = (SessionFactory)(springContext.getBean("hibernateSessionFactory"));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClassBase() throws Exception {
		springContext = null;
		sessionFactory = null;
		testDataSet = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	protected void cleanAndLoadTestData(File testDataSetFile) throws Exception{
		IDatabaseConnection conn = new OracleConnection(((DataSource)springContext.getBean("dataSource")).getConnection(), "exercise");
		boolean isAutoCommit = conn.getConnection().getAutoCommit();
		conn.getConnection().setAutoCommit(true);
		DatabaseConfig config = conn.getConfig();
		conn.getConfig().setFeature(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, false);
		conn.getConfig().setFeature(DatabaseConfig.FEATURE_SKIP_ORACLE_RECYCLEBIN_TABLES, true);
		conn.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());

		testDataSet = new ReplacementDataSet(new FlatXmlDataSet(testDataSetFile));
		((ReplacementDataSet)testDataSet).addReplacementObject("[null]", null);
		
		try{
			/* IMPORTANT Oracle and DbUnit's TRUNCATE_TABLE Operation, 2008-10-31
			 * 
			 * With oracle database, TRUNCATE_TABLE database operation of DbUnit wouldn't work correctly 
			 * where DELETE_ALL operation works well.
			 * But, no reason is suspected.
			 * 
			 */
			//DatabaseOperation.TRUNCATE_TABLE.execute(conn, testDataSet);
			DatabaseOperation.DELETE_ALL.execute(conn, testDataSet);
			DatabaseOperation.INSERT.execute(conn, testDataSet);
		}finally{
			conn.getConnection().setAutoCommit(isAutoCommit);
			conn.close();
		}
	}	
	
	@Test
	public void testDatabaseMetaData() throws Exception{
		
		DataSource dataSource = (DataSource)(springContext.getBean("dataSource"));
		DatabaseMetaDataMap meta = new DatabaseMetaDataMap(dataSource.getConnection().getMetaData());
		
		Set<String> keys = meta.getKeySet();
		
		for(String key : keys){
			System.out.println(key + " : " + meta.get(key));
		}
	}
}
