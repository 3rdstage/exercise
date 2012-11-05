/**
 * 
 */
package thirdstage.exercise.spring.transaction.case2.daos.test;

import static org.junit.Assert.*; 
import java.util.List;
import org.junit.Test;
import thirdstage.exercise.spring.transaction.case2.daos.BuildingDao;
import thirdstage.exercise.spring.transaction.case2.entities.Building;
import thirdstage.exercise.spring.transaction.case2.entities.Company;

/**
 * 
 * @author 3rdstage
 * 
 */
public abstract class BuildingDaoJUnit4Test{

	protected abstract BuildingDao getBuildingDao(); 

	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.daos.jdbc.BuildingJdbcDao#addBuilding(thirdstage.exercise.spring.transaction.case2.entities.Building)}.
	 */
	@Test
	public void testAddBuilding() throws Exception{
		Building building = new Building();
		Company company = new Company();
		company.setId(1L);
		building.setCompany(company);
		building.setName("2nd R&D Tower");
		
		this.getBuildingDao().addBuilding(building);
		
		assertTrue(building.getId() > 4L);
	}

	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.daos.jdbc.BuildingJdbcDao#getAllBuildings()}.
	 */
	@Test
	public void testGetAllBuildings() throws Exception{
		List<Building> buildings = this.getBuildingDao().getAllBuildings();
		
		for(Building building : buildings){
			System.out.println("" + building.getId() + ", " + building.getName());
		}
		
		assertTrue(buildings.size() == 5);
	}

	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.daos.jdbc.BuildingJdbcDao#getBuilding(java.lang.Long)}.
	 */
	@Test
	public void testGetBuilding() throws Exception{
		Building building1 = this.getBuildingDao().getBuilding(1L);
		Building building2 = this.getBuildingDao().getBuilding(2L);
		
		assertEquals("Main Tower", building1.getName());
		assertEquals("Main R&D Tower", building2.getName());
	}

	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.daos.jdbc.BuildingJdbcDao#getBuildingsOfCompany(java.lang.Long)}.
	 */
	@Test
	public void testGetBuildingsOfCompany(){
		List<Building> buildings = this.getBuildingDao().getBuildingsOfCompany(3L);
		
		assertTrue(buildings.size() == 1);
		assertEquals(buildings.get(0).getName(), "Palo Alto Research Center");
	}

	/**
	 * Test method for
	 * {@link thirdstage.exercise.spring.transaction.case2.daos.jdbc.BuildingJdbcDao#getNumberOfAllBuildings()}.
	 */
	@Test
	public void testGetNumberOfAllBuildings(){
		long num = this.getBuildingDao().getNumberOfAllBuildings();
		
		assertTrue(num == 5L);
	}

}
