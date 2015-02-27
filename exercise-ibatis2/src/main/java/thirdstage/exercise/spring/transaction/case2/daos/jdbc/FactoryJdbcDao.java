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
import thirdstage.exercise.spring.transaction.case2.daos.FactoryDao;
import thirdstage.exercise.spring.transaction.case2.entities.Company;
import thirdstage.exercise.spring.transaction.case2.entities.Factory;

/**
 * @author 3rdstage
 * 
 */
public class FactoryJdbcDao implements FactoryDao{

	private DataSource dataSource;
	private SQLExceptionTranslator sqlExceptionTranslator;

	public FactoryJdbcDao(){
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
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.FactoryDao#addFactory(thirdstage.exercise.spring.transaction.case2.Factory)
	 */
	public void addFactory(Factory factory){
		Connection conn = null;
		String sql = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			conn = this.getDataSource().getConnection();

			sql = "insert into factory (`name`, companyId) " + "values (?, ?)";
			stmt = conn.prepareStatement(sql, new String[] { "id" });
			stmt.setString(1, factory.getName());
			stmt.setLong(2, factory.getCompany().getId());
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if(rs.next()){
				factory.setId(rs.getLong(1));
			}

		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Add a new factory", sql, ex);
		}finally{
			if(stmt != null){
				try{
					stmt.close();
				}catch(Exception ex){}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(Exception ex){}
			}
		}
	}

	/*
	 * Gets all factories. The company of each factory will be known only up to it's id
	 * after this method call.
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.FactoryDao#getAllFactories()
	 */
	public List<Factory> getAllFactories(){
		Connection conn = null;
		String sql = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Factory> factories = new ArrayList<Factory>();
		Factory factory = null;
		Company company = null;

		try{
			conn = this.getDataSource().getConnection();

			sql = "select `id`, `name`, companyId from factory";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				factory = new Factory();
				factory.setId(rs.getLong("id"));
				factory.setName(rs.getString("name"));
				company = new Company();
				company.setId(rs.getLong("companyId"));
				factory.setCompany(company);
				factories.add(factory);
			}

			return factories;
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get all factories", sql, ex);
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(Exception ex){}
			}
			if(stmt != null){
				try{
					stmt.close();
				}catch(Exception ex){}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(Exception ex){}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.FactoryDao#getFactoriesOfCompany(java.lang.String)
	 */
	public List<Factory> getFactoriesOfCompany(Long companyId){
		Connection conn = null;
		String sql = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Factory> factories = new ArrayList<Factory>();
		Factory factory = null;
		Company company = null;

		try{
			conn = this.getDataSource().getConnection();

			sql = "select `id`, `name` from factory where companyId = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, companyId);
			rs = stmt.executeQuery();

			while(rs.next()){
				factory = new Factory();
				factory.setId(rs.getLong("id"));
				factory.setName(rs.getString("name"));
				company = new Company();
				company.setId(companyId);
				factory.setCompany(company);
				factories.add(factory);
			}

			return factories;
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get factories of specified company", sql, ex);
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(Exception ex){}
			}
			if(stmt != null){
				try{
					stmt.close();
				}catch(Exception ex){}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(Exception ex){}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.FactoryDao#getFactory(java.lang.String)
	 */
	public Factory getFactory(Long id){
		Connection conn = null;
		String sql = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Factory factory = null;
		Company company = null;

		try{
			conn = this.getDataSource().getConnection();

			sql = "select `name`, companyId from factory where `id` = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();

			if(rs.next()){
				factory = new Factory();
				factory.setId(id);
				factory.setName(rs.getString("name"));
				company = new Company();
				company.setId(rs.getLong("companyId"));
				factory.setCompany(company);
			}

			return factory;
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get a factory", sql, ex);
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(Exception ex){}
			}
			if(stmt != null){
				try{
					stmt.close();
				}catch(Exception ex){}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(Exception ex){}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.spring.transaction.case2.FactoryDao#getNumberOfAllFactories()
	 */
	public long getNumberOfAllFactories() throws DataAccessException{
		Connection conn = null;
		String sql = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			conn = this.getDataSource().getConnection();
			sql = "select count(`id`) from factory";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			rs.next();
			return rs.getLong(1);

		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get number of all factories", sql, ex);
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
