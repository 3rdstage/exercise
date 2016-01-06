/**
 * 
 */
package thirdstage.exercise.tree.adjacancy.test;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thirdstage.exercise.tree.adjacancy.CategoryDao;
import thirdstage.exercise.tree.adjacancy.CategoryIBatisDao;
import thirdstage.exercise.tree.adjacancy.entities.Category;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author 3rdstage
 * 
 */
public class CategoryIBatisDaoWithOracleTest{

	protected static ApplicationContext springContext;
	protected static SqlMapClient sqlMapClient; // SqlMapClient is thread-safe
	protected CategoryDao categoryDao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		springContext = new ClassPathXmlApplicationContext("thirdstage/exercise/tree/adjacancy/confs/spring-config-oracle.xml");
		sqlMapClient = (SqlMapClient)springContext.getBean("defaultSqlMapClient");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		springContext = null;
		sqlMapClient = null;

	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		this.categoryDao = (CategoryDao)springContext.getBean("categoryDao");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{}

	@Test
	public void testGetAll() throws Exception{
		try{
			List<Category> categories = this.categoryDao.getAll();
			
			System.out.println(">> Listing all categories :");
			for(Category cat : categories) System.out.println(cat.toString());
			System.out.println("");
			assertEquals(1, 1);
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}
	
	@Test
	public void testGetSubordinates() throws Exception{
		try{
			List<Category> categories = this.categoryDao.getSubordinates("1000001");
			
			System.out.println(">> Listing subordinates of category 1000001 :");
			for(Category cat : categories) System.out.println(cat.toString());
			System.out.println("");
			assertEquals(1, 1);
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}

	@Test
	public void testGetSuperiors() throws Exception{
		try{
			List<Category> categories = this.categoryDao.getSuperiors("1000132");
			
			System.out.println(">> Listing superiors of category 1000132 :");
			for(Category cat : categories) System.out.println(cat.toString());
			System.out.println("");
			assertEquals(1, 1);
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}	

	@Test
	public void testGetSiblings() throws Exception{
		try{
			List<Category> categories = this.categoryDao.getSiblings("1000132");
			
			System.out.println(">> Listing siblings of category 1000132 :");
			for(Category cat : categories) System.out.println(cat.toString());
			System.out.println("");
			assertEquals(1, 1);
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}	

}
