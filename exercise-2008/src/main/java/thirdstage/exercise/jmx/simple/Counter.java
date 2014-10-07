/**
 * 
 */
package thirdstage.exercise.jmx.simple;

/**
 * @author 3rdstage
 *
 */
public class Counter implements CounterMBean{
	
	private int number = 0;
	
	public Counter(){}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple.CounterMBean#getCount()
	 */
	@Override
	public int getCount() {
		return this.number;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple.CounterMBean#setCount(int)
	 */
	@Override
	public void setCount(int cnt) {
		this.number = cnt;
	}
	
	
	

}
