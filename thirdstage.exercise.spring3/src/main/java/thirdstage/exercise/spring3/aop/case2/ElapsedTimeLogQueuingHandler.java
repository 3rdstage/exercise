package thirdstage.exercise.spring3.aop.case2;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Required;

public class ElapsedTimeLogQueuingHandler implements ElapsedTimeLogHandler {
	
	private BlockingQueue<ElapsedTimeLogValue> logQueue = null;
	
	@Required
	public void setLogQueue(BlockingQueue<ElapsedTimeLogValue> q){ this.logQueue = q; }
	 

	@Override
	public void handleLog(String[] context, long startMilli, long endMilli) {
		
		this.logQueue.offer(new ElapsedTimeLogValue(context, startMilli, endMilli));
	}

}
