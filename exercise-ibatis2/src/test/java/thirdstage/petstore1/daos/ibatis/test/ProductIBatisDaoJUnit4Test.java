/**
 * 
 */
package thirdstage.petstore1.daos.ibatis.test;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import thirdstage.petstore1.daos.ProductDao;
import thirdstage.petstore1.domain.entities.Product;

/**
 * @author 3rdstage
 *
 */
public class ProductIBatisDaoJUnit4Test extends AbstractIBatisDaoJUnit4Test{

	private ProductDao productDao;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		productDao = (ProductDao)(this.getApplicationContext().getBean("productDao"));
	}


	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.ProductIBatisDao#getProduct(java.lang.String)}.
	 */
	@Test
	public void testGetProduct() throws SQLException{
		
		Product product = this.productDao.getProduct("AV-CB-01");
		
		assertEquals(product.getName(), "Amazon Parrot");
		assertEquals(product.getCategoryId(), "BIRDS");
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.ProductIBatisDao#getProductsByCategory(java.lang.String)}.
	 */
	@Test
	public void testGetProductsByCategory() throws SQLException{
		List<Product> products = this.productDao.getProductsByCategory("FISH");
		List<String> productNames = new ArrayList<String>();
		
		for(Product product : products){
			System.out.println(product.toString());
			productNames.add(product.getName());
		}
		
		assertTrue(products.size() == 4);
		assertTrue(productNames.contains("Koi"));
		assertTrue(productNames.contains("Goldfish"));
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.ProductIBatisDao#searchProducts(java.lang.String)}.
	 */
	@Test
	public void testSearchProducts() throws SQLException{

		List<Product> products = this.productDao.searchProducts("cat fish");
		List<String> productNames = new ArrayList<String>();
		
		for(Product product : products){
			System.out.println(product.toString());
			productNames.add(product.getName());
		}

		assertTrue(products.size() == 6);
		assertTrue(productNames.contains("Angelfish"));
		assertTrue(productNames.contains("Persian"));
	}

}
