package thirdstage.meta.jls3;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
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
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jface.text.Document;
import org.testng.annotations.Test;

public class SimpleTest2 {


	@Test
	public void testFieldDeclAndMethodDecl() throws Exception{

		String srcStr = FileUtils.readFileToString(
				new File(ClassLoader.getSystemResource("thirdstage/meta/jls3/Simple.txt").toURI()), "utf-8");

		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(srcStr.toCharArray());
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		CompilationUnit cu = (CompilationUnit) parser.createAST(null);

		SimpleVisitor2 visitor = new SimpleVisitor2(cu);
		cu.accept(visitor);
		
		Unit unit = visitor.getResult();

		System.out.println(cu.toString());

		@SuppressWarnings("unused") Document document = new Document(srcStr);

		System.out.println("Strike the enter key to end this program : ");
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//br.readLine();
		
		while(System.in.available() < 1){ Thread.currentThread().sleep(500); }
		System.out.println("End of program");

	}
	
	
	public static class SimpleVisitor2 extends ASTVisitor{
		
		private CompilationUnit source;
		private PackageDecl packageDecl;
		private List<ImportDecl> importDecls = new ArrayList<ImportDecl>();
		private List<FieldDecl> fieldDecls = new ArrayList<FieldDecl>();
		
		public SimpleVisitor2(CompilationUnit cu){
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

			List<String> mdfrs = new ArrayList<String>();
			for(Object mdfr : fd.modifiers()){
				mdfrs.add(mdfr.toString());
			}
			String[] modifiers = mdfrs.toArray(new String[mdfrs.size()]);

			List<VariableDeclarationFragment> frgmts = fd.fragments();
			List<String> names = new ArrayList<String>();
			for(VariableDeclarationFragment frgmt : frgmts){
				this.fieldDecls.add(new FieldDecl(type, modifiers, 
						frgmt.getName().toString(), r.getLeft(), r.getRight()));
			}
			
			return false;
		}
		
		protected Pair<Integer, Integer> getLineRange(ASTNode n){
			int sl = this.source.getLineNumber(n.getStartPosition());
			int el = this.source.getLineNumber(n.getStartPosition() + n.getLength());
			
			return Pair.of(sl, el);
			
		}
	}
}
