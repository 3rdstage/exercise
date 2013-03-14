package thirdstage.exercise.spring3.aop.case2;

public class ElapsedTimeLogValue extends AbstractLogValue {
	
	private long start;
	 
	private long end;
	
	public ElapsedTimeLogValue(String[] context, long start, long end){
		super(LogType.ElapsedTime, context);
		this.start = start;
		this.end = end;
	}

	
	public long getStart(){ return this.start; }
	
	public long getEnd(){ return this.end; }
}
