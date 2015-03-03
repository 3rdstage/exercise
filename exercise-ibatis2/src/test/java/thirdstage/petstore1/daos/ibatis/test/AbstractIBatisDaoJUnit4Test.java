package thirdstage.petstore1.daos.ibatis.test;

import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Base class of JUnit4 test classes for DAOs based on iBATIS 2. Every call of test methods in subclasses would be roll-backed 'cause this class declares transaction roll-back in tearDown method.
 * 
 * @version 1.0 2008-06-25
 * @author 3rdstage
 * 
 */
public abstract class AbstractIBatisDaoJUnit4Test{

	private static ApplicationContext applContext;

	/**
	 * iBAITS' SqlMapClient instance.
	 * 
	 * IMPORTANT Thread-safeness of SqlMapClient 
	 * Notice that SqlMapClient is thread safe 'cause it provides internal session management
	 * 
	 * @see <a href="http://ibatis.apache.org/docs/java/user/com/ibatis/sqlmap/client/SqlMapClient.html">SqlMapClient API</a>
	 */
	private static SqlMapClient sqlMapClient;
	
	private static IDataSet seedDataSet;


	@BeforeClass
	public static void setUpBeforeClassBase() throws Exception{
		// initialize Log4j
		Properties props = new Properties();
		props.load((new ClassPathResource("thirdstage/petstore1/test/confs/log4j-petstore.properties")).getInputStream());
		org.apache.log4j.LogManager.resetConfiguration();
		org.apache.log4j.PropertyConfigurator.configure(props);

		com.ibatis.common.logging.LogFactory.selectLog4JLogging();

		// get springframework context
		applContext = new ClassPathXmlApplicationContext("thirdstage/petstore1/test/confs/ibatis/spring-petstore-daos.xml");

		// get iBATIS' SqlMapClient object from context
		sqlMapClient = (SqlMapClient)(applContext.getBean("sqlMapClient"));
		
		// load seed data into database using dbunit
		DataSource dataSource = (DataSource)(getApplicationContext().getBean("dataSource"));
		IDatabaseConnection conn = new MySqlConnection(dataSource.getConnection(), "petstore1d");
		seedDataSet = new FlatXmlDataSet((new ClassPathResource("thirdstage/petstore1/test/dataset/dataset-seed-petstore1.xml")).getFile());
		DatabaseConfig config = conn.getConfig();

		/*
		 * IMPORTANT Using keyword at table name and DbUnit 
		 * 
		 * To use lower-cased keywords (like "order") with table name in MySQL,
		 * set 'lower-case-table-names' system variable of MySQL to '0' on UNIX
		 * or '2' on Windows and set FEATURE_QUALIFIED_TABLE_NAMES of DbUnit's 
		 * IDatabaseConnection to 'true'.
		 * Note that 'lower-case-table-names' is not dynamic variable, so you
		 * should set it at start-up like using my.ini.
		 * 
		 * All these complicated setups can be removed, if DbUnit supports
		 * automatic identifier quotation or something like that. It seems
		 * not supported in current version. But, I think I should post question
		 * on forums if any.
		 * 
		 */
		config.setFeature(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);
		
		try{
			DatabaseOperation.CLEAN_INSERT.execute(conn, seedDataSet);
		}finally{
			conn.close();
		}
	}

	@AfterClass
	public static void tearDownAfterClassBase(){
		seedDataSet = null;
		sqlMapClient = null;
		applContext = null;
	}

	/*
	 * FIXME Programmatic control of SqlMapClient's transaction.
	 * Below startTransaction() and rollbackTransaction() don't work in expected way.
	 * They seem to cause errors in returning used connections to datasource.
	 * Should check more.
	 */

	@Before
	public void setUpBase() throws SQLException{
	}

	@After
	public void tearDownBase() throws SQLException{
	}

	/**
	 * 
	 * @return Springframework's application context for this test
	 */
	protected static ApplicationContext getApplicationContext(){
		return applContext;
	}

	protected static SqlMapClient getSqlMapClient(){
		return sqlMapClient;
	}

	protected static IDataSet getSeedDataSet(){
		return seedDataSet;
	}
}
