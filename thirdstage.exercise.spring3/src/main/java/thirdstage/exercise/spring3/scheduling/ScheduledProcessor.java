package thirdstage.exercise.spring3.scheduling;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@ManagedResource(
		objectName=":type=bean,name=scheduledProcessor",
		description="Sample Scheduled Processor"
	)
@Service("sampleScheduledProcessor")
public class ScheduledProcessor {

	private final AtomicInteger counter = new AtomicInteger(1);

	@ManagedAttribute
	public int getCount(){
		return this.counter.get();
	}

	private final Queue<Date> processHistory = new ArrayDeque<Date>(10);

	@ManagedAttribute
	public Queue<Date> getProcessHistory(){ return this.processHistory; }

	private AsyncWorker worker;

	@Resource(name="sampleAsyncWorker")
	public void setAsyncWorker(AsyncWorker worker){
		this.worker = worker;
	}

	@Scheduled(fixedDelayString="${processor.schedule.fixedDelay}",
		initialDelayString="${processor.schedule.initialDelay}")
	public void process(){
		System.out.printf("Starting 10 async process at %1$tF %1$tT \n", new java.util.Date());

		for(int i = 0; i < 10; i++){
			this.worker.work("process" + i);
		}
		this.processHistory.add(new Date());
		this.counter.incrementAndGet();
	}


}
