package thirdstage.exercise.sql.tree.case1.daos.ibatis.test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thirdstage.exercise.sql.tree.case1.daos.ibatis.MenuIBatisDao;
import thirdstage.exercise.sql.tree.case1.entities.Menu;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MenuIBatisDaoTest{

	private static ApplicationContext springContext;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		springContext = new ClassPathXmlApplicationContext("thirdstage/exercise/sql/tree/case1/confs/spring-treesql.xml");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		springContext = null;

	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{}

	/**
	 * Test method for {@link thirdstage.exercise.sql.tree.case1.daos.ibatis.MenuIBatisDao#getAllMenusSorted()}.
	 */
	@Test
	public void testGetAllMenusSorted() throws Exception{
		try{
			MenuIBatisDao menuDao = new MenuIBatisDao();
			menuDao.setSqlMapClient((SqlMapClient)(springContext.getBean("sqlMapClient4MsSql")));

			List<Menu> menus = menuDao.getAllMenusSorted();

			System.out.println("");
			System.out.println("All menus :");
			for(Menu menu : menus){
				System.out.println("id : " + menu.getId() + ", level : " + menu.getLevel() + ", path : " + menu.getNamePath());
			}

			assertEquals("Admin", menus.get(0).getName());
			assertEquals("Admin/User/Add New User", menus.get(2).getNamePath());
			assertEquals("Organization", menus.get(menus.size() - 1).getName());
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}

	/**
	 * Test method for {@link thirdstage.exercise.sql.tree.case1.daos.ibatis.MenuIBatisDao#getSubmenusSorted(java.lang.String)}.
	 */
	@Test
	public void testGetSubmenusSorted() throws Exception{
		try{
			MenuIBatisDao menuDao = new MenuIBatisDao();
			menuDao.setSqlMapClient((SqlMapClient)(springContext.getBean("sqlMapClient4MsSql")));

			List<Menu> menus = menuDao.getSubmenusSorted("1");

			System.out.println("");
			System.out.println("Submenus of menu 1");
			for(Menu menu : menus){
				System.out.println("id : " + menu.getId() + ", level : " + menu.getLevel() + ", path : " + menu.getNamePath());
			}

			assertEquals("Admin", menus.get(0).getName());
			assertEquals("Admin/User/Add New User", menus.get(2).getNamePath());
			assertEquals(12, menus.size());
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}

}
