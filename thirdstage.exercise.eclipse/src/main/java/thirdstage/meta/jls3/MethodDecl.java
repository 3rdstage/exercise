package thirdstage.meta.jls3;

public class MethodDecl extends Base{
	
	private String returnType;
	
	private String name;
	
	public MethodDecl(String rType, String name, int startLine, int endLine){
		super(startLine, endLine);
		this.returnType = rType;
		this.name = name;
	}
	
	public String getReturnType(){ return this.returnType; }
	
	public String getName(){ return this.name; }
	
	
	

}
