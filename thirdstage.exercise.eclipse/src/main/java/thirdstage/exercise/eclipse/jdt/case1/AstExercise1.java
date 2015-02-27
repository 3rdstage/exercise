package thirdstage.exercise.eclipse.jdt.case1;

import java.lang.reflect.Modifier;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class AstExercise1 {
	
	//meaningless, stopped
	
	public static void main(String... arg){
		
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource("".toCharArray());
		CompilationUnit unit = (CompilationUnit) parser.createAST(null);
		unit.recordModifications();
		AST ast = unit.getAST();
		
		PackageDeclaration packageDeclaration = ast.newPackageDeclaration();
		unit.setPackage(packageDeclaration);
		packageDeclaration.setName(ast.newSimpleName("astexplorer"));
		
		VariableDeclarationFragment vdf = ast.newVariableDeclarationFragment();
		vdf.setName(ast.newSimpleName("minSize"));
		FieldDeclaration fd = ast.newFieldDeclaration(vdf);
		fd.setModifiers(Modifier.PRIVATE);
		fd.setType(ast.newSimpleType(ast.newSimpleName("Point")));
		
		
	}

}
