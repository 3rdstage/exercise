package thirdstage.exercise.spring3.aop.case2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ElapsedTimeLoggerSender {
	
	public static final Integer DEFAULT_THREAD_COUNT = new Integer(10);
	
	private int threadCount = DEFAULT_THREAD_COUNT;
	
	private BlockingQueue<ElapsedTimeLogValue> logQueue = null;
	
	private ThreadPoolTaskExecutor taskExecutor = null;
	
	@Required
	public void setThreadCount(int cnt){ this.threadCount = cnt; }
	
	@Required
	public void setLogQueue(BlockingQueue<ElapsedTimeLogValue> q){ this.logQueue = q; }
	
	@Required
	public void setTaskExecutor(ThreadPoolTaskExecutor executor){ this.taskExecutor = executor; }
	
	
	public void init(){
		
		
	}
	
	private class SenderTask implements Callable{

		@Override
		public Object call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
