package thirdstage.meta.jls3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class MetaBuilder {

	private String sourceFile; 
	
	public MetaBuilder(){
		
	}

	public MetaBuilder(String file){
		this.setSourceFile(file);
	}
	
	public void setSourceFile(String file){ this.sourceFile = file; }
	
	
	public Unit build() throws Exception{
		String srcStr = FileUtils.readFileToString(new File(this.sourceFile), "utf-8");
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(srcStr.toCharArray());
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		CompilationUnit cu = (CompilationUnit) parser.createAST(null);
		
		Visitor vst = new Visitor(cu);
		
		return vst.getResult();
	}
	
}

class Visitor extends ASTVisitor{
	
	private CompilationUnit source;
	private PackageDecl packageDecl;
	private List<ImportDecl> importDecls = new ArrayList<ImportDecl>();
	private List<FieldDecl> fieldDecls = new ArrayList<FieldDecl>();
	
	public Visitor(CompilationUnit cu){
		this.source = cu;
	}
	
	public Unit getResult(){
		
		return new ClassUnit(this.packageDecl, this.importDecls, 
				fieldDecls.toArray(new FieldDecl[fieldDecls.size()]), null);
	}

	public boolean visit(PackageDeclaration pd){
		int start = pd.getStartPosition();
		int end = start + pd.getLength();
		int startLine = this.source.getLineNumber(start);
		int endLine = this.source.getLineNumber(end);
		
		this.packageDecl = new PackageDecl(pd.getName().toString(), startLine, endLine);
		
		return true;
	}
	
	public boolean visit(ImportDeclaration id){
		int sl = this.source.getLineNumber(id.getStartPosition());
		int el = this.source.getLineNumber(id.getStartPosition() + id.getLength());
		
		this.importDecls.add(new ImportDecl(id.isStatic(), 
				id.isOnDemand(), id.getName().toString(), sl, el));
		return true;
	}
	
	public boolean visit(FieldDeclaration fd){
		Pair<Integer, Integer> r = this.getLineRange(fd);
		
		String type = fd.getType().toString();
		List<VariableDeclarationFragment> frgmts = fd.fragments();
		List<String> names = new ArrayList<String>();
		for(VariableDeclarationFragment frgmt : frgmts){
			names.add(frgmt.getName().toString());
		}
		List mdfrs = fd.modifiers();
		List<String> modifires = new ArrayList<String>();
		for(Object mdfr : mdfrs){
			modifires.add(mdfr.toString());
		}
		
		
		this.fieldDecls.add(new FieldDecl(type, names.toArray(new String[names.size()]), 
				modifires.toArray(new String[modifires.size()]), r.getLeft(), r.getRight()));
		
		return false;
	}
	
	protected Pair<Integer, Integer> getLineRange(ASTNode n){
		int sl = this.source.getLineNumber(n.getStartPosition());
		int el = this.source.getLineNumber(n.getStartPosition() + n.getLength());
		
		return Pair.of(sl, el);
		
	}
}


