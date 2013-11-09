/*
 * MemoryLeak.java
 *
 * Created on 2005-09-01 12:22
 *
 * Causes memory leakage intentionally. This class is a simple test class for profiler and
 * based on sample class presented at chapter 5 of the book 'Java Doctor' from 
 * Mannning Publications
 */ 

package thirdstage.exercise.profiler;

import java.util.*;
/**
 * Causes memory leakage intentionally. This class is a simple test class for profiler and
 * based on sample class presented at chapter 5 of the book 'Java Doctor' from 
 * Mannning Publications.
 *
 * @author Sang-Moon Oh
 * @version 1.0, 2005-09-01, Sang-Moon Oh
 * @since 2005-09-01
 */
public class MemoryLeak {
	
	public static int MAX_ITR = 7000000;
	public static int STR_SIZE = 100;
	protected static List col= new ArrayList();
	
	
	/** Creates a new instance of MemoryLeak */
	public MemoryLeak() {
	}
	
	public static void main(String[] args) throws Exception{
		StringBuffer sb = null;
		
		System.out.println("At startup, the free memeory of JVM : " + Runtime.getRuntime().freeMemory() + " Bytes");
		for(int i = 0; i < MAX_ITR; i++){
			
			sb = new StringBuffer(STR_SIZE);
			if(i%100 == 0){
				col.add(sb);
				sb.append("abc");
				sb = null;
				
				Thread.currentThread().sleep(10);
				
				System.out.println("" + (i/100) + "/70000 is processed");
			}
			
			//if(i%10000 == 0) col.clear();
		}
		
		System.out.println("All is finished");
		System.out.println("At the end, the free memeory of JVM : " + Runtime.getRuntime().freeMemory() + " Bytes");
		
		
		
	}
	
}
