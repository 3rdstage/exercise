package thirdstage.exercise.spring.aspectj.case1;

import static org.junit.Assert.*;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageCommunicatorTest{

	protected static ApplicationContext springContext;

	protected MessageCommunicator tester;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		springContext = new ClassPathXmlApplicationContext("thirdstage/exercise/spring/aspectj/case1/spring-beans.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception{}

	@Before
	public void setUp() throws Exception{
		this.tester = (MessageCommunicator)springContext.getBean("messageCommunicator");
	}

	@After
	public void tearDown() throws Exception{}

	@Test
	public void testDeliverString(){
		System.out.println("???");
		
		this.tester.deliver("Waiting for holidays");
		Assert.assertTrue(true);

	}

	@Test
	public void testDeliverStringString(){
		
		this.tester.deliver("Claire", "Be healthy, smart and beautiful.");
		Assert.assertTrue(true);
	}

}
