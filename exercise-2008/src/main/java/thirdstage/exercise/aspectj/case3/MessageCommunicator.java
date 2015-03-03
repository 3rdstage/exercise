/**
 * 
 */
package thirdstage.exercise.aspectj.case3;

/**
 * This is almost the same class with the one from the book of 
 * "AspectJ in Action 2nd Edition" except the package name.
 * 
 * @author 3rdstage
 * @since 2010-02-26
 */
public class MessageCommunicator{
	public void deliver(String message) {
		System.out.println("Hi, " + message);
	}
	
	public void deliver(String person, String message) {
		System.out.println("Hi " + person + ", " + message);
	}
}
