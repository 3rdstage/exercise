/**
 * 
 */
package thirdstage.exercise.gc.case1;

import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 3rdstage
 *
 */
public class BigIntegerCache2 {
	
	public static final int CACHE_INITIAL_SIZE = 30000;

	private static volatile WeakReference<BigIntegerCache2> singleton;
	
	static{
		singleton = new WeakReference(new BigIntegerCache2());
	}

	public static BigIntegerCache2 getInstance(){
		BigIntegerCache2 cache = singleton.get();
		
		//double-checked locking
		if(cache == null){
			synchronized(BigIntegerCache2.class){
				if(cache == null){
					singleton = new WeakReference(new BigIntegerCache2());
				}
			}
		}
		return singleton.get();
	}
	
	private volatile Map<String, BigInteger> cache = new HashMap<String, BigInteger>();
	private final Lock lock = new ReentrantLock();  	
	
	private BigIntegerCache2(){
		for(int i = 0; i < CACHE_INITIAL_SIZE; i++){
			this.cache.put(String.valueOf(i), BigInteger.valueOf(i));
		}
	}
	
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
