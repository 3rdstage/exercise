package thirdstage.exercise.spring.transaction.case2.daos;

import java.util.List;
import org.springframework.dao.DataAccessException;
import thirdstage.exercise.spring.transaction.case2.entities.Building;

public interface BuildingDao{
	
	List<Building> getAllBuildings() throws DataAccessException;
	List<Building> getBuildingsOfCompany(Long companyId) throws DataAccessException;
	Building getBuilding(Long id) throws DataAccessException;
	long getNumberOfAllBuildings() throws DataAccessException;
	
	void addBuilding(Building building) throws DataAccessException;

}
