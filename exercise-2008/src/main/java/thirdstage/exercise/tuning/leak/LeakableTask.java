/**
 * 
 */
package thirdstage.exercise.tuning.leak;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 3rdstage
 *
 */
public class LeakableTask implements Callable<List<AtomicLong>> {
	
	private boolean hasLeak = false;
	
	private int interval = 1000;
	
	private long count = 1000;
	
	private long start = 1;
	
	private int step = 1;
	
	private List<AtomicLong> collector = new ArrayList<AtomicLong>(10000);
	
	
	/**
	 * @param interval interval of collecting in milliseconds
	 * @param count the number of collecting
	 * @param start the start integer to collect
	 * @param step the step of integers to collect. must be positive
	 */
	public LeakableTask(boolean leaks, int interval, long count, long start, int step){
		this.hasLeak = leaks;
		this.interval = interval;
		this.count = count;
		this.start = start;
		this.step = step;
	}
	
	public boolean hasLeak(){ return this.hasLeak; }
	
	public int getInterval(){ return this.interval; }
	
	public long getCount(){ return this.count; }
	
	public long getStart(){ return this.start; }
	
	public int getStep(){ return this.step; }
	
	public List<AtomicLong> getCollector(){ return this.collector; }
	
	public List<AtomicLong> call() throws Exception{
		
		for(long i = 0; i < count; i++){
			if(this.hasLeak) this.collector.add(new AtomicLong(start + i*step));
			else new AtomicLong(start + i*step);
			
			Thread.currentThread().sleep(this.interval);
			
			System.out.printf(" Thead : %1$s %3$s %2$d\n", Thread.currentThread().getName(), start + i*step,
					this.hasLeak ? "collected" : "created");;
		}
		
		return this.getCollector();
	}
}
