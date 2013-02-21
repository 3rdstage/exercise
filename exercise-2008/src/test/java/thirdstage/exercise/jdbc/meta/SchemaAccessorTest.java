/**
 * 
 */
package thirdstage.exercise.jdbc.meta;


import java.util.ArrayList;
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
public class SchemaAccessorTest {
	
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
	public void testGetTalbesAndViewsBySchemaPatternWithNormalOracleDataSource() throws Exception{
		
		this.ds = (DataSource)springCtx.getBean("normalOracleDataSource");
		this.schemaPattern = "HR";
		
		List<SchemaAccessor.Table> tables = this.accessor.getTalbesAndViewsBySchemaPattern(ds, schemaPattern);
		
		System.out.println("GetTalbesAndViewsBySchemaPatternWithNormalOracleDataSource");
		for(SchemaAccessor.Table table : tables){
			System.out.println(table.toString());
		}
		System.out.println("");
	
		Assert.assertTrue(true);
	}

	@Test
	public void testGetPublicTalbesAndViewsBySchemaPatternWithNormalOracleDataSource() throws Exception{
		
		this.ds = (DataSource)springCtx.getBean("normalOracleDataSource");
		this.schemaPattern = "PUBLIC";
		
		List<SchemaAccessor.Table> tables = this.accessor.getTalbesAndViewsBySchemaPattern(ds, schemaPattern);
		
		System.out.println("GetPublicTalbesAndViewsBySchemaPatternWithNormalOracleDataSource");
		for(SchemaAccessor.Table table : tables){
			System.out.println(table.toString());
		}
		System.out.println("");
	
		Assert.assertTrue(true);
	}	
	
	@Test
	public void testGetTablesViewsAliasesAndSynonymsBySchemaPatternWithNormalOracleDataSource() throws Exception{
		
		this.ds = (DataSource)springCtx.getBean("normalOracleDataSource");
		this.schemaPattern = "HR";
		
		List<SchemaAccessor.Table> tables = this.accessor.getTablesViewsAliasesAndSynonymsBySchemaPattern(ds, schemaPattern);
		
		System.out.println("GetTablesViewsAliasesAndSynonymsBySchemaPatternWithNormalOracleDataSource");
		for(SchemaAccessor.Table table : tables){
			System.out.println(table.toString());
		}
		System.out.println("");
	
		Assert.assertTrue(true);
	}

	@Test
	public void testGetPublicTablesViewsAliasesAndSynonymsBySchemaPatternWithNormalOracleDataSource() throws Exception{
		
		this.ds = (DataSource)springCtx.getBean("normalOracleDataSource");
		this.schemaPattern = "PUBLIC";
		
		List<SchemaAccessor.Table> tables = this.accessor.getTablesViewsAliasesAndSynonymsBySchemaPattern(ds, schemaPattern);
		
		System.out.println("GetPublicTablesViewsAliasesAndSynonymsBySchemaPatternWithNormalOracleDataSource");
		for(SchemaAccessor.Table table : tables){
			System.out.println(table.toString());
		}
		System.out.println("");
	
		Assert.assertTrue(true);
	}
	
	@Test
	public void testGetPublicTablesViewsAndAliasesBySchemaPatternWithNormalOracleDataSource() throws Exception{
		
		this.ds = (DataSource)springCtx.getBean("normalOracleDataSource");
		this.schemaPattern = "PUBLIC";
		
		List<SchemaAccessor.Table> tables = this.accessor.getTablesViewsAndAliasesBySchemaPattern(ds, schemaPattern);
		
		System.out.println("GetPublicTablesViewsAndAliasesBySchemaPatternWithNormalOracleDataSource");
		for(SchemaAccessor.Table table : tables){
			System.out.println(table.toString());
		}
		System.out.println("");
	
		Assert.assertTrue(true);
	}	

	@Test
	public void testGetPublicTablesViewsAndSynonymsBySchemaPatternWithNormalOracleDataSource() throws Exception{
		
		this.ds = (DataSource)springCtx.getBean("normalOracleDataSource");
		this.schemaPattern = "PUBLIC";
		
		List<SchemaAccessor.Table> tables = this.accessor.getTablesViewsAndSynonymsBySchemaPattern(ds, schemaPattern);
		
		System.out.println("GetPublicTablesViewsAndSynonymsBySchemaPatternWithNormalOracleDataSource");
		for(SchemaAccessor.Table table : tables){
			System.out.println(table.toString());
		}
		System.out.println("");
	
		Assert.assertTrue(true);
	}	
	
	
	@Test
	public void testGetTalbesAndViewsBySchemaPatternWithDetailedOracleDataSource() throws Exception{
		
		this.ds = (DataSource)springCtx.getBean("detailedOracleDataSource");
		this.schemaPattern = "HR";
		
		List<SchemaAccessor.Table> tables = this.accessor.getTalbesAndViewsBySchemaPattern(ds, schemaPattern);
		
		System.out.println("GetTalbesAndViewsBySchemaPatternWithDetailedOracleDataSource");
		for(SchemaAccessor.Table table : tables){
			System.out.println(table.toString());
		}
		System.out.println("");
	
		Assert.assertTrue(true);
	}
	
	
	@Test
	public void testGetTablesViewsAliasesAndSynonymsBySchemaPatternWithDetailedOracleDataSource() throws Exception{
		
		this.ds = (DataSource)springCtx.getBean("detailedOracleDataSource");
		this.schemaPattern = "HR";
		
		List<SchemaAccessor.Table> tables = this.accessor.getTablesViewsAliasesAndSynonymsBySchemaPattern(ds, schemaPattern);
		
		System.out.println("GetTablesViewsAliasesAndSynonymsBySchemaPatternWithDetailedOracleDataSource");
		for(SchemaAccessor.Table table : tables){
			System.out.println(table.toString());
		}
		System.out.println("");
	
		Assert.assertTrue(true);
	}
	
	@Test
	public void testGetColumnsBySchemaPatternWithNormalOracleDataSource() throws Exception{
		
		this.ds = (DataSource)springCtx.getBean("normalOracleDataSource");
		this.schemaPattern = "HR";
		
		List<SchemaAccessor.Column> cols = this.accessor.getColumnsBySchemaPattern(ds, schemaPattern);

		System.out.println("GetColumnsBySchemaPatternWithNormalOracleDataSource");
		for(SchemaAccessor.Column col : cols){
			System.out.println(col.toString());
		}
		System.out.println("");
	
		Assert.assertTrue(true);
	}

	@Test
	public void testGetColumnsBySchemaPatternWithDetailedOracleDataSource() throws Exception{
		
		this.ds = (DataSource)springCtx.getBean("detailedOracleDataSource");
		this.schemaPattern = "HR";
		
		List<SchemaAccessor.Column> cols = this.accessor.getColumnsBySchemaPattern(ds, schemaPattern);

		System.out.println("GetColumnsBySchemaPatternWithDetailedOracleDataSource");
		for(SchemaAccessor.Column col : cols){
			System.out.println(col.toString());
		}
		System.out.println("");
	
		Assert.assertTrue(true);
	}

}
