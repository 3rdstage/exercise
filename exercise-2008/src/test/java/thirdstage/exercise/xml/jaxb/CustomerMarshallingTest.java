/**
 * 
 */
package thirdstage.exercise.xml.jaxb;


import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import thirdstage.exercise.xml.jaxb.Customer;

/**
 * @author 3rdstage
 *
 */
public class CustomerMarshallingTest {

	protected static JAXBContext bindingContext;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		bindingContext = JAXBContext.newInstance(Customer.class);
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
	public void testMarshalingSimplestCustomer() throws Exception{
		
		
		Customer cust = new Customer();
		cust.setId(31);
		cust.setFirstName("Tommy");
		cust.setLastName("Bolin");
		cust.setCountry("USA");
		
		StringWriter sw = new StringWriter();
		
		Marshaller ms = bindingContext.createMarshaller();
		ms.setProperty("jaxb.formatted.output", true);
		ms.marshal(cust, sw);
		
		System.out.println(sw.toString());
		
		Assert.assertTrue(true);
	}
	
	
}
