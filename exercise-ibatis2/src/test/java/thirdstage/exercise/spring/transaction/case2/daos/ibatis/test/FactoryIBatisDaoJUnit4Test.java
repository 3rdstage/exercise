/**
 * 
 */
package thirdstage.exercise.spring.transaction.case2.daos.ibatis.test;

import static org.junit.Assert.*;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import com.ibatis.sqlmap.client.SqlMapClient;
import thirdstage.exercise.spring.transaction.case2.CompanyService;
import thirdstage.exercise.spring.transaction.case2.daos.FactoryDao;
import thirdstage.exercise.spring.transaction.case2.daos.ibatis.FactoryIBatisDao;
import thirdstage.exercise.spring.transaction.case2.daos.test.FactoryDaoJUnit4Test;
import thirdstage.exercise.spring.transaction.case2.entities.Company;
import thirdstage.exercise.spring.transaction.case2.entities.Factory;

/**
 * The order of test methods is important. So, don't change the order and
 * add new test methods at the end.
 * 
 * @author 3rdstage
 *
 */
public class FactoryIBatisDaoJUnit4Test extends FactoryDaoJUnit4Test{

	private static ApplicationContext applContext;
	private static IDataSet dataSet;
	private FactoryIBatisDao factoryDao;

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
		dataSet = null;
		applContext = null;
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		factoryDao = new FactoryIBatisDao();
		factoryDao.setSqlMapClient((SqlMapClient)(this.applContext.getBean("sqlMapClient")));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{}

	@Override
	protected FactoryDao getFactoryDao(){
		return this.factoryDao;
	}

	@Override
	protected IDataSet getSeedDataSet(){
		return this.dataSet;
	}


}
