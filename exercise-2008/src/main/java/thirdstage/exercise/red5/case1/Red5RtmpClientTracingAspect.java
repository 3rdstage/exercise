/**
 *
 */
package thirdstage.exercise.red5.case1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * @author 3rdstage
 *
 */
@Aspect
public class Red5RtmpClientTracingAspect {

	private transient final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("call(public * org.red5.client.net.rtmp.RTMPMinaIoHandler.messageReceived(..))")
	public void beforeMinaIoHandlerCall(){
		logger.debug("Before messageReceived call");
	}

	@Before("execution(public * org.red5.client.net.rtmp.RTMPMinaIoHandler.messageReceived(..))")
	public void beforeMinaIoHandlerExec(){
		logger.debug("Before messageReceived exectuion");
	}
}
