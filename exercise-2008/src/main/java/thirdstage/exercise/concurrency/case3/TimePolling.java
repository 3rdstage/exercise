/**
 * 
 */
package thirdstage.exercise.concurrency.case3;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author 3rdstage
 *
 */
public class TimePolling implements Callable<List<Date>> {
	
	private int count = 0;
	
	private long interval = 0; //polling interval in milliseconds
	
	/**
	 * @param count
	 * @param interval should be equal or larger than 1000
	 */
	public TimePolling(int count, long interval){
		if(interval < 1000) throw new IllegalArgumentException("interval should be equal or larger than 1000.");
		
		this.count = count;
		this.interval = interval;
		
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public List<Date> call() throws Exception {
		List<Date> dates = new java.util.ArrayList<Date>(this.count);

		while(count-- > 1){
			dates.add(new Date());
			Thread.currentThread().sleep(this.interval);
		}
		
		return dates;
	}

	
	
	

}
