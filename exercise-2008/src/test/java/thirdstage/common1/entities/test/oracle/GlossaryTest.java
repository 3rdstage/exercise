/**
 * 
 */
package thirdstage.common1.entities.test.oracle;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Locale;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import thirdstage.common1.entities.Glossary;
import thirdstage.common1.entities.Word;

/**
 * @author 3rdstage
 *
 */
public class GlossaryTest extends BaseTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
		super.setUp();
		
		this.cleanAndLoadTestData((new ClassPathResource("thirdstage/common1/test/dataset/dataset-glossary-word.xml")).getFile());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testGlossaryLoad() throws Exception{
		
		Session sess = null;
		Glossary glossary1 = null;
		Glossary glossary2 = null;
		Glossary glossary3 = null;
		
		try{
			sessionFactory.getCurrentSession().beginTransaction();
			
			glossary1 = (Glossary)sessionFactory.getCurrentSession().get(Glossary.class, new Long(1000L));
			
			assertEquals("Java", glossary1.getName());
			assertEquals(Locale.ENGLISH.getLanguage(), glossary1.getLanguageCode());
			assertNull(glossary1.getDescription());

			sessionFactory.getCurrentSession().getTransaction().commit();
		}
		catch(Exception ex){
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw ex;
		}
	}
	
	@Test
	public void testWordPagination() throws Exception{
		
		List<Word> words = null;
		Word word1 = null;
		
		try{
			sessionFactory.getCurrentSession().beginTransaction();
			
			Query q = sessionFactory.getCurrentSession().createQuery("from Word word");
			q.setFirstResult(3);
			q.setMaxResults(3);
			
			words = (List<Word>)q.list();
			word1 = words.get(0);
			
			assertEquals("API", word1.getName());

			sessionFactory.getCurrentSession().getTransaction().commit();
		}
		catch(Exception ex){
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw ex;
		}
	}
	
}
