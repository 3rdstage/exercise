package thirdstage.meta.jls3;

/**
 * 
 * @author 3rdstage
 * @see http://help.eclipse.org/indigo/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/ImportDeclaration.html
 */
public class ImportDecl extends Base{

	private boolean isStatic;
	
	private boolean isSingle;
	
	private String name;
	
	public ImportDecl(boolean isStatic, boolean isSingle, String name, int startLine, int endLine){
		super(startLine, endLine);
		this.isStatic = isStatic;
		this.isSingle = isSingle;
		this.name = name;
	}
	
	public boolean isStatic(){ return this.isStatic; }
	
	public boolean isSingle(){ return this.isSingle; }
	
	public String getName(){ return this.name; }
	
	
}
