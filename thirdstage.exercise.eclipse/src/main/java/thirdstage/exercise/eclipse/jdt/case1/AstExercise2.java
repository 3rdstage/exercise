package thirdstage.exercise.eclipse.jdt.case1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

import javax.management.ObjectName;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.text.Document;


/*
 * The sample from the article "YAAT – Yet another AST tutorial":http://sahits.ch/blog/?p=228
 */

public class AstExercise2 {
	
	public static void main(String... arg) throws Exception{
		String srcStr = FileUtils.readFileToString(
			new File(ClassLoader.getSystemResource("thirdstage/exercise/eclipse/jdt/case1/HelloWorld.txt").toURI()), "utf-8");
		
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(srcStr.toCharArray());
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		CompilationUnit unit = (CompilationUnit) parser.createAST(null);
		
		
		//ManagementFactory.getPlatformMBeanServer().registerMBean(unit, new ObjectName("thirdstage:type=ast,name=HelloWorld"));
		
		System.out.println(unit.toString());
		
		@SuppressWarnings("unused") Document document = new Document(srcStr);
		
		System.out.println("Strike the enter key to end this program : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		System.out.println("End of program");
		
		
		
	}

}
