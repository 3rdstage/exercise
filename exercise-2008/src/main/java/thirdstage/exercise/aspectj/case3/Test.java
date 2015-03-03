/**
 * 
 */
package thirdstage.exercise.aspectj.case3;

import thirdstage.exercise.aspectj.case3.MessageCommunicator;

/**
 * @author 3rdstage
 *
 */
public class Test{

	
	public static void main(String[] args){
		MessageCommunicator testee = new MessageCommunicator();
		testee.deliver("Three day long holiday ~");
		testee.deliver("Sangmoon", "Three day long holiday");
	}
	
}
