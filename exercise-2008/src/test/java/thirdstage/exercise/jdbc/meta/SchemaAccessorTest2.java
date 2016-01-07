/**
 * 
 */
package thirdstage.exercise.jdbc.meta;


import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 3rdstage
 *
 */
public class SchemaAccessorTest2 {
	
	private static ApplicationContext springCtx;
	
	private DataSource ds;
	
	private SchemaAccessor accessor;
	
	private String schemaPattern;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		springCtx = new ClassPathXmlApplicationContext("thirdstage/exercise/jdbc/meta/confs/spring.xml");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.accessor = new SchemaAccessor();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testGetColumnsBySchemaWithDetailedOracleDataSource() throws Exception{
		
		this.ds = (DataSource)springCtx.getBean("detailedOracleDataSource");
		this.schemaPattern = "HR";
		
		List<SchemaAccessor.Column> cols = this.accessor.getColumnsBySchemaPattern(ds, schemaPattern);

		System.out.println("GetColumnsBySchemaWithDetailedOracleDataSource");
		for(SchemaAccessor.Column col : cols){
			System.out.println(col.toString());
		}
		System.out.println("");
	
		Assert.assertTrue(true);
	}
	
	@Test
	public void testGetColumnsBySchemaStepByStepWithDetailedOracleDataSource() throws Exception{
		
		this.ds = (DataSource)springCtx.getBean("detailedOracleDataSource");
		this.schemaPattern = "HR";
		
		List<SchemaAccessor.Column> cols = this.accessor.getColumnsBySchemaPatternStepByStep(ds, schemaPattern);

		System.out.println("GetColumnsBySchemaStepByStepWithDetailedOracleDataSource");
		for(SchemaAccessor.Column col : cols){
			System.out.println(col.toString());
		}
		System.out.println("");
	
		Assert.assertTrue(true);
	}	
	
}
