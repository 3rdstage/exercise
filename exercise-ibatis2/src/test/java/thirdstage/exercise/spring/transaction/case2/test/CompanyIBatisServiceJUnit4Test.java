/**
 * 
 */
package thirdstage.exercise.spring.transaction.case2.test;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import thirdstage.exercise.spring.transaction.case2.CompanyService;
import thirdstage.exercise.spring.transaction.case2.daos.CompanyDao;

/**
 * @author 3rdstage
 *
 */
public class CompanyIBatisServiceJUnit4Test extends CompanyServiceJUnit4Test{

	private static final Logger logger = Logger.getLogger(CompanyIBatisServiceJUnit4Test.class);
	private static ApplicationContext applContext;
	private static IDataSet dataSet;
	private CompanyService companyService;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{

		// initialize Log4j
		Properties props = new Properties();
		props.load((new ClassPathResource("confs/log4j-exercise.properties", CompanyService.class)).getInputStream());
		org.apache.log4j.PropertyConfigurator.configure(props);

		// load springframework context
		applContext = new ClassPathXmlApplicationContext("confs/spring-exercise-ibatis.xml", CompanyService.class);

		// create DbUnit core components
		IDatabaseConnection conn = new DatabaseDataSourceConnection((DataSource)applContext.getBean("dataSource"));
		dataSet = new FlatXmlDataSet((new ClassPathResource("thirdstage/exercise/spring/transaction/case2/test/dataset/company-building-factory-seed-01.xml")).getFile());

		// clean target tables and load test data
		try{
			DatabaseOperation.CLEAN_INSERT.execute(conn, dataSet);
		}finally{
			conn.close();
		}
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		applContext = null;
		dataSet = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		this.companyService = (CompanyService)(applContext.getBean("companyService"));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{}

	@Override
	protected IDataSet getSeedDataSet(){
		return this.dataSet;
	}
	
	@Override
	protected CompanyService getCompanyService(){
		return this.companyService;
	}
}
