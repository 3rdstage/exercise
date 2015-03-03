/**
 * 
 */
package thirdstage.exercise.lang.misc;

/**
 * @author 3rdstage
 *
 */
public class NumberTest3 {
	
	
	public static void main(String... args){
		
		NumberTest3 testee = new NumberTest3();
		
		testee.testSimplestFloatOperation();
		testee.testSimpleDoubleAddition();	
		testee.testCorrectedSimpleDoubleAddition();
	}
	
	
	public void testSimplestFloatOperation(){
		
		float f1 = 1000000.00f;
		float f2 = 0.1f;
		
		System.out.println();
		System.out.print("The addition of two float number 1,000,000.00 and 0.1 gives : ");
		System.out.println(f1 + f2);
		
	
		float f3 = 5000000.02F;
		float f4 = 5000000.01F;
		
		System.out.println();
		System.out.print("The subtraction of two float number 5,000,000.02 and 5,000,000.01 gives : ");
		System.out.println(f3 - f4);
		
		
		double d3 = 5000000.02D;
		double d4 = 5000000.01D;
		
		System.out.println();
		System.out.print("The subtraction of two double number 5,000,000.02 and 5,000,000.01 gives : ");
		System.out.println(d3 - d4);

	}
	
	
	public void testSimpleDoubleAddition(){
		
		double[] nums = new double[10];
		for(int i = 0, n = nums.length; i < n; i++) nums[i] = 0.1;
		double sum = 0.00;
		
		System.out.println();
		System.out.println("Loop 10 turns adding in each number and printing the summation of in each turn : ");
		for(int i = 0, n = nums.length; i < n; i++){
			sum += nums[i];
			System.out.println(sum);
		}
		System.out.println("The 10 time of double typed 0.1 becomes : " + sum);
	}

	public void testCorrectedSimpleDoubleAddition(){
		
		double[] nums = new double[10];
		for(int i = 0, n = nums.length; i < n; i++) nums[i] = 0.1;
		double sum = 0.00;
		
		System.out.println();
		System.out.println("Loop 10 turns adding in 10 times of each number and printing the summation of in each turn : ");
		for(int i = 0, n = nums.length; i < n; i++){
			sum += nums[i]*10;
			System.out.println(sum);
		}
		System.out.println("The 10 time of double typed 0.1 becomes : " + sum/10);
	}
	
	
}
