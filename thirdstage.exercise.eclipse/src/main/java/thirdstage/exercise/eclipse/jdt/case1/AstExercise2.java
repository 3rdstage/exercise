package thirdstage.exercise.eclipse.jdt.case1;

import java.io.File;

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
			new File(ClassLoader.getSystemResource("thirdstage/exercise/eclipse/jdt/case1/HellowWorld.txt").toURI()), "utf-8");
		
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(srcStr.toCharArray());
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		CompilationUnit unit = (CompilationUnit) parser.createAST(null);
		
		System.out.println(unit.toString());
		
		@SuppressWarnings("unused") Document document = new Document(srcStr);
		
		
	}

}
