/**
 * 
 */
package thirdstage.exercise.annotation.case1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.mirror.declaration.InterfaceDeclaration;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.util.DeclarationVisitors;
import com.sun.mirror.util.SimpleDeclarationVisitor;

/**
 * @author 3rdstage
 * 
 */
public class DumpFactory implements AnnotationProcessorFactory{

	private static final Collection<String> supportedAnnotations 
		= Collections.unmodifiableCollection(Arrays.asList("*"));

	private static final Collection<String> supportedOptions
		= Collections.emptySet();
	
	public Collection<String> supportedAnnotationTypes(){
		return supportedAnnotations;
	}
	
	public Collection<String> supportedOptions(){
		return supportedOptions;
	}
	
	public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds, AnnotationProcessorEnvironment env){
		return new DumpProcessor(env);
	}

	private static class DumpProcessor implements AnnotationProcessor{
		private final AnnotationProcessorEnvironment env;
		
		public DumpProcessor(AnnotationProcessorEnvironment env){
			this.env = env;
		}
		
		public void process(){
			for(TypeDeclaration typeDecl : env.getSpecifiedTypeDeclarations()){
				typeDecl.accept(DeclarationVisitors.getDeclarationScanner(new DumpVisitor(), DeclarationVisitors.NO_OP));
			}
		}
		
	}
	
	private static class DumpVisitor extends SimpleDeclarationVisitor{
		
		public void visitMethodDeclaration(MethodDeclaration d){
			System.out.println("\t" + d.getSimpleName());
		}
		
		public void visitClassDeclaration(ClassDeclaration c){
			System.out.println(c.getQualifiedName());
		}
		
		public void visitInterfaceDeclaration(InterfaceDeclaration i){
			System.out.println(i.getQualifiedName());
		}
		
	}
	
	
}
