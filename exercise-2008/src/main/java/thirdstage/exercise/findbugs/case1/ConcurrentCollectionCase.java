/**
 * 
 */
package thirdstage.exercise.findbugs.case1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

/**
 * @author 3rdstage
 *
 */
public class ConcurrentCollectionCase{
	
	//NOT thread-safe
	@NotThreadSafe
	public static class ScoreManagerThreadUnsafe{
	
		private Map<Team, Integer> scores = new ConcurrentHashMap<Team, Integer>();
	
		public int addScore(@Nonnull Team team, @Min(1L) int s){ 
			int result = s;

			//each of contains, put, get is thread-safe
			//but containsKey + put or containsKey + get + put is NOT thread-safe
			
			if(this.scores.containsKey(team)){
				result = scores.get(team).intValue() +  s;
			}
			scores.put(team, Integer.valueOf(result));
			
			return result;
		}
		
		public void initScore(@Nonnull Team team){
			
			// containsKey + put is NOT thread-safe
			if(this.scores.containsKey(team)){
				scores.put(team, Integer.valueOf(0));
			}
		}
	}
	
	//Thread-safe but NOT efficient cause of double synchronization
	@ThreadSafe
	public static class ScoreManagerSafeButInefficient{
		
		private Map<Team, Integer> scores = new ConcurrentHashMap<Team, Integer>();
		
		//synchronized by this and this.scores - DOUBLE
		public synchronized int addScore(@Nonnull Team team, @Min(1L) int s){
			int result = s;
			
			if(this.scores.containsKey(team)){
				result = scores.get(team).intValue() +  s;
			}
			scores.put(team, Integer.valueOf(result));
			
			return result;
		}

		//synchronized by this and this.scores - DOUBLE
		public void initScore(@Nonnull Team team){

			if(this.scores.containsKey(team)){
				scores.put(team, Integer.valueOf(0));
			}
		}
	}
	
	
	//Thread-safe and EFFICIENT
	@ThreadSafe
	public static class ScoreManagerSafeAndEfficient{
		
		//collection is thread-unsafe one
		private Map<Team, Integer> scores = new HashMap<Team, Integer>();
		
		@GuardedBy("scores")
		public int addScore(@Nonnull Team team, @Min(1L) int s){
			int result = s;
			
			synchronized(this.scores){ //prefer synchronized block over synchronized method
				if(this.scores.containsKey(team)){
					result = scores.get(team).intValue() +  s;
				}
				scores.put(team, Integer.valueOf(result));
			}
			
			return result;
		}

		@GuardedBy("scores")
		public void initScore(@Nonnull Team team){

			synchronized(this.scores){
				if(this.scores.containsKey(team)){
					scores.put(team, Integer.valueOf(0));
				}
			}
		}
	}
	
	
	//Thread-safe and MUCH BETTER efficient
	@ThreadSafe
	public static class ScoreManagerSafeAndMuchEfficient{
		
		//collection is thread-unsafe one
		private Map<Team, Integer> scores = new HashMap<Team, Integer>();
		
		//lock to control synchronization on scores
		private final Lock scoresLock = new ReentrantLock();
		
		@GuardedBy("scoresLock")
		public int addScore(@Nonnull Team team, @Min(1L) int s){
			int result = s;
			
			scoresLock.lock(); //block until the lock is available to current thread.
			try{
				if(this.scores.containsKey(team)){
					result = scores.get(team).intValue() +  s;
				}
				scores.put(team, Integer.valueOf(result));
			}finally{
				scoresLock.unlock();
			}
			
			return result;
		}

		@GuardedBy("scoresLock")
		public void initScore(@Nonnull Team team){

			scoresLock.lock(); //block until the lock is available to current thread.
			try{
				if(this.scores.containsKey(team)){
					scores.put(team, Integer.valueOf(0));
				}
			}finally{
				scoresLock.unlock();
			}
		}
	}
}


class Team{
	
}