package thirdstage.exercise.spring3.aop.case2;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;


public class LogServer {

	@ServiceActivator
	public void receiveLog(Message<?> msg){
		
		System.out.println(new String((byte[])msg.getPayload()));
	}
}
