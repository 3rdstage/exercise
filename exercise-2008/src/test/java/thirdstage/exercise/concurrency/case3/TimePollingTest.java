package thirdstage.exercise.concurrency.case3;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

import org.apache.commons.lang.time.FastDateFormat;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TimePollingTest {
	
	protected ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
	
	@BeforeClass 
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() { 
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}


	@Test
	public void call() throws Exception{
		
		Callable<List<Date>> task = new TimePolling(10000, 1000);
		Future<List<Date>> future = service.submit(task); 
		
		int cnt = 0;
		int ms = 2000;
		FastDateFormat df = FastDateFormat.getInstance("yyyy/MM/dd-HH:mm:ss", TimeZone.getTimeZone("Asia/Seoul"), Locale.KOREA);
		while(!future.isDone()){
			System.out.printf("Task is still running : %1$d millisec has passed at %2$s.\n", cnt++*ms, df.format(System.currentTimeMillis()));
			Thread.currentThread().sleep(ms);
		}
		List<Date> dates = future.get();
		System.out.printf("Task is done : %1$d timestamps are collected.\n", dates.size());
	}
}
