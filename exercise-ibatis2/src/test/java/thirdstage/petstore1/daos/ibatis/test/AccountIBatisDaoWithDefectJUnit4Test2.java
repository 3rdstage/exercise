/**
 * 
 */
package thirdstage.petstore1.daos.ibatis.test;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileReader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import thirdstage.petstore1.daos.ibatis.AccountIBatisDaoWithDefect;
import thirdstage.petstore1.domain.entities.Account;

/**
 * This class uses pure IBatis based DAO and don't use springframework
 * to test the transaction management of IBatis-based DAO
 * 
 * @author 3rdstage
 *
 */
public class AccountIBatisDaoWithDefectJUnit4Test2 extends AbstractIBatisDaoJUnit4Test{

	/**
	 * shadow the same-named variable in base class
	 */
	private static SqlMapClient sqlMapClient;

	private AccountIBatisDaoWithDefect accountDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		File config = (new ClassPathResource("thirdstage/petstore1/test/conf/sql-map-petstore-test-standalone.xml")).getFile();
		sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(new FileReader(config));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		this.accountDao = new AccountIBatisDaoWithDefect();
		this.accountDao.setSqlMapClient(sqlMapClient);
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.AccountIBatisDaoWithDefect#addAccount(thirdstage.petstore1.domain.entities.Account)}.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public final void testAddAccount() throws Exception{

		Account account = new Account();
		account.setUsername("hibernate");
		account.setPassword("hibernate");
		account.setFirstName("Sang Moon");
		account.setLastName("Oh");
		account.setEmail("halfface@chollian.net");
		account.setPhone("016-713-1690");
		account.setAddress1("Jung-gu");
		account.setAddress2("Prime Tower 7th Fl.");
		account.setCity("Seoul");
		account.setState("Seoul");
		account.setCountry("Korea");
		account.setZip("100-725");
		account.setLanguagePreference("ko");
		account.setFavoriteCategoryId("FISH");
		account.setListOption(true);
		account.setBannerOption(true);

		try{
			this.sqlMapClient.startTransaction();
			this.accountDao.addAccount(account);
			this.sqlMapClient.commitTransaction();
		}catch(UnsupportedOperationException ex){
			//as-is expected
			assertEquals(1, accountDao.getAllUsernames().size());
			throw ex;
		}finally{
			this.sqlMapClient.endTransaction();
		}

		//can't execute following line in expected case
		//because the above line would throw exception.
		assertFalse(true);
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.AccountIBatisDao#getAccount(java.lang.String)}.
	 */
	@Ignore("Not yet implemented")
	@Test
	public final void testGetAccountString(){
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.AccountIBatisDao#getAccount(java.lang.String, java.lang.String)}.
	 */
	@Ignore("Not yet implemented")
	@Test
	public final void testGetAccountStringString(){
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.AccountIBatisDao#getAllUsernames()}.
	 */
	@Ignore("Not yet implemented")
	@Test
	public final void testGetAllUsernames(){
		fail("Not yet implemented"); // TODO
	}

}
