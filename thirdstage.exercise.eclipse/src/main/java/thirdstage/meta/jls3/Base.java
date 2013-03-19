package thirdstage.meta.jls3;

public abstract class Base implements PositionAware{

	private int startLineNum;
	
	private int endLineNum;
	
	public Base(int startLine, int endLine){
		this.startLineNum = startLine;
		this.endLineNum = endLine;
	}
	
	public int getStartLineNumber(){
		return this.startLineNum;
	}
	
	public int getEndLineNumber(){
		return this.endLineNum;
	}
	
}
