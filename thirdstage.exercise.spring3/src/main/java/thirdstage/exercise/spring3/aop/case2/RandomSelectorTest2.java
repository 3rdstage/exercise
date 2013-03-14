package thirdstage.exercise.spring3.aop.case2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import junit.framework.Assert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class RandomSelectorTest2 {

	public final static String[] GREETINGS = {"Hi!", "Hellow", "Nice to meet you.", "Long time no see.", "What's up"};

	@Test
	public void testUdpHandler() throws Exception{
		
		String location = "thirdstage/exercise/spring3/aop/case2/spring-udp.xml";
		this.test(new ClassPathXmlApplicationContext(location), 100);
	}
	
	@Test
	public void testQueuingHandler() throws Exception{
		
		int nThreads = 100;
		
		String location = "thirdstage/exercise/spring3/aop/case2/spring-queuing.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(location);
		this.test(context, nThreads);
		
		Queue que = context.getBean("sendQueue", java.util.Queue.class);
		
		Assert.assertEquals(nThreads, que.size()); 
	}


	private void test(ApplicationContext context, int nThreads) throws Exception{

	
		List<Callable<String>> selectors = new ArrayList<Callable<String>>(nThreads);
		List<Future<String>> futures = new ArrayList<Future<String>>(nThreads);
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i = 0; i < nThreads; i++){
			selectors.add(new RandomSelector(GREETINGS, 2000));
		}
		
		futures = executor.invokeAll(selectors);
		
		for(Future<String> future : futures){
			System.out.printf(" Selected one is : %1$s\n", future.get());
		}
		
		executor.shutdown();
	}

}
