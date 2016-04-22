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
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.Type;
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
		cu.accept(vst);
		
		return vst.getResult();
	}
	
}

class Visitor extends ASTVisitor{
	
	//@todo Using array instead of collection for imports, fields, methods.
	//the size can be identified in constructor
	private CompilationUnit source;
	private PackageDecl packageDecl;
	private List<ImportDecl> importDecls = new ArrayList<ImportDecl>();
	private List<FieldDecl> fieldDecls = new ArrayList<FieldDecl>();
	private List<MethodDecl> methodDecls = new ArrayList<MethodDecl>();
	
	public Visitor(CompilationUnit cu){
		this.source = cu;
	}
	
	public Unit getResult(){
		
		return new ClassUnit(this.packageDecl, this.importDecls, 
				fieldDecls.toArray(new FieldDecl[fieldDecls.size()]), 
				methodDecls.toArray(new MethodDecl[methodDecls.size()]));
	}

	public boolean visit(PackageDeclaration pd){
		int start = pd.getStartPosition();
		int end = start + pd.getLength();
		int startLine = this.source.getLineNumber(start);
		int endLine = this.source.getLineNumber(end);
		
		this.packageDecl = new PackageDecl(this.getNameOfName(pd.getName()), startLine, endLine);
		
		return true;
	}
	
	public boolean visit(ImportDeclaration id){
		int sl = this.source.getLineNumber(id.getStartPosition());
		int el = this.source.getLineNumber(id.getStartPosition() + id.getLength());
		
		this.importDecls.add(new ImportDecl(id.isStatic(), 
				id.isOnDemand(), this.getNameOfName(id.getName()), sl, el));
		return true;
	}
	
	public boolean visit(FieldDeclaration fd){
		Pair<Integer, Integer> r = this.getLineRange(fd);
		
		String type = this.getNameOfType(fd.getType());
		String[] modifiers = this.getNamesOfModifiers(fd.modifiers());

		List<VariableDeclarationFragment> frgmts = fd.fragments();
		List<String> names = new ArrayList<String>();
		for(VariableDeclarationFragment frgmt : frgmts){
			this.fieldDecls.add(new FieldDecl(type, modifiers, 
					this.getNameOfName(frgmt.getName()), r.getLeft(), r.getRight()));
		}
		
		return false;
	}
	
	public boolean visit(MethodDeclaration md){
		Pair<Integer, Integer> r = this.getLineRange(md);
		
		String rType = this.getNameOfType(md.getReturnType2());
		String[] mdfrs = this.getNamesOfModifiers(md.modifiers());
		
		this.methodDecls.add(new MethodDecl(rType, mdfrs,
				this.getNameOfName(md.getName()), r.getLeft(), r.getRight()));
		return true;
		
	}
	
	protected Pair<Integer, Integer> getLineRange(ASTNode n){
		int sl = this.source.getLineNumber(n.getStartPosition());
		int el = this.source.getLineNumber(n.getStartPosition() + n.getLength());
		
		return Pair.of(sl, el);
		
	}
	
	protected String getNameOfName(Name n){
		return (n != null) ? n.toString() : "";
	}

	protected String getNameOfType(Type t){
		return (t != null) ? t.toString() : "";
	}
	
	protected String[] getNamesOfModifiers(List<Modifier> modifiers){
		if(modifiers == null) return new String[0];
		
		String[] names = new String[modifiers.size()];
		for(int i = 0, n = names.length; i < n; i++){
			names[i] = modifiers.get(i).toString();
		}
		
		return names;
	}
	
}


