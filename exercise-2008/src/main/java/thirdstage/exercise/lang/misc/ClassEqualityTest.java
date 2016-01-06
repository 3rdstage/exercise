package thirdstage.exercise.lang.misc;

public class ClassEqualityTest{
	
	
	public void test1(){
		
		Class clazz1 = java.util.StringTokenizer.class;
		Class clazz2 = java.util.StringTokenizer.class;
		
		boolean equality = clazz1.equals(clazz2);
		
		System.out.println("Class object of the same type is equal : " + equality);
	
	}

	
	public static void main(String[] args){
		
		ClassEqualityTest tester = new ClassEqualityTest();
		
		tester.test1();
	}
}
