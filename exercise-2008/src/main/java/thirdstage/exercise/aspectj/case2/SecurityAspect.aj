/**
 *
 */
package thirdstage.exercise.aspectj.case2;

/**
 * @author 3rdstage
 *
 */
aspect SecurityAspect{
	private Authenticator authenticator = new Authenticator();

	pointcut secureAccess() : execution(* MessageCommunicator.deliver(..));

	before() : secureAccess(){
		System.out.println("Checking and authencating user");
		authenticator.authenticate();
	}

}
