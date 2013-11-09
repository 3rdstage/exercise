package thirdstage.exercise.annotation.set1;

import java.lang.annotation.Annotation;
/**
 *
 * @author 3rdstage
 * @version 0.8, 2007-09-03, 3rdstage
 * @since 2007-09-03
 */
public class AnnotationExtractionTester1 {
	
	/** Creates a new instance of AnnotationExtractionTester1 */
	public AnnotationExtractionTester1() {
	}
	
	
	public static void main(String[] args){
		
		try{
			Class annotatedClass = Class.forName("thirdstage.exercise.annotation.set1.OrderManager");
			Class annotationClass = Class.forName("thirdstage.exercise.annotation.set1.Controller");
			
			Controller ann = (Controller)annotatedClass.getAnnotation(thirdstage.exercise.annotation.set1.Controller.class);
			
			Process[] processes = ann.processes();
			
			System.out.println("Processes for " + annotatedClass.getSimpleName() + " : total num = " + processes.length);
			
			for(Process process : processes){
				System.out.println("   process with ID = " + process.id());
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace(System.err);
		}
		
		
	}
	
}
