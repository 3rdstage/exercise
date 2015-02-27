package thirdstage.exercise.spring.transaction.case2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.dbunit.dataset.IDataSet;
import org.junit.Test;
import thirdstage.exercise.spring.transaction.case2.CompanyService;
import thirdstage.exercise.spring.transaction.case2.entities.Building;
import thirdstage.exercise.spring.transaction.case2.entities.Company;
import thirdstage.exercise.spring.transaction.case2.entities.Factory;


public abstract class CompanyServiceJUnit4Test{

	protected abstract CompanyService getCompanyService();

	protected abstract IDataSet getSeedDataSet();
	
	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.CompanyJdbcService#getCompany(java.lang.Long)}.
	 */
	@Test
	public void testGetCompany(){
		Company company = this.getCompanyService().getCompany(3L);

		if(true){
			System.out.println("Company : " + company.getId() + ", " + company.getName());
			for(Building building : company.getBuildings()){
				System.out.println("Building : " + building.getId() + ", " + building.getName());
			}
			for(Factory factory : company.getFactories()){
				System.out.println("Building : " + factory.getId() + ", " + factory.getName());
			}
		}

		assertEquals(company.getName(), "XEROX");
		assertTrue(company.getBuildings().size() == 1);
		assertEquals("Palo Alto Research Center", company.getBuildings().get(0).getName());
		assertTrue(company.getFactories().size() == 2);
	}

	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.CompanyJdbcService#addCompany(thirdstage.exercise.spring.transaction.case2.entities.Company)}.
	 */
	@Test
	public void testAddCompany() throws Exception{
		Company company = new Company();
		company.setName("LG전자");

		Building building = new Building();
		building.setName("여의도 본사");
		company.addBuilding(building);
		building = new Building();
		building.setName("강서 빌딩");
		company.addBuilding(building);
		building = new Building();
		building.setName("강남 빌딩");
		company.addBuilding(building);
		
		Factory factory = new Factory();
		factory.setName("평택 공장");
		company.addFactory(factory);
		factory = new Factory();
		factory.setName("오산 공장");
		company.addFactory(factory);
		factory = new Factory();
		factory.setName("창원 공장");
		company.addFactory(factory);

		this.getCompanyService().addCompany(company);

		if(true){
			System.out.println("Company : " + company.getId() + ", " + company.getName());
			for(Building building2 : company.getBuildings()){
				System.out.println("Building : " + building2.getId() + ", " + building2.getName());
			}
			for(Factory factory2 : company.getFactories()){
				System.out.println("Building : " + factory2.getId() + ", " + factory2.getName());
			}
		}

		assertTrue(company.getId() > this.getSeedDataSet().getTable("COMPANY").getRowCount());
		assertTrue(company.getBuildings().get(0).getId() > this.getSeedDataSet().getTable("BUILDING").getRowCount());
		assertTrue(company.getFactories().get(0).getId() > this.getSeedDataSet().getTable("FACTORY").getRowCount());
	}
	
}
