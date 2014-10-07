/**
 * 
 */
package thirdstage.exercise.gc.case1;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 3rdstage
 *
 */
public class BigIntegerCache1 {
	
	public static final int CACHE_INITIAL_SIZE = 30000;
	private static volatile Map<String, BigInteger> cache = new HashMap<String, BigInteger>();
	private static final Lock lock = new ReentrantLock();  
	
	static{
		for(int i = 0; i < CACHE_INITIAL_SIZE; i++){
			cache.put(String.valueOf(i), BigInteger.valueOf(i));
		}
	}
	
	public BigIntegerCache1(){}
	
	public BigInteger getBigInteger(int i){
		BigInteger val = cache.get(String.valueOf(i));
		
		if(val == null){
			lock.lock();
			try{
				val = cache.get(String.valueOf(i));
				if(val == null){
					val = BigInteger.valueOf(i);
					cache.put(String.valueOf(i), val);
				}
			}finally{ lock.unlock(); }
		} 
		return val;
	}

	public int getSize(){ return cache.size(); }
}
