package thirdstage.exercise.storm.calc;

import java.math.BigDecimal;
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
 

	/**
	 * @param from
	 * @param to should be equal or greater than {@code from}
	 * @param step should be positive
	 * @return
	 */
	public double sumBetween(double from, double to, double step){
	   Validate.isTrue(to >= from, "to should be equal or greater than from.");
	   Validate.isTrue(step >= 0.0, "step should be positive.");
	   
		BigDecimal a = new BigDecimal(from); 
		BigDecimal b = new BigDecimal(to);
		BigDecimal inc = new BigDecimal(step);
		BigDecimal sum = BigDecimal.ZERO;

		BigDecimal c = a;
		for(;;){
		   if(delay > 0){
		      try{ Thread.sleep(this.delay); }
		      catch(InterruptedException ex){}
		   }

		   sum = sum.add(c);
		   c = c.add(inc);
		   
		   if(c.compareTo(b) > 0){ break; }
		}
		
		return sum.doubleValue();
	}

}
