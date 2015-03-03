/**
 * 
 */
package thirdstage.petstore1.daos.ibatis;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ibatis.sqlmap.client.SqlMapClient;
import thirdstage.petstore1.daos.AccountDao;
import thirdstage.petstore1.domain.entities.Account;

/**
 * @author 3rdstage
 * 
 */
@ManagedResource(objectName="beans:name=accountIBatisDao")
public class AccountIBatisDao implements AccountDao{
	private SqlMapClient sqlMapClient;

	public AccountIBatisDao(){
		super();
	}

	@ManagedAttribute(description="SqlMapClient of this DAO")
	public SqlMapClient getSqlMapClient(){
		return this.sqlMapClient;
	}

	@org.springframework.beans.factory.annotation.Required
	public void setSqlMapClient(SqlMapClient sqlMapClient){
		this.sqlMapClient = sqlMapClient;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.daos.AccountDao#addAccount(thirdstage.petstore1.domain.entities.Account)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, 
			rollbackFor = {java.sql.SQLException.class})
	public void addAccount(Account account) throws SQLException{
		this.getSqlMapClient().insert("insertAccount", account);
		this.getSqlMapClient().insert("insertProfile", account);
		this.getSqlMapClient().insert("insertSignon", account);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.daos.AccountDao#getAccount(java.lang.String)
	 */
	public Account getAccount(String username) throws SQLException{
		return (Account)(this.getSqlMapClient().queryForObject("getAccountByUsername", username));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.daos.AccountDao#getAccount(java.lang.String,
	 *      java.lang.String)
	 */
	public Account getAccount(String username, String password) throws SQLException{
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		return (Account)(this.getSqlMapClient().queryForObject("getAccountByUsernameAndPassword", account));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.daos.AccountDao#getAllUsernames()
	 */
	public List<String> getAllUsernames() throws SQLException{
		return this.getSqlMapClient().queryForList("getAllUsernames", null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.petstore1.daos.AccountDao#update(thirdstage.petstore1.domain.entities.Account)
	 */
	public void updateAccount(Account account) throws SQLException{
		this.getSqlMapClient().update("updateAccont", account);
		this.getSqlMapClient().update("updateProfile", account);
		if(account.getPassword() != null && account.getPassword().length() > 0){
			getSqlMapClient().update("updateSignon", account);
		}
	}

}
