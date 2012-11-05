/**
 * 
 */
package thirdstage.petstore1.daos.ibatis.test;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import thirdstage.petstore1.daos.SequenceDao;

/**
 * @author 3rdstage
 *
 */
public class SequenceIBatisDaoJUnit4Test extends AbstractIBatisDaoJUnit4Test{

	private SequenceDao sequenceDao;



	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		sequenceDao = (SequenceDao)(this.getApplicationContext().getBean("sequenceDao"));
	}

	/**
	 * Test method for {@link thirdstage.petstore1.daos.ibatis.SequenceIBatisDao#getNextId(java.lang.String)}.
	 */
	@Test
	public void testGetNextId() throws SQLException{
		int orderId1 = this.sequenceDao.getNextId("ordernum");
		int orderId2 = this.sequenceDao.getNextId("ordernum");
		
		System.out.println("OrderId is : " + orderId1);
		System.out.println("OrderId is : " + orderId2);
		
		assertTrue(orderId2 - orderId1 == 1);
	}

}
