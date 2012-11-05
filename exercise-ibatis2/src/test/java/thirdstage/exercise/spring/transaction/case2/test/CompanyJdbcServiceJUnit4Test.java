/**
 * 
 */
package thirdstage.exercise.spring.transaction.case2.test;

import org.apache.log4j.Logger;
import static org.junit.Assert.*;
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
import thirdstage.exercise.spring.transaction.case2.CompanyService;
import thirdstage.exercise.spring.transaction.case2.daos.CompanyDao;
import thirdstage.exercise.spring.transaction.case2.entities.Building;
import thirdstage.exercise.spring.transaction.case2.entities.Company;
import thirdstage.exercise.spring.transaction.case2.entities.Factory;

/**
 * @author 3rdstage
 * 
 */
public class CompanyJdbcServiceJUnit4Test extends CompanyServiceJUnit4Test{

	private static final Logger logger = Logger.getLogger(CompanyJdbcServiceJUnit4Test.class);
	private static ApplicationContext applContext;
	private static IDataSet dataSet;
	private CompanyDao companyDao;
	private CompanyService companyService;
	private CompanyService companyServiceWithDefect;
	private CompanyService companyServiceWithDefect2;

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
		companyDao = (CompanyDao)applContext.getBean("companyDao");
		companyService = (CompanyService)applContext.getBean("companyService");
		companyServiceWithDefect = (CompanyService)applContext.getBean("companyServiceWithDefect");
		companyServiceWithDefect2 = (CompanyService)applContext.getBean("companyServiceWithDefect2");
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
	
	protected CompanyService getCompanyServiceWithDefect1(){
		return this.companyServiceWithDefect;
	}
	
	protected CompanyService getCompanyServiceWithDefect2(){
		return this.companyServiceWithDefect2;
	}

	protected CompanyDao getCompanyDao(){
		return this.companyDao;
	}

	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.CompanyJdbcService#addCompany(thirdstage.exercise.spring.transaction.case2.entities.Company)}.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testAddCompanyWithDefect() throws Exception{
		Company company = new Company();
		company.setName("삼성전자");

		Building building = new Building();
		building.setName("서울 본사");
		company.addBuilding(building);
		building = new Building();
		building.setName("서울 강남 신본사");
		company.addBuilding(building);
		building = new Building();
		building.setName("수원 지사");

		Factory factory = new Factory();
		factory.setName("기흥 1 공장");
		company.addFactory(factory);
		factory = new Factory();
		factory.setName("기흥 2 공장");
		company.addFactory(factory);
		factory = new Factory();
		factory.setName("구미 공장");
		company.addFactory(factory);

		try{
			this.getCompanyServiceWithDefect1().addCompany(company);
		}catch(UnsupportedOperationException ex){
			assertEquals(this.getSeedDataSet().getTable("COMPANY").getRowCount(), this.getCompanyDao().getAllCompanies().size());
			
			this.logger.error("Fail to add company", ex);

			System.out.println("Company : " + company.getId() + ", " + company.getName());
			for(Building building2 : company.getBuildings()){
				System.out.println("Building : " + building2.getId() + ", " + building2.getName());
			}
			for(Factory factory2 : company.getFactories()){
				System.out.println("Building : " + factory2.getId() + ", " + factory2.getName());
			}

			throw ex;
		}

		//The expected case never reach here.
		assertFalse(true);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testAddCompanyWithDefect2() throws Exception{
		Company company = new Company();
		company.setName("SK Telecom");

		Building building = new Building();
		building.setName("서울 본사");
		company.addBuilding(building);
		building = new Building();
		building.setName("중국 베이징 지사");
		company.addBuilding(building);
		building = new Building();
		building.setName("미국 캘리포니아 지사");

		Factory factory = new Factory();
		factory.setName("구미 1 공장");
		company.addFactory(factory);
		factory = new Factory();
		factory.setName("구미 2 공장");
		company.addFactory(factory);

		try{
			this.getCompanyServiceWithDefect2().addCompany(company);
		}catch(UnsupportedOperationException ex){
			assertEquals(this.getSeedDataSet().getTable("COMPANY").getRowCount(), this.getCompanyDao().getAllCompanies().size());
			
			this.logger.error("Fail to add company", ex);

			System.out.println("Company : " + company.getId() + ", " + company.getName());
			for(Building building2 : company.getBuildings()){
				System.out.println("Building : " + building2.getId() + ", " + building2.getName());
			}
			for(Factory factory2 : company.getFactories()){
				System.out.println("Building : " + factory2.getId() + ", " + factory2.getName());
			}

			throw ex;
		}

		//The expected case never reach here.
		assertFalse(true);
	}
	
}
