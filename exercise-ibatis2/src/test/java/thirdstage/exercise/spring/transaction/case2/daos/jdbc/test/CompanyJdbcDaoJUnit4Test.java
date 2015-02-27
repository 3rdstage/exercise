/**
 * 
 */
package thirdstage.exercise.spring.transaction.case2.daos.jdbc.test;

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
import thirdstage.exercise.spring.transaction.case2.daos.CompanyDao;
import thirdstage.exercise.spring.transaction.case2.daos.ibatis.CompanyIBatisDao;
import thirdstage.exercise.spring.transaction.case2.daos.jdbc.CompanyJdbcDao;
import thirdstage.exercise.spring.transaction.case2.daos.test.CompanyDaoJUnit4Test;
import thirdstage.exercise.spring.transaction.case2.entities.Company;

/**
 * This class initiates(deletes all rows and inserts the prepared data) the underlying tables(company, building, factory) in database using DbUnit framework.
 * 
 * @author 3rdstage
 * 
 */
public class CompanyJdbcDaoJUnit4Test extends CompanyDaoJUnit4Test{

	protected static ApplicationContext applContext;
	protected static IDataSet dataSet;
	protected CompanyJdbcDao companyDao;

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
		applContext = new ClassPathXmlApplicationContext("confs/spring-exercise-jdbc.xml", CompanyService.class);

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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		companyDao = new CompanyJdbcDao();
		companyDao.setDataSource((DataSource)(this.applContext.getBean("dataSource")));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{}

	@Override
	protected CompanyDao getCompanyDao(){
		return this.companyDao;
	}
	

}
