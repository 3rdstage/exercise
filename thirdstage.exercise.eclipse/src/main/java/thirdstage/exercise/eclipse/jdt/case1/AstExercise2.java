package thirdstage.exercise.eclipse.jdt.case1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

import javax.management.ObjectName;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;


/*
 * The sample from the article "YAAT – Yet another AST tutorial":http://sahits.ch/blog/?p=228
 */

public class AstExercise2{
	
	
	public static void main(String... arg) throws Exception{
		String srcStr = FileUtils.readFileToString(
			new File(ClassLoader.getSystemResource("thirdstage/exercise/eclipse/jdt/case1/HelloWorld.txt").toURI()), "utf-8");
		
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(srcStr.toCharArray());
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		CompilationUnit unit = (CompilationUnit) parser.createAST(null);

		//Impossible !!
		//ManagementFactory.getPlatformMBeanServer().registerMBean(unit, new ObjectName("thirdstage:type=ast,name=HelloWorld"));
		
		SimpleVisitor visitor = new SimpleVisitor();
		unit.accept(visitor);
		
		System.out.println(unit.toString());
		
		//@SuppressWarnings("unused") Document document = new Document(srcStr);
		
		System.out.println("Strike the enter key to end this program : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		System.out.println("End of program");
		
	}
	
	public static class SimpleVisitor extends ASTVisitor{
		private List<MethodDeclaration> methodDecls = new ArrayList<MethodDeclaration>();
		
		private List<MethodInvocation> methodInvocs = new ArrayList<MethodInvocation>();
		
		public List<MethodDeclaration> getMethodDeclarations(){
			return this.methodDecls;
		}
		
		public List<MethodInvocation> getMethodInvocations(){
			return this.methodInvocs;
		}

		public boolean visit(MethodDeclaration md){
			this.methodDecls.add(md);
			return true;
		}
		
		public boolean visit(MethodInvocation mi){
			this.methodInvocs.add(mi);
			return true;
		}
	}
}



