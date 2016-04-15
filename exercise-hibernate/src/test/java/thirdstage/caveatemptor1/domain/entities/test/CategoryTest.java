package thirdstage.caveatemptor1.domain.entities.test;

import static org.junit.Assert.assertTrue;
import java.util.Properties;
import javax.sql.DataSource;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

public class CategoryTest{

	private static ApplicationContext applicationContext;
	private static SessionFactory sessionFactory;
	private static HibernateTransactionManager transactionManager;
	private static ReplacementDataSet seedDataSet;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception{

		Properties props = new Properties();
		props.load((new ClassPathResource("thirdstage/caveatemptor1/test/log4j-caveatemptor-test.properties")).getInputStream());
		org.apache.log4j.LogManager.resetConfiguration();
		org.apache.log4j.PropertyConfigurator.configure(props);

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
			DatabaseOperation.TRUNCATE_TABLE.execute(conn, seedDataSet);
			DatabaseOperation.INSERT.execute(conn, seedDataSet);
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

	/**
	 * Tests object identity of persistent objects for same database row created accross sessions or within the same session. Using SessionFactory.openSession method.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testObjectIdentityScope() throws Exception{

		Session sess1 = sessionFactory.openSession();
		Transaction tx1 = sess1.beginTransaction();

		Category a = (Category)sess1.get(Category.class, new Long(100));
		Category b = (Category)sess1.get(Category.class, new Long(100));

		System.out.println(a.hashCode());
		System.out.println(b.hashCode());

		tx1.commit();
		sess1.close();

		Session sess2 = sessionFactory.openSession();
		Transaction tx2 = sess2.beginTransaction();

		Category c = (Category)sess2.get(Category.class, new Long(100));

		System.out.println(c.hashCode());

		tx2.commit();
		sess2.clear();

		assertTrue(a == b);
		assertTrue(a != c);
	}

	@Test
	public void testObjectIdentityScope2() throws Exception{

		Session sess1 = sessionFactory.getCurrentSession();
		Transaction tx1 = sess1.beginTransaction();

		Category a = (Category)sess1.get(Category.class, new Long(100));
		Category b = (Category)sess1.get(Category.class, new Long(100));

		System.out.println(a.hashCode());
		System.out.println(b.hashCode());

		tx1.commit();

		Session sess2 = sessionFactory.getCurrentSession();
		Transaction tx2 = sess2.beginTransaction();

		Category c = (Category)sess2.get(Category.class, new Long(100));

		System.out.println(c.hashCode());

		tx2.commit();

		assertTrue(a == b);
		assertTrue(a != c);
	}

	@Test
	@Ignore("Not yet implemented")
	public void testObjectIdentityScope3() throws Exception{}
}
