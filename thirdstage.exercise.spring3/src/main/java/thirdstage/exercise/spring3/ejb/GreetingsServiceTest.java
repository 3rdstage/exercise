package thirdstage.exercise.spring3.ejb;

import javax.annotation.Resource;
import javax.naming.Context;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test; 

import thirdstage.exercise.ejb3.simple.GreetingsService;

@ContextConfiguration("/thirdstage/exercise/spring3/ejb3/spring.xml")
public class GreetingsServiceTest extends AbstractTestNGSpringContextTests{

	@Resource(name="greetingsService") 
	private GreetingsService greetings;
	

	@Test
	public void testSayHello() {
		
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
		
		String str = this.greetings.sayHello();
		
		Assert.assertEquals("Hello", str);
		
		
	}
}
