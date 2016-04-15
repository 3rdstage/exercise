/**
 * 
 */
package thirdstage.petstore1.daos.ibatis.test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import thirdstage.petstore1.daos.ItemDao;
import thirdstage.petstore1.domain.entities.Item;

/**
 * @author 3rdstage
 *
 */
public class ItemIBatisDaoJUnit4Test extends AbstractIBatisDaoJUnit4Test{

	private ItemDao itemDao;


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		itemDao = (ItemDao)(this.getApplicationContext().getBean("itemDao"));
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.ItemIBatisDao#getItem(java.lang.String)}.
	 */
	@Test
	public void testGetItem() throws Exception{
		Item item = this.itemDao.getItem("EST-1");
		
		assertTrue(item.getListPrice() == 16.50);
		assertTrue(item.getUnitCost() == 10.00);
		assertTrue("FI-SW-01".equals(item.getProduct().getId()));
		assertTrue("Angelfish".equals(item.getProduct().getName()));
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.ItemIBatisDao#getItemsByProduct(java.lang.String)}.
	 */
	@Test
	public void testGetItemsByProduct() throws Exception{
		List<Item> items = this.itemDao.getItemsByProduct("K9-RT-02");
		
		for(Item item : items) System.out.println(item.toString());
		
		assertTrue(items.size() == 4);
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.ItemIBatisDao#isItemInStock(java.lang.String)}.
	 */
	@Test
	public void testIsItemInStock() throws Exception{
		
		assertTrue(this.itemDao.isItemInStock("EST-1"));
		assertTrue(this.itemDao.isItemInStock("EST-10"));
		assertFalse(this.itemDao.isItemInStock("ESS-1"));
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.ItemIBatisDao#updateQuantity(thirdstage.petstore1.domain.entities.Order)}.
	 */
	@Ignore("testing code is not written yet")
	@Test
	public void testUpdateQuantity() throws Exception{
		fail("Not yet implemented");
	}

}
