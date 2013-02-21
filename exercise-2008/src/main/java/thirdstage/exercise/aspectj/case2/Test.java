/**
 * 
 */
package thirdstage.exercise.aspectj.case2;

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
