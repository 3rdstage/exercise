package thirdstage.exercise.lang.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap에 대해 initial capacity를 변경해 가면서 생성속도를 측정한다.
 * 
 * 
 * @version 1.0, 2008-08-05, Sang-Moon Oh
 * @since 2008-08-05
 * @author 3rdstage
 *
 */
public class HashMapPerformanceTest{

	public static void main(String[] args){

		HashMapPerformanceTest tester = new HashMapPerformanceTest();


/*		int[] initCaps = { -1, 2, 10, 100 };
		float[] loadFactors = { -1.0F, -1.0F, -1.0F, -1.0F };
		long repeats = 100;
		long time = 0;

		for(int j = 0; j < 3; j++){
			for(int i = 0, n = initCaps.length; i < n; i++){
				time = tester.testMapCreationPerformance(initCaps[i], loadFactors[i], repeats);
				System.out.println("Initial Capaicity : " + initCaps[i] + ", Load Factor : " + loadFactors[i] + ", Repeats : " + repeats + " -> " + ((double)time)
						/ 1000000000 + "  sec.");

			}
		}*/

		long time2 = tester.testMapRehashTime(100, 10000, 5);
		System.out.println("Time to rehash the HashMap object with capacity of 10 in 10000 times : " + time2 + " nano sec.");
		
	}

	/**
	 * 
	 * @param initialCapacity should be -1 or non-negative integer
	 * @param loadFactor should be -1.0F or positive number between 0 and 1.0
	 * @param repeats the number of objects to create
	 * @return time interval to create HashMap objects for specified times in nano second.   
	 *
	 */
	private long testMapCreationPerformance(int initialCapacity, float loadFactor, long repeats){

		Map map = null;
		int mode = 0; //inital capacity와 load factor를 모두 명시한 경우 

		if(loadFactor == -1){
			if(initialCapacity == -1.0F){
				mode = 2;
			} //initial capacity와 load factor를 모두 지정하지 않는 경우
			else{
				mode = 1;
			} //initial capacity만 지정하는 경우
		}

		long time = System.nanoTime();

		switch(mode){
			case 0:
				//System.out.println("Case : 0");
				for(long i = 0; i < repeats; i++){
					map = new HashMap(initialCapacity, loadFactor);
				}
				break;
			case 1:
				//System.out.println("Case : 1");
				for(long i = 0; i < repeats; i++){
					map = new HashMap(initialCapacity);
				}
				break;
			default: //when mode == 2
				//System.out.println("Case : 2");
				for(long i = 0; i < repeats; i++){
					map = new HashMap();
				}
				break;
		}

		return System.nanoTime() - time;
	}

	/**
	 * 
	 * @param initCap should be equal or greater than 2
	 * @param repeats
	 * @return difference of time
	 */
	private long testMapRehashTime(int initCap, int repeats, int iterations){

		Map map = null;
		String str = "Test HashMap";
		String[] keys = new String[initCap + iterations*2 + 10];
		for(int i = 0; i < initCap + 10; i++){
			keys[i] = new Integer(i).toString();
		}
		

		long[] time1s = new long[iterations];
		long[] time2s = new long[iterations];
		int flag = 0;
		int iteration1 = 0;
		int iteration2 = 0;
		long totalTime1 = 0;
		long totalTime2 = 0;

		for(int k = 0; k < iterations * 2; k++){
			flag = k % 2;
			map = new HashMap(initCap + k, 1.0F);

			switch(flag){

				case 0:
					System.out.println("Case : 0, Iteration : " + iteration1);

					time1s[iteration1] = System.nanoTime();
					for(int i = 0; i < repeats; i++){
						//map = new HashMap(initCap, 1.0F);
						for(int j = 0, m = initCap + k - 2; j < m; j++){
							map.put(keys[j], str);
						}
					}
					time1s[iteration1] = System.nanoTime() - time1s[iteration1];
					iteration1++;

					break;

				default: //when flag == 1
					System.out.println("Case : 1, Iteration : " + iteration2);

					time2s[iteration2] = System.nanoTime();

					for(int i = 0; i < repeats; i++){
						//map = new HashMap(initCap, 1.0F);
						for(int j = 0, m = initCap + k + 2; j < m; j++){
							map.put(keys[j], str);
						}
					}
					time2s[iteration2] = System.nanoTime() - time2s[iteration2];
					iteration2++;

			}
		}

		//test output
		if(true){
			for(int i = 0; i < iterations; i++){
				System.out.println("Less than Capacity : " + time1s[i] + " nano sec., More than Capacity : " 
						+ time2s[i] + " nano sec., Diff : " + (time2s[i] - time1s[i]));
			}
		}
	
		for(int i = 0; i < iterations; i++){
			totalTime1 += time1s[i];
			totalTime2 += time2s[i];
		}
		
		System.out.println("Total time 1 : " + totalTime1 + ", Total time 2 : " + totalTime2);
		
		return (totalTime2 - totalTime1);
	}
}
