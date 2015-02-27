/**
 * 
 */
package thirdstage.exercise.spring.transaction.case2.daos.test;

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
import thirdstage.exercise.spring.transaction.case2.CompanyService;
import thirdstage.exercise.spring.transaction.case2.daos.FactoryDao;
import thirdstage.exercise.spring.transaction.case2.daos.jdbc.FactoryJdbcDao;
import thirdstage.exercise.spring.transaction.case2.entities.Company;
import thirdstage.exercise.spring.transaction.case2.entities.Factory;

/**
 * @author 3rdstage
 * 
 */
public abstract class FactoryDaoJUnit4Test{

	protected abstract IDataSet getSeedDataSet();
	protected abstract FactoryDao getFactoryDao();
	
	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.daos.jdbc.FactoryJdbcDao#addFactory(thirdstage.exercise.spring.transaction.case2.entities.Factory)}.
	 */
	@Test
	public void testAddFactory() throws Exception{
		Company company = new Company();
		company.setId(2L);
		Factory factory = new Factory();
		factory.setCompany(company);
		factory.setName("Enterprise Server Factory 1 in Mexico");

		this.getFactoryDao().addFactory(factory);

		assertTrue(factory.getId() > this.getSeedDataSet().getTable("FACTORY").getRowCount());
	}

	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.daos.jdbc.FactoryJdbcDao#getAllFactories()}.
	 */
	@Test
	public void testGetAllFactories() throws Exception{
		List<Factory> factories = this.getFactoryDao().getAllFactories();

		for(Factory factory : factories){
			System.out.println("" + factory.getId() + ", " + factory.getName());
		}

		assertTrue(factories.size() == this.getSeedDataSet().getTable("FACTORY").getRowCount() + 1);
	}

	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.daos.jdbc.FactoryJdbcDao#getFactoriesOfCompany(java.lang.Long)}.
	 */
	@Test
	public void testGetFactoriesOfCompany() throws Exception{
		List<Factory> factories1 = this.getFactoryDao().getFactoriesOfCompany(3L);
		List<Factory> factories2 = this.getFactoryDao().getFactoriesOfCompany(1L);

		assertTrue(factories1.size() == 2);
		assertTrue(factories2.size() == 0);
	}

	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.daos.jdbc.FactoryJdbcDao#getFactory(java.lang.Long)}.
	 */
	@Test
	public void testGetFactory() throws Exception{
		Factory factory1 = this.getFactoryDao().getFactory(1L);
		Factory factory2 = this.getFactoryDao().getFactory(-1L);

		assertEquals(factory1.getName(), "Printer Factory at California");
		assertNull(factory2);
	}

	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.daos.jdbc.FactoryJdbcDao#getNumberOfAllFactories()}.
	 */
	@Test
	public void testGetNumberOfAllFactories() throws Exception{
		long num = this.getFactoryDao().getNumberOfAllFactories();

		assertTrue(num == this.getSeedDataSet().getTable("FACTORY").getRowCount() + 1);
	}

}
