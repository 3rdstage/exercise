package thirdstage.exercise.easymock.case1;

import static org.easymock.EasyMock.*;
import java.sql.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MockingJdbcTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private Connection mock;

	@Test
	public void testMockingConnection1() throws Exception{
		
		mock = createNiceMock(Connection.class);
		expect(mock.getCatalog()).andReturn("shop");
		replay(mock);
		
		Assert.assertEquals("shop", mock.getCatalog());
		
		logger.debug("The hash code of create mock object is {}", mock.hashCode());
		logger.debug("The catalog is {}", mock.getCatalog());
	}
	
	/**
	 * Exception is expected.
	 * 
	 * @throws Exception
	 */
	@Test(expectedExceptions={java.lang.Exception.class})
	public void testMockingConnection2() throws Exception{
		mock = createNiceMock(Connection.class);
		expect(mock.getClientInfo().getProperty("os")).andReturn("Windoows 7");
		replay(mock);
		
		logger.debug("The hash code of create mock object is {}", mock.hashCode());
		logger.debug("The client's OS is {}", mock.getClientInfo().getProperty("os"));
	}	
	
}
