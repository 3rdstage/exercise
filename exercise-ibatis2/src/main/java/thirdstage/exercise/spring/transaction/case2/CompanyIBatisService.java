package thirdstage.exercise.spring.transaction.case2;

import java.util.List;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import thirdstage.exercise.spring.transaction.case2.daos.BuildingDao;
import thirdstage.exercise.spring.transaction.case2.daos.CompanyDao;
import thirdstage.exercise.spring.transaction.case2.daos.FactoryDao;
import thirdstage.exercise.spring.transaction.case2.entities.Building;
import thirdstage.exercise.spring.transaction.case2.entities.Company;
import thirdstage.exercise.spring.transaction.case2.entities.Factory;

public class CompanyIBatisService implements CompanyService{

	private CompanyDao companyDao;
	private BuildingDao buildingDao;
	private FactoryDao factoryDao;

	public CompanyIBatisService(){

	}

	public CompanyDao getCompanyDao(){
		return companyDao;
	}

	@Required
	public void setCompanyDao(CompanyDao companyDao){
		this.companyDao = companyDao;
	}
	
	public BuildingDao getBuildingDao(){
		return buildingDao;
	}

	@Required
	public void setBuildingDao(BuildingDao buildingDao){
		this.buildingDao = buildingDao;
	}

	public FactoryDao getFactoryDao(){
		return factoryDao;
	}

	@Required
	public void setFactoryDao(FactoryDao factoryDao){
		this.factoryDao = factoryDao;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void addCompany(Company company) throws DataAccessException{
		List<Building> buildings = company.getBuildings();
		List<Factory> factories = company.getFactories();
		
		companyDao.addCompany(company);
		for(Building building : buildings){
			buildingDao.addBuilding(building);
		}
		
		for(Factory factory : factories){
			factoryDao.addFactory(factory);
		}
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Company getCompany(Long id) throws DataAccessException{
		
		Company company = companyDao.getCompany(id);
		List<Building> buildings = buildingDao.getBuildingsOfCompany(id);
		List<Factory> factories = factoryDao.getFactoriesOfCompany(id);
		
		for(Building building : buildings){
			company.addBuilding(building);
		}
		
		for(Factory factory : factories){
			company.addFactory(factory);
		}
		
		return company;
	}

}
