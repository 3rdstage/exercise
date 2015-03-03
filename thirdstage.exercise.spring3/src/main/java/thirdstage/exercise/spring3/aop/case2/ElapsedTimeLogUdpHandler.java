package thirdstage.exercise.spring3.aop.case2;

import java.util.Map;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.integration.support.MessageBuilder;

public class ElapsedTimeLogUdpHandler implements ElapsedTimeLogHandler {
	
	public static final String DEFAULT_SEPARATOR = ",";
	
	private String separator = DEFAULT_SEPARATOR;
	
	private MessageChannel channel = null;
	
	@Required
	public void setMessageChannel(MessageChannel channel){
		this.channel = channel;
	}
	
	public void setSeparator(String str){
		this.separator = str;
	}
	
	@Override
	public void handleLog(String[] context, long startMilli, long endMilli) {
		StringBuilder sb = new StringBuilder();
		for(String str : context) sb.append(str).append(this.separator);
		sb.append(startMilli).append(this.separator).append(endMilli - startMilli);
		Message<byte[]> msg = MessageBuilder.withPayload(sb.toString().getBytes()).build();
		
		this.channel.send(msg);
	}

}
