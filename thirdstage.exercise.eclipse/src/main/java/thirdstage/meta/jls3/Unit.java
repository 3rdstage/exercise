package thirdstage.meta.jls3;

import java.util.List;

/**
 * @see http://help.eclipse.org/indigo/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/CompilationUnit.html
 */
public class Unit {
	
	private PackageDecl packageDecl;
	
	private List<ImportDecl> importDecls;
	
	public Unit(PackageDecl pkgDecl, List<ImportDecl> importDecls){
		this.packageDecl = pkgDecl;
		this.importDecls = importDecls;
		
	}
	
	public PackageDecl getPackageDecl(){
		return this.packageDecl;
	}
	
	public List<ImportDecl> getImportDecls(){
		return this.importDecls;
	}
	
	

}
