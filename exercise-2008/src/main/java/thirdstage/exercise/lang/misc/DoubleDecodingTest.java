/**
 * 
 */
package thirdstage.exercise.lang.misc;

/**
 * @author 3rdstage
 *
 */
public class DoubleDecodingTest {
	
	
	public static void main(String[] args) throws Exception{
	
		DoubleDecodingTest testee = new DoubleDecodingTest();
		testee.test1();
		
	}
	
	
	private void test1() throws Exception{
		
		double d1 = 1.111;
		
		byte[] b1 = String.valueOf(d1).getBytes("EUC-KR");
		
		System.out.println("Bytes for double 1.11 are : ");
		for(int i = 0, n = b1.length; i < n; i++){
			System.out.print(b1[i]);
		}
		System.out.println("\n");
		
		
		String s1 = new String(b1, "EUC-KR");
		System.out.println("String from the bytes is : " + s1);
		
		
		
	}

	
	
}
