/**
 * 
 */
package thirdstage.exercise.concurrency.case1;

import java.util.concurrent.BlockingQueue;

/**
 * @author 3rdstage
 *
 */
public class Subscriber implements Runnable{
	
	private int no;
	
	private BlockingQueue<Topic> topicQueue; 
	
	public Subscriber(int no, BlockingQueue<Topic> queue){
		this.no = no;
		this.topicQueue = queue;
	}
	
	public int getNo(){ return this.no; }
	
	public BlockingQueue<Topic> getTopicQueue(){ return this.topicQueue; }
	
	
	public void run(){
		
		try{
			while(true){
				Topic topic = this.topicQueue.take();
				System.out.println("Topic " + topic.getName() + " is red by subscriber " + this.no);
			}
		}catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
	}

}
