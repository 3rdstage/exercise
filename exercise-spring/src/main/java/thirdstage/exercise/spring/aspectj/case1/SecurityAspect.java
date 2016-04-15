/**
 * 
 */
package thirdstage.exercise.spring.aspectj.case1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import thirdstage.exercise.spring.aspectj.case1.Authenticator;

/**
 * This is the same code with the one from the book of 
 * "AspectJ in Action 2nd Edition" except the package name.
 * 
 * @author 3rdstage
 * @since 2010-02-26
 */
@Aspect
public class SecurityAspect{

	private Authenticator authenticator = new Authenticator();
	
	@Pointcut("execution(* thirdstage.exercise.spring.aspectj.case1.MessageCommunicator.deliver(..))")
	public void secureAccess(){}
	
	@Before("secureAccess()")
	public void secure(){
		System.out.println("Checking and authenticating user");
		this.authenticator.authenticate();
	}
	
	
}
