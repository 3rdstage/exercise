package thirdstage.exercise.mockito.case1;

import static org.mockito.Mockito.*;
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
		
		mock = mock(Connection.class);
		when(mock.getCatalog()).thenReturn("shop");
		
		
		Assert.assertEquals("shop", mock.getCatalog());
		
		logger.debug("The hash code of create mock object is {}", mock.hashCode());
		logger.debug("The catalog is {}", mock.getCatalog());
	}
	
	/**
	 * Exception is expected.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMockingConnection2() throws Exception{
		mock = mock(Connection.class, RETURNS_DEEP_STUBS);
		when(mock.getClientInfo().getProperty("os")).thenReturn("Windoows 7");
		
		logger.debug("The hash code of create mock object is {}", mock.hashCode());
		logger.debug("The client's OS is {}", mock.getClientInfo().getProperty("os"));
	}	
	
}
