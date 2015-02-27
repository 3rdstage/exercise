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
import thirdstage.exercise.spring.transaction.case2.daos.CompanyDao;
import thirdstage.exercise.spring.transaction.case2.entities.Company;

/**
 * @author 3rdstage
 * 
 */
public class CompanyIBatisDao implements CompanyDao{

	private SqlMapClient sqlMapClient;
	private SQLExceptionTranslator sqlExceptionTranslator;

	public CompanyIBatisDao(){
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
	 * @see thirdstage.exercise.spring.transaction.case2.daos.CompanyDao#addCompany(thirdstage.exercise.spring.transaction.case2.entities.Company)
	 */
	public void addCompany(Company company) throws DataAccessException{
		try{
			Long id = (Long)this.getSqlMapClient().insert("addCompany", company);
			
			System.out.println("Generated id is : " + id);
			
			company.setId(id);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Add a new company", null, ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.daos.CompanyDao#getAllCompanies()
	 */
	public List<Company> getAllCompanies() throws DataAccessException{
		try{
			return (List<Company>)(this.getSqlMapClient().queryForList("getAllCompanies"));
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get all companies", null, ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.daos.CompanyDao#getCompany(java.lang.Long)
	 */
	public Company getCompany(Long id) throws DataAccessException{
		try{
			return (Company)(this.getSqlMapClient().queryForObject("getCompany", id));
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get a company", null, ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.daos.CompanyDao#getNumberOfAllCompanies()
	 */
	public long getNumberOfAllCompanies() throws DataAccessException{
		try{
			return (Long)(this.getSqlMapClient().queryForObject("getNumberOfAllCompanies"));
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get number of all companies", null, ex);
		}
	}
}
