/**
 * 
 */
package thirdstage.exercise.spring3.property;


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
public class ContactsTest {
	
	private static ApplicationContext springContext;
	
	private Contacts contacts;
	
	@BeforeClass
	public static void beforeClass(){
		System.setProperty("contacts.wishtogo", "swiss");
		springContext = new ClassPathXmlApplicationContext("thirdstage/exercise/spring3/property/spring.xml");
		
	}
	
	@Before
	public void before(){
		this.contacts = (Contacts)springContext.getBean("simpleContacts", Contacts.class);		
	}
	
	
	
	@Test
	public void testContacts(){
		
		System.out.println(this.contacts.toString());
		
		Assert.assertEquals("02-555-3333", this.contacts.getTelephoneNo());
		Assert.assertEquals("Bern", this.contacts.getAddress());
	}

}
