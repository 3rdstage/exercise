package thirdstage.exercise.tuning.profile;

import java.util.Hashtable;

/**
 * Test program from the book "Java Performance Tuning, 2nd Edition" by
 * Jack Shirazi
 * 
 * Run this program with VM option of "-Xrunhprof:cpu=samples,thread=y" 
 * in JDK 1.3 or higher.
 * Note that with profiling, this program may run more than 10 seconds.
 * 
*/
public class ProfileTest{
	
	public static void main(String[] args){
		
		int repeat = 2000;
		
		double[] ds = {Double.MAX_VALUE, -3.14e-200d, 
				Double.NEGATIVE_INFINITY, 567.89023d, 
				123e199d, -0.000456d, -1.234d, 1e55d};
		long[] ls = {2283911683699007717l, -800760872066909262l,
				4536503365853551745l, 548519563869l, 45l,
				Long.MAX_VALUE, 1l, -9999l, 7661314123l, 0l};

		long time;
		StringBuffer s = new StringBuffer();
		Hashtable h = new Hashtable();
		System.out.println("Starting test");
		time = System.nanoTime();
		
		for(int i = 0; i < repeat; i++){
			s.setLength(0);
			
			for(int j = ds.length - 1; j >= 0; j--){
				s.append(ds[j]);
				h.put(new Double(ds[j]), Boolean.TRUE);
			}
			
			for(int j = ls.length - 1; j >= 0; j-- ){
				s.append(ls[j]);
				h.put(new Long(ls[j]), Boolean.FALSE);
			}
		}
		
		time = System.nanoTime() - time;
		System.out.println("End test. The test took " + time + " nano seconds.");
		
	}

}
