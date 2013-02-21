/**
 * 
 */
package thirdstage.exercise.concurrency.case1;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 3rdstage
 *
 */
public class PublishAndSubscribe {
	
	
	
	public static void main(String [] args){
		
		BlockingQueue<Topic> topicQueue = new LinkedBlockingQueue<Topic>(10);
		
		Set<Publisher> publishers = new HashSet<Publisher>();
		Set<Subscriber> subscribers = new HashSet<Subscriber>();
		
		for(int i = 0; i < 10; i++){
			publishers.add(new Publisher(i, topicQueue));
			
		}
		
		for(int i = 0; i < 5; i++){
			subscribers.add(new Subscriber(i, topicQueue));
		}
		
		for(Publisher publisher: publishers){
			(new Thread(publisher)).start();
		}
		
		for(Subscriber subscriber: subscribers){
			(new Thread(subscriber)).start();
		}
		
		
		
	}
	

}
