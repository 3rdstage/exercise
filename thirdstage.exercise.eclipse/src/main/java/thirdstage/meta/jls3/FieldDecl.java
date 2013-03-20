package thirdstage.meta.jls3;

import java.util.List;

public class FieldDecl extends Base{
	
	private String type;
	
	private String[] names;
	
	private String[] modifiers;
	
	public FieldDecl(String type, String[] names, String[] modifiers, int startLine, int endLine){
		super(startLine, endLine);
		this.type = type;
		this.names = names;
		this.modifiers = modifiers;
	}
	
	public String getType(){ return this.type; }
	
	public String[] getNames(){ return this.names; }
	
	public String[] getModifiers(){ return this.modifiers; }
	
	
	
	
	
	

}
