/**
 * 
 */
package thirdstage.exercise.spring.transaction.case2.daos.ibatis;

import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;
import com.ibatis.sqlmap.client.SqlMapClient;
import thirdstage.exercise.spring.transaction.case2.daos.FactoryDao;
import thirdstage.exercise.spring.transaction.case2.entities.Factory;

/**
 * @author 3rdstage
 * 
 */
public class FactoryIBatisDao implements FactoryDao{

	private SqlMapClient sqlMapClient;
	private SQLExceptionTranslator sqlExceptionTranslator;

	public FactoryIBatisDao(){
		this.sqlExceptionTranslator = new SQLStateSQLExceptionTranslator();

	}

	protected SqlMapClient getSqlMapClient(){
		return this.sqlMapClient;
	}

	@org.springframework.beans.factory.annotation.Required
	public void setSqlMapClient(SqlMapClient sqlMapClient){
		this.sqlMapClient = sqlMapClient;
	}

	protected SQLExceptionTranslator getSQLExceptionTranslator(){
		return this.sqlExceptionTranslator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.FactoryDao#addFactory(thirdstage.exercise.spring.transaction.case2.Factory)
	 */
	public void addFactory(Factory factory) throws DataAccessException{

		try{
			Long id = (Long)(this.getSqlMapClient().insert("addFactory", factory));
			factory.setId(id);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Add a new factory", null, ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.FactoryDao#getAllFactories()
	 */
	public List<Factory> getAllFactories() throws DataAccessException{
		
		try{
			return (List<Factory>)(this.getSqlMapClient().queryForList("getAllFactories"));
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get all factories", null, ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.FactoryDao#getFactoriesOfCompany(java.lang.String)
	 */
	public List<Factory> getFactoriesOfCompany(Long companyId) throws DataAccessException{

		try{
			return (List<Factory>)(this.getSqlMapClient().queryForList("getFactoriesOfCompany", companyId));
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get factories of the given company", null, ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.FactoryDao#getFactory(java.lang.String)
	 */
	public Factory getFactory(Long id) throws DataAccessException{

		try{
			return (Factory)(this.getSqlMapClient().queryForObject("getFactory", id));
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get a factory with the given id", null, ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.FactoryDao#getNumberOfAllFactories()
	 */
	public long getNumberOfAllFactories() throws DataAccessException{

		try{
			return (Long)(this.getSqlMapClient().queryForObject("getNumberOfAllFactories"));
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get the nubmer of all factories", null, ex);
		}
	}

}
