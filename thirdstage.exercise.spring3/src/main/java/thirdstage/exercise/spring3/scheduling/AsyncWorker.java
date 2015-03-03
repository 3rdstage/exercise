package thirdstage.exercise.spring3.scheduling;

import java.io.PrintStream;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("sampleAsyncWorker")
public class AsyncWorker {
	
	@Async
	public void work(String name){
		
		String threadName = Thread.currentThread().getName();
		
		for(int i = 0; i < 10; i++){
			//System.out.printf("Thead \n");
			System.out.printf("Thead : %1$-30s, Worker : %2$s, Step : %3$s of 10 \n", threadName, name, i);
			try{
				Thread.sleep(5000);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
		}
	}

}
