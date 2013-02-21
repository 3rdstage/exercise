/**
 * 
 */
package thirdstage.exercise.lang.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 3rdstage
 *
 */
public class ClassNameTest{
	
	
	public static void main(String[] args){

		System.out.println("The class name for long primitive : " + long.class.getName());
		System.out.println("The class name for int primitive : " + int.class.getName());
		System.out.println("The class name for short primitive : " + short.class.getName());
		System.out.println("The class name for char primitive : " + char.class.getName());
		System.out.println("The class name for boolean primitive : " + boolean.class.getName());
		System.out.println("The class name for double primitive : " + double.class.getName());
		System.out.println("The class name for float primitive : " + float.class.getName());
		//System.out.println("The class name for null : " + null.class.getName()); //compile-time error
		
		Thread th1 = new Thread();
		System.out.println("The class name for Thread object : " + th1.getClass().getName());
		
		Double rate = 0.9;
		System.out.println("The class name for Double object : " + rate.getClass().getName());
		
		Map codes = new HashMap(10, 1.0f);
		System.out.println("The class name for HashMap object with Map type : " + codes.getClass().getName());
		
		Map<String, Integer> index = new HashMap<String, Integer>(100, 1.0f);
		System.out.println("The class name for HashMap<String, Integer> object : " + index.getClass().getName());
		
		List<String> names = new ArrayList<String>(100);
		System.out.println("The class name for ArrayList<String> object : " + names.getClass().getName());
		
		Double[] rates = new Double[20];
		System.out.println("The class name for Double[] object : " + rates.getClass().getName());
		
		Float[][] matrix = new Float[5][20];
		System.out.println("The class name for Float[][] object : " + matrix.getClass().getName());
		
		boolean[] flags = new boolean[20];
		System.out.println("The class name for boolean[] object : " + flags.getClass().getName());
		
		int[][] table = new int[10][10];
		System.out.println("The class name for int[][] object : " + table.getClass().getName());
		
	}

}
