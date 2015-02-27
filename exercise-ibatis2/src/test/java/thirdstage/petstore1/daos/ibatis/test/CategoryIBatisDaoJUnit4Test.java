/**
 * 
 */
package thirdstage.petstore1.daos.ibatis.test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import thirdstage.petstore1.daos.CategoryDao;
import thirdstage.petstore1.domain.entities.Category;

/**
 * @author 3rdstage
 *
 */
public class CategoryIBatisDaoJUnit4Test extends AbstractIBatisDaoJUnit4Test{

	private CategoryDao categoryDao;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		categoryDao = (CategoryDao)(this.getApplicationContext().getBean("categoryDao"));
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.CategoryIBatisDao#getAllCategories()}.
	 */
	@Test
	public void testGetAllCategories() throws Exception{
		List<Category> categories = categoryDao.getAllCategories();
		
		for(Category cat : categories){
			System.out.println(cat.toString());
		}
		
		assertEquals(categories.size(), 5);
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.CategoryIBatisDao#getCategory(java.lang.String)}.
	 */
	@Test
	public void testGetCategory() throws Exception{
		Category category = categoryDao.getCategory("BIRDS");
		assertEquals(category.getName(), "Birds");
	}

}
