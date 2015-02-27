package thirdstage.meta.jls3;

/*
 * 
 * @see http://help.eclipse.org/indigo/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/PackageDeclaration.html
 */
public class PackageDecl extends Base{
	
	private String name;
	
	public PackageDecl(String name, int startLine, int endLine){
		super(startLine, endLine);
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	
 
	

}
