package thirdstage.exercise.storm.calc;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.storm.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

@ThreadSafe
public class LazyCalc {

	/**
	 * Default delay in millisecond
	 */
	public static final int DEFAULT_DELAY = 500;

	/**
	 * Max dealy in millisecond
	 */
	public static final int MAX_DELAY = 5000;

	private int delay = 500;

	public LazyCalc(){}

	/**
	 * @param delay in millisecond
	 */
	public LazyCalc(@Min(0) @Max(MAX_DELAY) int delay){
		Validate.isTrue(delay > -1, "Delay should be non-negative.");
		Validate.isTrue(delay <= MAX_DELAY, "Delay should be equal or less than %1$s", MAX_DELAY);
		this.delay = delay;

	}


	public long sumIntBetween(int from, int to){
		int a = from, b = to;
		long s = 0;
		if(from > to){
			a = to;
			b = from;
		}

		for(int i = a; i < b; i++){
			try{ Thread.currentThread().sleep(this.delay); }
			catch(InterruptedException ex){}

			s += i;
		}
		try{ Thread.currentThread().sleep(this.delay); }
		catch(InterruptedException ex){}
		return (s + b);
	}

}
