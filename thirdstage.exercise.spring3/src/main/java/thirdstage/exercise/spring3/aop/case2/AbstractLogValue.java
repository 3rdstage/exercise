package thirdstage.exercise.spring3.aop.case2;

public abstract class AbstractLogValue {
	  
	private LogType type = null;
	private String[] context = null;
	
	public AbstractLogValue(LogType type, String[] context){
		this.type = type;
		this.context = context;
		
	}
	
	public LogType getLogType(){ return this.type; }
	
	public String[] getContext(){ return this.context; }
	

}
