package thirdstage.meta.jls3;

import java.util.List;

public class FieldDecl extends Base{
	
	private String type;

	private String[] modifiers;

	private String name;
	
	private String str = null; //for to String
	
	public FieldDecl(String type,String[] modifiers,  String name, int startLine, int endLine){
		super(startLine, endLine);
		this.type = type;
		this.modifiers = modifiers;
		this.name = name;
		
		if(!Boolean.valueOf(System.getProperty("thirdstage.meta.jls3.memorySaving", "true"))){
			StringBuilder sb = new StringBuilder();
			for(String m : this.modifiers) sb.append(m).append(" ");
			this.str = sb.append(this.type).append(" ").append(this.name).toString();
		}
	}
	
	public String getType(){ return this.type; }
	
	public String[] getModifiers(){ return this.modifiers; }

	public String getName(){ return this.name; }
	
	public String toString(){
		if(this.str != null) return this.str;
		else{
			StringBuilder sb = new StringBuilder();
			for(String m : this.modifiers) sb.append(m).append(" ");
			return sb.append(this.type).append(" ").append(this.name).toString();
		}
	}
}
