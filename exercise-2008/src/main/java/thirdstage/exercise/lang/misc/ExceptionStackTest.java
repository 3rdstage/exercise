/**
 * 
 */
package thirdstage.exercise.lang.misc;

/**
 * This class is made to show the stack trace (especially it's order of elements)
 * of the exception.
 * 
 * @author 3rdstage
 * @since 2010-04-06
 */
public class ExceptionStackTest{

	/**
	 * @param args
	 */
	public static void main(String[] args){
	// TODO Auto-generated method stub

		ExceptionStackTest tester = new ExceptionStackTest();
		
		try{
			tester.fistMethod();
			
		}catch(Exception ex){
			ex.printStackTrace(System.err);
		}
	}
	
	public void fistMethod(){
		this.secondMethod();
	}

	public void secondMethod(){
		this.lastMethod();
	}
	
	public void lastMethod(){
		int n = 100;
		int m = 0;
		double r = n/m;
	}
	
	
	

}
