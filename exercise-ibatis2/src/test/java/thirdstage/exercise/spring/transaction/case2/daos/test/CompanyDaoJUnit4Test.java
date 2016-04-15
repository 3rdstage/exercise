/**
 * 
 */
package thirdstage.exercise.spring.transaction.case2.daos.test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import thirdstage.exercise.spring.transaction.case2.daos.CompanyDao;
import thirdstage.exercise.spring.transaction.case2.entities.Company;

/**
 * This class initiates(deletes all rows and inserts the prepared data) the
 * underlying tables(company, building, factory) in database using DbUnit
 * framework.
 * 
 * @author 3rdstage
 * 
 */
public abstract class CompanyDaoJUnit4Test{


	protected abstract CompanyDao getCompanyDao();

	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.daos.jdbc.CompanyJdbcDao#addCompany(thirdstage.exercise.spring.transaction.case2.entities.Company)}.
	 */
	@Test
	public void testAddCompany() throws Exception{
		Company company = new Company();
		company.setName("IBM");
		this.getCompanyDao().addCompany(company);

		assertTrue(company.getId() > 3);
	}

	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.daos.jdbc.CompanyJdbcDao#getAllCompanies()}.
	 */
	@Test
	public void testGetAllCompanies() throws Exception{
		List<Company> companies = null;
		companies = this.getCompanyDao().getAllCompanies();

		for(Company company : companies){
			System.out.println("" + company.getId() + ", " + company.getName());
		}

		assertTrue(companies.size() == 4);
	}

	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.daos.jdbc.CompanyJdbcDao#getCompany(java.lang.Long)}.
	 */
	@Test
	public void testGetCompany() throws Exception{
		Company company1 = this.getCompanyDao().getCompany(1L);
		Company company2 = this.getCompanyDao().getCompany(2L);

		assertEquals(company1.getName(), "Google");
		assertEquals(company2.getName(), "Sun Microsystems");
	}

	@Test
	public void testGetNumberOfAllCompanies(){
		long num = this.getCompanyDao().getNumberOfAllCompanies();

		assertEquals(num, 4);
	}

}
