package thirdstage.meta.jls3;

import java.util.List;

public class ClassUnit extends Unit{
	
	private FieldDecl[] fieldDecls;
	
	private MethodDecl[] methodDecls;
	
	
	public ClassUnit(PackageDecl pkgDecl, List<ImportDecl> importDecls,
			FieldDecl[] fieldDecls, MethodDecl[] methodDecls){
		super(pkgDecl, importDecls);
		this.fieldDecls = fieldDecls;
		this.methodDecls = methodDecls;
	}
	
	
	public FieldDecl[] getFieldDecls(){ return this.fieldDecls; }
	
	public MethodDecl[] getMethodDecls(){ return this.methodDecls; }
	
	
	

}
