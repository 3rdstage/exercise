package thirdstage.exercise.eclipse.jsdt.case1;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.eclipse.wst.jsdt.core.dom.AST;
import org.eclipse.wst.jsdt.core.dom.ASTParser;
import org.eclipse.wst.jsdt.core.dom.JavaScriptUnit;
import org.testng.annotations.Test;

public class JavaScriptParsingTest01 {
	
	@Test
	public void testParsing01() throws Exception{
		
		URL url = ClassLoader.getSystemResource("thirdstage/exercise/eclipse/jsdt/case1/simple-script-01.js");
		File f = new File(url.toURI());
		String str = FileUtils.readFileToString(f);
		char[] srcChars = str.toCharArray();
		
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(srcChars);
		JavaScriptUnit result = (JavaScriptUnit) parser.createAST(null);
	}
	

}
