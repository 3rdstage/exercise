package thirdstage.exercise.spring3.scheduling;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("sampleScheduledProcessor")
public class ScheduledProcessor {
	
	private final AtomicInteger counter = new AtomicInteger();
	
	private AsyncWorker worker;
	
	@Resource(name="sampleAsyncWorker")
	public void setAsyncWorker(AsyncWorker worker){
		this.worker = worker;
	}
	
	@Scheduled(fixedDelay=30000)
	public void process(){
		System.out.printf("Starting 10 async process at %1$tF %1$tT \n", new java.util.Date());
		
		for(int i = 0; i < 10; i++){
			this.worker.work("process" + i);
		}
	}
	
	
}
