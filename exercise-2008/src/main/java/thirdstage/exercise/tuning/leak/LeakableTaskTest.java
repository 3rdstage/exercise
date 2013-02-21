/**
 * 
 */
package thirdstage.exercise.tuning.leak;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author 3rdstage
 *
 */
public class LeakableTaskTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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

	/**
	 * Test method for {@link thirdstage.exercise.tuning.leak.LeakableTask#call()}.
	 */
	@Test
	public void testCallWithLeakage() throws Exception{
		  int num = 100;
		  int interval = 10;
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
	
	@Test
	public void testCallWithoutLeakage() throws Exception{
		  int num = 100;
		  int interval = 10;
		  long count = 100000;
		  long start = 100;
		  int step = 1;
		  
		  List<LeakableTask> tasks = new ArrayList<LeakableTask>();
		  ExecutorService service = Executors.newFixedThreadPool(num);
		  List<Future<List<AtomicLong>>> futures = null;
		  
		  for(int i = 0; i < num; i++){
			  tasks.add(new LeakableTask(false, interval, count, start + i%2, step + i%2));
		  }
		  
		  futures =  service.invokeAll(tasks);	
	}
}
