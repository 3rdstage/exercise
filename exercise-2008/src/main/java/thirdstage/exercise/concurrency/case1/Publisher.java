/**
 * 
 */
package thirdstage.exercise.concurrency.case1;

import java.util.concurrent.BlockingQueue;

/**
 * @author 3rdstage
 *
 */
public class Publisher implements Runnable {
	
	private int no;
	
	private BlockingQueue<Topic> topicQueue; 

	public Publisher(int no, BlockingQueue<Topic> queue){
		this.no = no;
		this.topicQueue = queue; 
	}
	
	public int getNo(){ return this.no; }
	
	public BlockingQueue<Topic> getTopicQueue(){ return this.topicQueue; }
	
	public void run(){
		
		for(int i = 0; i < 10; i++){
			
			try{
				this.topicQueue.put(new Topic("" + this.no + "-" + i));
				System.out.println("Topic " + this.no + "-" + i + " is published");
			}catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			
		}
	}
}
