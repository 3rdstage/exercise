/**
 * 
 */
package thirdstage.petstore1.daos.ibatis.test;

import org.apache.log4j.Logger;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import thirdstage.petstore1.daos.AccountDao;
import thirdstage.petstore1.domain.entities.Account;

/**
 * @author 3rdstage
 * 
 */
public class AccountIBatisDaoJUnit4Test extends AbstractIBatisDaoJUnit4Test{
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(AccountIBatisDaoJUnit4Test.class);

	private AccountDao accountDao;

	public AccountIBatisDaoJUnit4Test(){
		super();
		System.out.println("tester created");
	}

	/**
	 * @throws java.lang.Exception
	 */

	@Before
	public void setUp() throws Exception{
		this.accountDao = (AccountDao)(this.getApplicationContext().getBean("accountDao"));
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.AccountIBatisDao#addAccount(thirdstage.petstore1.domain.entities.Account)}.
	 */
	@Test
	public void testAddAccount() throws Exception{
		if(logger.isDebugEnabled()){
			logger.debug("testAddAccount() - start");
		}

		Account account = new Account();
		account.setUsername("spring");
		account.setPassword("spring");
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

		this.accountDao.addAccount(account);

		// If there is no exception until here, it's okay.
		//assertTrue(true);

		assertTrue(accountDao.getAllUsernames().size() == 2);

		if(logger.isDebugEnabled()){
			logger.debug("testAddAccount() - end");
		}
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.AccountIBatisDao#getAccount(java.lang.String)}.
	 */
	@Test
	public void testGetAccountString() throws Exception{
		if(logger.isDebugEnabled()){
			logger.debug("testGetAccountString() - start");
		}

		Account account1 = this.accountDao.getAccount("spring");
		Account account2 = this.accountDao.getAccount("hibernate");

		assertEquals("Sang Moon", account1.getFirstName());
		assertEquals("Oh", account1.getLastName());
		assertNull(account2);

		if(logger.isDebugEnabled()){
			logger.debug("testGetAccountString() - end");
		}
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.AccountIBatisDao#getAccount(java.lang.String, java.lang.String)}.
	 */

	@Test
	public void testGetAccountStringString() throws Exception{
		if(logger.isDebugEnabled()){
			logger.debug("testGetAccountStringString() - start");
		}

		Account account1 = this.accountDao.getAccount("j2ee", "j2ee");
		Account account2 = this.accountDao.getAccount("j2ee", "j2e");

		assertEquals("ABC", account1.getFirstName());
		assertEquals("XYX", account1.getLastName());
		assertNull(account2);
		if(logger.isDebugEnabled()){
			logger.debug("testGetAccountStringString() - end");
		}
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.AccountIBatisDao#getAllUsernames()}.
	 */
	@Test
	public void testGetAllUsernames() throws Exception{
		if(logger.isDebugEnabled()){
			logger.debug("testGetAllUsernames() - start");
		}

		List<String> usernames = this.accountDao.getAllUsernames();
		for(String username : usernames){
			System.out.println(username);
		}

		assertTrue(usernames.size() == 2);
		assertTrue(usernames.contains("j2ee"));

		if(logger.isDebugEnabled()){
			logger.debug("testGetAllUsernames() - end");
		}
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.AccountIBatisDao#updateAccount(thirdstage.petstore1.domain.entities.Account)}.
	 */
	@Ignore("testing code is not written yet")
	@Test
	public void testUpdateAccount() throws Exception{
		fail("Not yet implemented");
	}

}
