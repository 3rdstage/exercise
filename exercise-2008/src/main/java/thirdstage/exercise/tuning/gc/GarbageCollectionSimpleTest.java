package thirdstage.exercise.tuning.gc;

/**
 * Test program from the book "Java Performance Tuning, 2nd Edition" by
 * Jack Shirazi
 * 
 * Run this program with VM option of "-XX:+PrintGCDetails" in JDK 1.4
 * or higher.
 */
import java.util.Vector;

public class GarbageCollectionSimpleTest{
	
	public static void main(String[] args) throws Exception{
		
		int size = 40000;
		StringBuffer s;
		Vector v;
		
		for(int i = 0; i < size; i++){
			s = new StringBuffer(50);
			v = new Vector(30);
			s.append(i).append(i + 1).append(i + 2).append(i + 3);
		}
		
		s = null;
		v = null;
		System.out.println("Starting explicit garbage collection");
		long time = System.nanoTime();
		System.gc();
		System.out.println("Garbage collection took " + (System.nanoTime() - time) + " nano seconds");
		
		int[] arr = new int[size*10];
		time = System.nanoTime();
		if(false) Thread.currentThread().sleep(100);
		arr = null;
		System.out.println("Starting explicit garbage collection");
		
		System.gc();
		System.out.println("Garbage collection took " + (System.nanoTime() - time) + " nano seconds");
	}
	
}
