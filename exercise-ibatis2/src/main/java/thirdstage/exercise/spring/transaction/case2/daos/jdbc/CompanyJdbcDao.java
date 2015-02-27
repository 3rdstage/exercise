/**
 * 
 */
package thirdstage.exercise.spring.transaction.case2.daos.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;
import thirdstage.exercise.spring.transaction.case2.daos.CompanyDao;
import thirdstage.exercise.spring.transaction.case2.entities.Company;

/**
 * This class assumes MySQL database using InnoDB engine underneath.
 * 
 * @author 3rdstage
 * 
 */
public class CompanyJdbcDao implements CompanyDao{

	private DataSource dataSource;
	private SQLExceptionTranslator sqlExceptionTranslator;

	public CompanyJdbcDao(){
		this.sqlExceptionTranslator = new SQLStateSQLExceptionTranslator();
	}

	protected DataSource getDataSource(){
		return this.dataSource;
	}

	@org.springframework.beans.factory.annotation.Required
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}

	protected SQLExceptionTranslator getSQLExceptionTranslator(){
		return this.sqlExceptionTranslator;
	}

	/*
	 * This method assumes that the table for company has id column of
	 * auto_increment type. Refer to the manual of MySQL 5.0 about the
	 * auto_increment and transaction.
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.CompanyDao#addCompany(thirdstage.exercise.spring.transaction.case2.Company)
	 * @see <a
	 *      href="http://dev.mysql.com/doc/refman/5.0/en/innodb-auto-increment-handling.html">How
	 *      AUTO_INCREMENT Handling Works in InnoDB</a>
	 */
	public void addCompany(Company company){
		Connection conn = null;
		String sql = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			conn = this.getDataSource().getConnection();
			sql = "insert into company (name) " + "values (?)";
			stmt = conn.prepareStatement(sql, new String[] { "id" });
			stmt.setString(1, company.getName());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();

			if(rs.next()){
				company.setId(rs.getLong(1));
			}

		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Add a new company", sql, ex);
		}finally{
			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException ex){}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException ex){}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.CompanyDao#getAllCompanies()
	 */
	public List<Company> getAllCompanies(){
		Connection conn = null;
		String sql = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Company> companies = new ArrayList<Company>();
		Company company = null;

		try{
			conn = this.getDataSource().getConnection();
			sql = "select id, name from company";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				company = new Company();
				company.setId(rs.getLong("id"));
				company.setName(rs.getString("name"));
				companies.add(company);
			}

			return companies;
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get all companies", sql, ex);
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException ex){}
			}
			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException ex){}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException ex){}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.CompanyDao#getCompany(java.lang.String)
	 */
	public Company getCompany(Long id){
		Connection conn = null;
		String sql = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Company company = null;

		try{
			conn = this.getDataSource().getConnection();
			sql = "select name from company where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();

			if(rs.next()){
				company = new Company();
				company.setId(id);
				company.setName(rs.getString("name"));
			}

			return company;
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get all companies", sql, ex);
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException ex){}
			}
			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException ex){}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException ex){}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.CompanyDao#getNumberOfAllCompanies()
	 */
	public long getNumberOfAllCompanies() throws DataAccessException{
		Connection conn = null;
		String sql = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			conn = this.getDataSource().getConnection();
			sql = "select count(id) from company";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			rs.next();
			return rs.getLong(1);

		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get number of all companies", sql, ex);
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException ex){}
			}
			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException ex){}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException ex){}
			}
		}
	}

}
