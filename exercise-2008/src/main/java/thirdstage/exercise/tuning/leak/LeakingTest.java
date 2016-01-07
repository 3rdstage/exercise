/**
 * 
 */
package thirdstage.exercise.tuning.leak;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 3rdstage
 *
 */
public class LeakingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		  int num = 20;
		  int interval = 1000;
		  long count = 100000;
		  long start = 100;
		  int step = 1;
		  
		  List<LeakableTask> tasks = new ArrayList<LeakableTask>();
		  ExecutorService service = Executors.newFixedThreadPool(num);
		  List<Future<List<AtomicLong>>> futures = null;
		  
		  for(int i = 0; i < num; i++){
			  tasks.add(new LeakableTask(true, interval, count, start + i%2, step + i%2));
		  }
		  
		  futures =  service.invokeAll(tasks);	
	}
}
