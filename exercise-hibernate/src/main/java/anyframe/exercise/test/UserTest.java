package anyframe.exercise.test;

import java.util.List;
import javax.annotation.Resource;
import junit.framework.Assert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import anyframe.exercise.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/anyframe/exercise/context-common.xml"})
public class UserTest{
	
	@Resource(name="defaultHibernateSessionFactory")
	private SessionFactory sessFactory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception{}

	@AfterClass
	public static void tearDownAfterClass() throws Exception{}

	@Before
	public void setUp() throws Exception{}

	@After
	public void tearDown() throws Exception{}
	
	@Test
	public void testSelectUsers() throws Exception{

		Session sess = null;
		try{
			sess = this.sessFactory.openSession();
			List<User> users = sess.getNamedQuery("selectUser").list();
			
			for(User user : users){
				System.out.println(user.toString());
			}

			Assert.assertEquals(6, users.size());
			
		}catch(Exception ex){
			throw ex;
		}finally{
			if(sess != null) sess.close();
		}
	}
	

}
