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
import thirdstage.exercise.spring.transaction.case2.daos.BuildingDao;
import thirdstage.exercise.spring.transaction.case2.entities.Building;
import thirdstage.exercise.spring.transaction.case2.entities.Company;

/**
 * This class assumes MySQL database underneath.
 * 
 * @author 3rdstage
 * 
 */
public class BuildingJdbcDao implements BuildingDao{

	private DataSource dataSource;
	private SQLExceptionTranslator sqlExceptionTranslator;

	public BuildingJdbcDao(){
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

	public void addBuilding(Building building) throws DataAccessException{
		Connection conn = null;
		String sql = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			conn = this.getDataSource().getConnection();

			sql = "insert into building (name, companyId) " + "values (?, ?)";
			stmt = conn.prepareStatement(sql, new String[] { "id" });
			stmt.setString(1, building.getName());
			stmt.setLong(2, building.getCompany().getId());
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if(rs.next()){
				building.setId(rs.getLong(1));
			}
			
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Add a new building", sql, ex);
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

	public List<Building> getAllBuildings(){
		Connection conn = null;
		String sql = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Building> buildings = new ArrayList<Building>();
		Building building = null;
		Company company = null;

		try{
			conn = this.getDataSource().getConnection();

			sql = "select id, name, companyId from building";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				building = new Building();
				building.setId(rs.getLong("id"));
				building.setName(rs.getString("name"));
				company = new Company();
				company.setId(rs.getLong("companyId"));
				building.setCompany(company);
				buildings.add(building);
			}

			return buildings;
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get all buildings", sql, ex);
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

	public Building getBuilding(Long id){
		Connection conn = null;
		String sql = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Building building = null;
		Company company = null;

		try{
			conn = this.getDataSource().getConnection();

			sql = "select `name`, `companyId` from building where `id` = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();

			if(rs.next()){
				building = new Building();
				building.setId(id);
				building.setName(rs.getString("name"));
				company = new Company();
				company.setId(rs.getLong("companyId"));
				building.setCompany(company);
			}

			return building;
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get a building", sql, ex);
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

	public List<Building> getBuildingsOfCompany(Long companyId){
		Connection conn = null;
		String sql = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Building> buildings = new ArrayList<Building>();
		Building building = null;
		Company company = null;

		try{
			conn = this.getDataSource().getConnection();

			sql = "select id, name from building where companyId = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, companyId);
			rs = stmt.executeQuery();

			while(rs.next()){
				building = new Building();
				building.setId(rs.getLong("id"));
				building.setName(rs.getString("name"));
				company = new Company();
				company.setId(companyId);
				building.setCompany(company);
				buildings.add(building);
			}

			return buildings;
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get buildings of specified company", sql, ex);
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
	 * @see thirdstage.exercise.spring.transaction.case2.BuildingDao#getNumberOfAllBuildings()
	 */
	public long getNumberOfAllBuildings() throws DataAccessException{
		Connection conn = null;
		String sql = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			conn = this.getDataSource().getConnection();
			sql = "select count(id) from building";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			rs.next();
			return rs.getLong(1);

		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get number of all buildings", sql, ex);
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
