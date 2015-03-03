package thirdstage.exercise.misc;

import java.util.Arrays;
import java.util.List;

public class GenericsSubtypingExercise{

	/**
	 * @param args
	 */
	public static void main(String[] args){

		GenericsSubtypingExercise exr = new GenericsSubtypingExercise();
		exr.test1();
		
	}

	public void test1(){
		
		List<Object> objs = Arrays.<Object>asList(1, 2);
		List<Integer> ints = Arrays.<Integer>asList(3, 4);
		
		System.out.println("Before copy target is : " + objs.toString());
		System.out.println("Before copy source is : " + ints.toString());
		
		this.<Integer>copy(objs, ints);
		
		System.out.println("After copy target is : " + objs.toString());
	}
	
	public <T> void copy(List<? super T> destination, List<? extends T> source){
		for(int i = 0, n = source.size(); i < n; i++){
			destination.set(i, source.get(i));
		}
	}
	

	public void test2(){
		
		List<Integer> ints = Arrays.asList(1, 2, 3);
		List<? extends Number> nums = ints;
		ints.add(4);
		//nums.add(5); //compile-time error
		
		Integer[] ints2 = new Integer[]{1, 2, 3};
		Number[] nums2 = ints2;
		nums2[2] = 3.14; //not compile-time error, runtime-error
		
		List<Integer> ints3 = Arrays.asList(1, 2, 3);
		//List<Number> nums3 = ints3; //compile-time error
		
		List<Integer> ints4 = Arrays.asList(1, 2, 3);
		List<?> objs4 = ints4;
		//objs4.add(4); //compile-time error
		objs4.get(2);
	}

	public void test3(){
		
		Object obj = "one";
		List<Object> objs = Arrays.<Object>asList("one", 1, 2, 3.14);
		List<Integer> ints = Arrays.<Integer>asList(1, 2);
		
		if(objs.contains(obj)) System.out.println("okay");
		if(objs.containsAll(ints)) System.out.println("okay");
		if(ints.contains(obj)) System.out.println("wow~"); //no compile/run time error
		if(ints.containsAll(objs)) System.out.println("wow~"); //no compile/run time error
	}
}
