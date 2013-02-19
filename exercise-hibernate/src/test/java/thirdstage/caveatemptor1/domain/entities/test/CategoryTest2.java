package thirdstage.caveatemptor1.domain.entities.test;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.util.Properties;
import java.util.Set;


import javax.sql.DataSource;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import thirdstage.caveatemptor1.domain.entities.Category;

public class CategoryTest2{

	private static ApplicationContext applicationContext;
	private static SessionFactory sessionFactory;
	private static HibernateTransactionManager transactionManager;
	private static ReplacementDataSet seedDataSet;

	private final static Logger logger = Logger.getLogger(CategoryTest2.class);
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{

		Properties props = new Properties();
		props.load((new ClassPathResource("thirdstage/caveatemptor1/test/log4j-caveatemptor-test.properties")).getInputStream());
		org.apache.log4j.LogManager.resetConfiguration();
		org.apache.log4j.PropertyConfigurator.configure(props);
		org.apache.log4j.LogManager.getRootLogger().setLevel((Level)Level.TRACE);

		applicationContext = new ClassPathXmlApplicationContext("thirdstage/caveatemptor1/spring-caveatemptor.xml");
		sessionFactory = (SessionFactory)(applicationContext.getBean("defaultHibernateSessionFactory"));
		transactionManager = (HibernateTransactionManager)(applicationContext.getBean("defaultTransactionManager"));

		DataSource dataSource = (DataSource)(applicationContext.getBean("defaultDataSource"));
		IDatabaseConnection conn = new MySqlConnection(dataSource.getConnection(), "caveatemptor1");
		boolean isAutoCommit = conn.getConnection().getAutoCommit();
		conn.getConnection().setAutoCommit(true);
		DatabaseConfig config = conn.getConfig();
		config.setFeature(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);

		seedDataSet = new ReplacementDataSet(new FlatXmlDataSet((new ClassPathResource(
			"thirdstage/caveatemptor1/test/data/dataset-seed-caveatemptor1-category.xml")).getFile()));
		seedDataSet.addReplacementObject("[null]", null);

		try{
			/* IMPORTANT Self referenced table and dbunit
			 * Clean insert database operation (by DatabaseOperation.CLEAN_INSERT.execute method)
			 * would not work correctly on a table which has references on itself and such data.
			 * It is because clean insert operation uses delete operation internally. 
			 * To avoid these problem, you should use truncate operation(DatabaseOperation.TRUNCATE_TABLE)
			 * and insert operation(DatabaseOperation.INSERT) in row.
			 * 
			 */
			//DatabaseOperation.CLEAN_INSERT.execute(conn, seedDataSet);
			DatabaseOperation.TRUNCATE_TABLE.execute(conn, seedDataSet);
			DatabaseOperation.INSERT.execute(conn, seedDataSet);
		}catch(Exception ex){
			ex.printStackTrace(System.err);
			throw ex;
		}finally{
			conn.getConnection().setAutoCommit(isAutoCommit);
			conn.close();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		applicationContext = null;
		sessionFactory = null;
		transactionManager = null;
		seedDataSet = null;
	}

	@Before
	public void setUp() throws Exception{}

	@After
	public void tearDown() throws Exception{}

	@Test
	public void testSave(){
		this.logger.info("method stated - testSave");
		Category category = new Category();
		Long categoryId = null;
		category.setName("Car");

		try{
			sessionFactory.getCurrentSession().beginTransaction();
			categoryId = (Long)sessionFactory.getCurrentSession().save(category);
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch(Exception ex){
			this.logger.error("exception", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}

		System.out.println("Generated ID is : " + categoryId);

		assertTrue(true);
		this.logger.info("method ending - testSave");
	}

	@Test
	@Ignore("temprary")
	public void testSaveWithChild(){
		Category category1 = new Category();
		category1.setName("Electronic Home Applicances");

		Category category2 = new Category();
		category2.setName("Refrigerator");

		Category category3 = new Category();
		category3.setName("Washing Machine");

		category1.addChildCateogy(category2);
		category1.addChildCateogy(category3);

		try{
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().persist(category1);
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch(Exception ex){
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}

		System.out.println("Generated IDs are : " + category1.getId() + ", " + category2.getId() + ", " + category3.getId());

		//Category has persist cascade property on it's one-to-many relationship
		assertNotNull(category1.getId());
		assertNotNull(category2.getId());
		assertNotNull(category3.getId());
	}

	@Test
	public void testSaveChildFirst(){
		Category category1 = new Category();
		category1.setName("Clothing");
		
		Category category2 = new Category();
		category2.setName("Men's Clothing");
		
		Category category3 = new Category();
		category3.setName("Women's Clothing");
		
		category1.addChildCateogy(category2);
		category1.addChildCateogy(category3);
		
		try{
			this.sessionFactory.getCurrentSession().beginTransaction();
			this.sessionFactory.getCurrentSession().persist(category2);

			/* IMPORTANT Persist of transient object having transient parent withdout cascade.
			 *
			 * The following line would raise exception and rollback would be perfomed 
			 * although the above persist line performed and the id of category2 is captured.
			 * 
			 * This seems to be somewhat strange behavior, because at the end category2
			 * has it's not-null id but is still transiet.(that is no corresponding row
			 * in database.)
			 */
			this.sessionFactory.getCurrentSession().getTransaction().commit();
		}catch(Exception ex){
			this.sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		
		System.out.println("Generated IDs are : " + category1.getId() + ", " + category2.getId() + ", " + category3.getId());

		//Category dosen't have persist cascade property on it's many-to-one relationship.
		assertNull(category1.getId());
		assertNotNull(category2.getId());
		assertNull(category3.getId());
	}
	
	@Test
	@Ignore("temprary")
	public void testLoad() throws Exception{
		
		Category category = null;
		Set<Category> subcategories = null;
		
		
		try{
			/* IMPORTANT Read only queries and transaction in Hibernate
			 * 
			 * Hibernate needs explicit transaction when peforming only selection.
			 * 
			 */
			this.sessionFactory.getCurrentSession().beginTransaction();
			category = (Category)this.sessionFactory.getCurrentSession().load(Category.class, new Long(100L));
			subcategories = category.getChildCategories();
			
			/* IMPORTANT Load actually lazy-loaded collection of parent
			 * 
			 * Just getting size of the collection would load the collection
			 * which is defined with implicit/explicit lazy-load option.
			 * 
			 */
			subcategories.size();
			this.sessionFactory.getCurrentSession().getTransaction().commit();
		}catch(Exception ex){
			this.sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		
		
		System.out.println("Loaded Category is id : " + category.getId() + ", name : " + category.getName());
		System.out.println("Subcategories are : ");
		for(Category cat : subcategories){
			System.out.println("           id : " + cat.getId() + ", name : " + cat.getName());
		}
		
		assertTrue("Computer".equals(category.getName()));
		assertTrue(subcategories.size() == 3);
	}
	
	/**
	 * You should check the query generated.
	 */
	@Test
	@Ignore("temprary")
	public void testGetWithLock(){
		
		Category category = null;
		
		try{
			this.sessionFactory.getCurrentSession().beginTransaction();
			category = (Category)this.sessionFactory.getCurrentSession().get(Category.class, new Long(100L), LockMode.UPGRADE);
			this.sessionFactory.getCurrentSession().getTransaction().commit();
		}catch(Exception ex){
			this.sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		
		assertTrue(true);
		
	}
	
}
