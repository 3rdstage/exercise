package thirdstage.meta.jls3;

//@todo Make common parent of FieldDecl and MethodDecl
public class MethodDecl extends Base{
	
	private String type;
	
	private String[] modifiers;
	
	private String name;
	
	private String str;
	
	public MethodDecl(String type, String[] mdfrs, String name, int startLine, int endLine){
		super(startLine, endLine);
		this.type = type;
		this.modifiers = mdfrs;
		this.name = name;
	}
	
	public String getReturnType(){ return this.type; }
	
	public String[] getModifiers(){ return this.modifiers; }
	
	public String getName(){ return this.name; }
	
	
	public String toString(){
		//@todo Need to apply double checked locking
		if(this.str != null) return this.str;
		else{
			StringBuilder sb = new StringBuilder();
			for(String m : this.modifiers) sb.append(m).append(" ");
			this.str = sb.append(this.type).append(" ").append(this.name).toString();	
			return this.str;
		}
	}	

}
