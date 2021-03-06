package thirdstage.meta.jls3;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.testng.annotations.Test;

public class SimpleTest {


	@Test
	public void testPackageDeclAndImportDecls() throws Exception{

		String srcStr = FileUtils.readFileToString(
				new File(ClassLoader.getSystemResource("thirdstage/meta/jls3/Simple.txt").toURI()), "utf-8");

		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(srcStr.toCharArray());
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		CompilationUnit cu = (CompilationUnit) parser.createAST(null);

		SimpleVisitor visitor = new SimpleVisitor(cu);
		cu.accept(visitor);
		
		Unit unit = visitor.getResult();

		System.out.println(cu.toString());

		//@SuppressWarnings("unused") Document document = new Document(srcStr);

		System.out.println("Strike the enter key to end this program : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		System.out.println("End of program");

	}
	
	
	public static class SimpleVisitor extends ASTVisitor{
		
		private CompilationUnit source;
		private PackageDecl packageDecl;
		private List<ImportDecl> importDecls = new ArrayList<ImportDecl>();
		
		public SimpleVisitor(CompilationUnit cu){
			this.source = cu;
		}
		
		public Unit getResult(){
			
			return new Unit(this.packageDecl, this.importDecls);
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
	}
}
