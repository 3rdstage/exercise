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
import org.testng.annotations.Test;

public class SimpleTest3 {


	@Test
	public void testFieldDeclAndMethodDecl() throws Exception{
		
		String file = ClassLoader.getSystemResource("thirdstage/meta/jls3/Simple.txt").getPath();
		
		MetaBuilder mb = new MetaBuilder(file);
		
		Unit unit = mb.build();

		System.out.println(unit.toString());

		System.out.println("Strike the enter key to end this program : ");
		while(System.in.available() < 1){ Thread.currentThread().sleep(500); }
		System.out.println("End of program");

	}

}
