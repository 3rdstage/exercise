

package thirdstage.exercise.spring.hibernate3.case5.test;

import java.util.List;
import junit.framework.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.*;

import thirdstage.exercise.spring.hibernate3.case5.Product;
import thirdstage.exercise.spring.hibernate3.case5.ProductDao;

/**
 *
 * @author 3rdstage
 */
public class ProductDaoHibernateImpl3Test extends TestCase {

	private BeanFactory factory = null;
	
	public ProductDaoHibernateImpl3Test(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
		this.factory = new XmlBeanFactory(new ClassPathResource("spring-exercise-spring-hibernate3-case5.xml"));
	}

	protected void tearDown() throws Exception {
	}

	public static Test suite() {
		TestSuite suite = new TestSuite(ProductDaoHibernateImpl3Test.class);
		
		return suite;
	}


	/**
	 * Test of getProductsByCategory method, of class thirdstage.exercise.spring.hibernate5.ProductDaoHibernateImpl3.
	 */
	public void testGetProductsByCategory() {
		System.out.println("getProductsByCategory");

		ProductDao dao = (ProductDao)(this.factory.getBean("productDao3"));
		System.out.println("Hash code : " + dao.hashCode());
		String category = "cpu";
		try{
			
			java.util.Collection expResult = null;
			java.util.Collection result = dao.getProductsByCategory(category);
			
			for(int i = 0, n = result.size(); i < n; i++){
				System.out.println("" + ((Product)((List)result).get(i)).getId() + ", " + ((Product)((List)result).get(i)).getName());
			}
			assertTrue(result.size() > 0);
		}
		catch(Exception ex){
			System.out.println("fail");
			ex.printStackTrace(System.out);
		}
	}

	/**
	 * Test of getProductsByCategory2 method, of class thirdstage.exercise.spring.hibernate5.ProductDaoHibernateImpl3.
	 */
	public void testGetProductsByCategory2() throws Exception {
		System.out.println("getProductsByCategory2");
		
		ProductDao dao = (ProductDao)(this.factory.getBean("productDao3"));
		String category = "cpu";
		try{
			java.util.List<Product> result = dao.getProductsByCategory2(category);
			
			for(int i = 0, n = result.size(); i < n; i++){
				System.out.println("" + result.get(i).getId() + ", " + result.get(i).getName());
			}
			
			assertTrue(result.size() > 0);
		}
		catch(Exception ex){
			System.out.println("fail");
			ex.printStackTrace(System.out);
		}

	}
	
}
