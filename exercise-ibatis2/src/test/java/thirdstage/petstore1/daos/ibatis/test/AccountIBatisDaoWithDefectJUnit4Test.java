package thirdstage.petstore1.daos.ibatis.test;

import org.apache.log4j.Logger;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import thirdstage.petstore1.daos.AccountDao;
import thirdstage.petstore1.domain.entities.Account;

public class AccountIBatisDaoWithDefectJUnit4Test extends AbstractIBatisDaoJUnit4Test{
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(AccountIBatisDaoWithDefectJUnit4Test.class);

	private AccountDao accountDao;

	/**
	 * @throws java.lang.Exception
	 */

	@Before
	public void setUp() throws Exception{
		this.accountDao = (AccountDao)(this.getApplicationContext().getBean("accountDaoWithDefect"));
	}

	/**
	 * FIXME Transaction management of SqlMapClient in spring framework. 
	 * Transaction is not roll-backed correctly on underlying dao.
	 * Should check more.
	 * 
	 * @throws Exception
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testAddAccount() throws Exception{
		if(logger.isDebugEnabled()){
			logger.debug("testAddAccount() - start");
		}

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
			this.accountDao.addAccount(account);
		}catch(UnsupportedOperationException ex){
			assertEquals(1, accountDao.getAllUsernames().size());
			throw ex;
		}

		//can't execute following line in expected case
		//because the above line would throw exception.
		assertTrue(false);

		if(logger.isDebugEnabled()){
			logger.debug("testAddAccount() - end");
		}
	}

	@Test
	public void testGetAccountString() throws Exception{
		if(logger.isDebugEnabled()){
			logger.debug("testGetAccountString() - start");
		}

		Account account1 = this.accountDao.getAccount("j2ee");
		Account account2 = this.accountDao.getAccount("spring");

		assertEquals("ABC", account1.getFirstName());
		assertEquals("XYX", account1.getLastName());
		assertNull(account2);

		if(logger.isDebugEnabled()){
			logger.debug("testGetAccountString() - end");
		}
	}

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

	@Test
	public void testGetAllUsernames() throws Exception{
		if(logger.isDebugEnabled()){
			logger.debug("testGetAllUsernames() - start");
		}

		List<String> usernames = this.accountDao.getAllUsernames();
		for(String username : usernames){
			System.out.println(username);
		}

		assertTrue(usernames.contains("j2ee"));

		if(logger.isDebugEnabled()){
			logger.debug("testGetAllUsernames() - end");
		}
	}

}
