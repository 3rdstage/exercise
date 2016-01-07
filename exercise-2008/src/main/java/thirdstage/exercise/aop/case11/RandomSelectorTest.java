/**
 * 
 */
package thirdstage.exercise.aop.case11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 3rdstage
 *
 */
public class RandomSelectorTest {
	
	public final static String[] GREETINGS = {"Hi!", "Hellow", "Nice to meet you.", "Long time no see.", "What's up"};

	public static void main(String[] args) throws Exception{
		
		int nThreads = 100;
		
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
