/*
 * InlineMe.java
 *
 * Created on 2005-10-07
 *
 * This class is for testing automatic VM inlining with HPROF from the book 
 * 'Advanced Java Programming' chapter 8.
 */

package thirdstage.exercise.hprof;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-10-07
 * @since 2005-10-07
 */
public class InlineMe {
	
	int counter = 0;
	
	public void  method1(boolean showsInlining){
		for(int i= 0; i < 1000; i++){
			if(showsInlining){ addCount1(); }
			else{ addCount2(); }
			System.out.println("counter = " + counter);
		}
	}
	
	public int addCount1(){
		counter++;
		return counter;
	}
	
	public void addCount2(){
		counter++;
	}
	
	public static void main(String args[]){
		
		if(args.length != 1){
			System.out.println("Usage : ");
			System.out.println(">java InlineMe inline");
			System.out.println("or");
			System.out.println(">java InlineMe noinline");
		}
		else{
			InlineMe im = new InlineMe();
			
			if("inline".equals(args[0].trim())){ im.method1(true); }
			else{ im.method1(false);}
			
		}
	}
	
}
