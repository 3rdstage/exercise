package thirdstage.petstore1.daos.ibatis;

import java.sql.SQLException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import thirdstage.petstore1.domain.entities.Account;

/**
 * This class has intentional defect in some methods
 * to check the correct working of transaction management.
 *  
 * @author 3rdstage
 *
 */
public final class AccountIBatisDaoWithDefect extends AccountIBatisDao{
	
	public AccountIBatisDaoWithDefect(){
		
	}

	/**
	 * This method throws run-time exception after inserting
	 * account and profile table but before signon table.
	 * This method is for check the correct working of rollback.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, 
			rollbackFor = {java.sql.SQLException.class})
	public void addAccount(Account account) throws SQLException{

		this.getSqlMapClient().insert("insertAccount", account);
		this.getSqlMapClient().insert("insertProfile", account);

		if(true){ throw new UnsupportedOperationException(); }
		
		this.getSqlMapClient().insert("insertSignon", account);
	}
}
