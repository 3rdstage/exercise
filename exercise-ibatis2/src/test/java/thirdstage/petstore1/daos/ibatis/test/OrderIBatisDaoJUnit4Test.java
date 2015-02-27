/**
 * 
 */
package thirdstage.petstore1.daos.ibatis.test;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import thirdstage.petstore1.daos.OrderDao;
import thirdstage.petstore1.domain.entities.Account;
import thirdstage.petstore1.domain.entities.Cart;
import thirdstage.petstore1.domain.entities.Item;
import thirdstage.petstore1.domain.entities.Order;

/**
 * @author 3rdstage
 * 
 */
public class OrderIBatisDaoJUnit4Test extends AbstractIBatisDaoJUnit4Test{

	private OrderDao orderDao;
	private OrderDao orderDaoWithDefect;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		orderDao = (OrderDao)(this.getApplicationContext().getBean("orderDao"));
		orderDaoWithDefect = (OrderDao)(this.getApplicationContext().getBean("orderDaoWithDefect"));
	}


	/**
	 * Test method for
	 * {@link thirdstage.petstore1.daos.ibatis.OrderIBatisDao#getOrder(int)}.
	 */
	@Ignore("Not yet implemented")
	@Test
	public void testGetOrder() throws SQLException{
		Order order = this.orderDao.getOrder(1);

	}

	/**
	 * Test method for
	 * {@link thirdstage.petstore1.daos.ibatis.OrderIBatisDao#getOrdersByUser(java.lang.String)}.
	 */
	@Ignore("Not yet implemented")
	@Test
	public void testGetOrdersByUser(){
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link thirdstage.petstore1.daos.ibatis.OrderIBatisDao#makeOrder(thirdstage.petstore1.domain.entities.Order)}.
	 */
	@Test
	public void testMakeOrder() throws SQLException{
		Account account = null;
		Cart cart = new Cart();
		Item item = null;

		account = (Account)(this.getSqlMapClient().queryForObject("getAccountByUsername", "j2ee"));
		item = (Item)(this.getSqlMapClient().queryForObject("getItem", "EST-3"));
		cart.addItem(item, item.getQuantity() > 0);

		item = (Item)(this.getSqlMapClient().queryForObject("getItem", "EST-5"));
		cart.addItem(item, item.getQuantity() > 0);
		cart.addItem(item, item.getQuantity() > 0);

		item = (Item)(this.getSqlMapClient().queryForObject("getItem", "EST-6"));
		cart.addItem(item, item.getQuantity() > 0);
		cart.addItem(item, item.getQuantity() > 0);
		cart.addItem(item, item.getQuantity() > 0);

		Order order = new Order();
		order.initOrder(account, cart);

		orderDao.makeOrder(order);
		
		Order order2 = orderDao.getOrder(order.getId());
		
		assertEquals(order.getUsername(), order2.getUsername());
		assertEquals(order.getTotalPrice(), order2.getTotalPrice());
	}

	
	@Test(expected = UnsupportedOperationException.class)
	public void testMakeOrderWithDefect() throws SQLException{
		Account account = null;
		Cart cart = new Cart();
		Item item = null;

		account = (Account)(this.getSqlMapClient().queryForObject("getAccountByUsername", "j2ee"));
		item = (Item)(this.getSqlMapClient().queryForObject("getItem", "EST-7"));
		cart.addItem(item, item.getQuantity() > 0);

		item = (Item)(this.getSqlMapClient().queryForObject("getItem", "EST-8"));
		cart.addItem(item, item.getQuantity() > 0);

		item = (Item)(this.getSqlMapClient().queryForObject("getItem", "EST-9"));
		cart.addItem(item, item.getQuantity() > 0);

		Order order = new Order();
		order.initOrder(account, cart);
		
		try{
			orderDaoWithDefect.makeOrder(order);
		}catch(UnsupportedOperationException ex){
			// expected Exception
			assertNull(orderDaoWithDefect.getOrder(order.getId()));
			throw ex;
		}
		
		// In normal cases, never reach here.
		assertFalse(true);
		
	}	
	
}
