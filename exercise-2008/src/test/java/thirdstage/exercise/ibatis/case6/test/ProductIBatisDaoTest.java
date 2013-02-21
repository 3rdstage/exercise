/**
 * 
 */
package thirdstage.exercise.ibatis.case6.test;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibatis.sqlmap.client.SqlMapClient;

import thirdstage.exercise.ibatis.case6.ProductDao;
import thirdstage.exercise.ibatis.case6.ProductIBatisDao;

/**
 * @author 3rdstage
 *
 */
public class ProductIBatisDaoTest {

	private static ApplicationContext springContext;

	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		springContext = new ClassPathXmlApplicationContext("thirdstage/exercise/ibatis/case6/confs/spring.xml");
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetProduct(){
		
		ProductIBatisDao dao = new ProductIBatisDao();
		
		try{
			SqlMapClient sqlMapClient = (SqlMapClient)(springContext.getBean("sqlMapClient"));
			dao.setSqlMapClient(sqlMapClient);
			Map<String, Object> product = dao.getProduct("FI-FW-02");
			
			Set<String> keys = product.keySet();
			byte[] bs1 = null;
			for(String key : keys){
				if("small_image".equals(key)){
					bs1 = (byte[])product.get(key);
					System.out.print("image in byte array 1 : ");
					for(int i = 0, n = bs1.length; i < n; i++) System.out.print(bs1[i]);
					System.out.println();
				}
				else{
					System.out.println(key + " : " + product.get(key));
				}
			}
			
			
			File file = new File("c:/temp/fish2.gif");
			long len = file.length();
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			byte[] bs2 = new byte[(int)len];
			bis.read(bs2, 0, (int)len);
			System.out.print("image in byte array 2 : ");
			for(int i = 0, n = bs2.length; i < n; i++) System.out.print(bs2[i]);
			System.out.println();
			
			Assert.assertArrayEquals(bs1, bs2);
			
			
		}
		catch(Exception ex){ 
			ex.printStackTrace(System.err);
		}
		
	}
}
