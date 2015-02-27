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
import thirdstage.exercise.spring.transaction.case2.daos.BuildingDao;
import thirdstage.exercise.spring.transaction.case2.entities.Building;

/**
 * @author 3rdstage
 *
 */
public class BuildingIBatisDao implements BuildingDao{

	private SqlMapClient sqlMapClient;
	private SQLExceptionTranslator sqlExceptionTranslator;

	public BuildingIBatisDao(){
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
	
	/* (non-Javadoc)
	 * @see thirdstage.exercise.spring.transaction.case2.daos.BuildingDao#addBuilding(thirdstage.exercise.spring.transaction.case2.entities.Building)
	 */
	public void addBuilding(Building building) throws DataAccessException{

		try{
			Long id = (Long)this.getSqlMapClient().insert("addBuilding", building);
			building.setId(id);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Add a new Building", null, ex);
		}
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.spring.transaction.case2.daos.BuildingDao#getAllBuildings()
	 */
	public List<Building> getAllBuildings() throws DataAccessException{

		try{
			return this.getSqlMapClient().queryForList("getAllBuildings");
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get all buildings", null, ex);
		}
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.spring.transaction.case2.daos.BuildingDao#getBuilding(java.lang.Long)
	 */
	public Building getBuilding(Long id) throws DataAccessException{
		
		try{
			return (Building)(this.getSqlMapClient().queryForObject("getBuilding", id));
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get a Building", null, ex);
		}
		
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.spring.transaction.case2.daos.BuildingDao#getBuildingsOfCompany(java.lang.Long)
	 */
	public List<Building> getBuildingsOfCompany(Long companyId) throws DataAccessException{

		try{
			return this.getSqlMapClient().queryForList("getBuildingsOfCompany", companyId);
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get buildings of the given company", null, ex);
		}
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.spring.transaction.case2.daos.BuildingDao#getNumberOfAllBuildings()
	 */
	public long getNumberOfAllBuildings() throws DataAccessException{

		try{
			return (Long)this.getSqlMapClient().queryForObject("getNumberOfAllBuildings");
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Get number of all buildings", null, ex);
		}
	}

}
