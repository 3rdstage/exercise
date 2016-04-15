package thirdstage.petstore1.daos;

import java.sql.SQLException;
import java.util.List;

import thirdstage.petstore1.domain.entities.Account;

public interface AccountDao{

	Account getAccount(String username) throws SQLException;
	Account getAccount(String username, String password) throws SQLException;
	
	void addAccount(Account account) throws SQLException;
	
	void updateAccount(Account account) throws SQLException;
	
	List<String> getAllUsernames() throws SQLException;

	
}
