/**
 *
 */
package thirdstage.exercise.red5.case1;

import javax.annotation.Nonnull;

import org.aspectj.lang.JoinPoint.EnclosingStaticPart;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IoSession;
import org.red5.client.net.rtmp.RTMPMinaIoHandler;
import org.red5.server.net.rtmp.message.Packet;

/**
 * @author Sangmoon Oh
 * @since 2015-07-21
 */
@Aspect
public class Red5RtmpClientTracingAspect {

	private transient final Logger logger = LoggerFactory.getLogger(this.getClass());

	public final static Marker AOP_MARKER = MarkerFactory.getMarker("AOP");

	/**
	 * Traces {@code sessionCreated}, {@code sessionOpened}, {@code sessionClosed}
	 * of {@code RTMPMinaIoHandler}.
	 *
	 * @param joinPt
	 * @param enclosingJoinPt
	 * @param sess
	 * @param msg
	 * @see org.red5.client.net.rtmp.RTMPMinaIoHandler#sessionCreated(IoSession)
	 * @see org.red5.client.net.rtmp.RTMPMinaIoHandler#sessionOpened(IoSession)
	 * @see org.red5.client.net.rtmp.RTMPMinaIoHandler#sessionClosed(IoSession)
	 */
	@Before("call(public void org.apache.mina.core.service.IoHandler.message*(..)) && target(org.red5.client.net.rtmp.RTMPMinaIoHandler) && args(sess, msg)")
	public void beforeCallMinaIoHandlerMessageMethods(final StaticPart joinPt,
		final EnclosingStaticPart enclosingJoinPt, IoSession sess, Object msg){
		Pair<String, String> fromTo = this.getFromToMethods(joinPt, enclosingJoinPt);

		String packet = "";
		if(msg instanceof Packet){
			packet = msg.toString();
		}

		logger.debug(AOP_MARKER, "Method Call: {} -> {}, Session ID: {}, Message Type: {}, Packet: {}",
				fromTo.getLeft(), fromTo.getRight(), (sess != null) ? sess.getId() : "",
				(msg != null) ? msg.getClass().getSimpleName() : "null", packet);
	}

	/**
	 * Traces {@code messageReceived} and {@code messageSent} methods of
	 * {@code RTMPMinaIoHandler} class.
	 *
	 * @param joinPt
	 * @param enclosingJoinPt
	 * @param sess
	 * @see org.red5.client.net.rtmp.RTMPMinaIoHandler#messageReceived(IoSession, Object)
	 * @see org.red5.client.net.rtmp.RTMPMinaIoHandler#messageSent(IoSession, Object)
	 */
	@Before("call(public void org.apache.mina.core.service.IoHandler.session*(..)) && target(org.red5.client.net.rtmp.RTMPMinaIoHandler) && args(sess)")
	public void beforeCallMinaIoHandlerSessionMethods(final StaticPart joinPt,
		final EnclosingStaticPart enclosingJoinPt, IoSession sess){
		Pair<String, String> fromTo = this.getFromToMethods(joinPt, enclosingJoinPt);

		logger.debug(AOP_MARKER, "Method Call: {} -> {}, Session ID: {}",
				fromTo.getLeft(), fromTo.getRight(), (sess != null) ? sess.getId() : "");
	}

	@Nonnull
	private Pair<String, String> getFromToMethods(@Nonnull StaticPart joinPt, @Nonnull EnclosingStaticPart enclosingJoinPt){
		String from = enclosingJoinPt.getSignature().getDeclaringType().getSimpleName() + "."
				+ enclosingJoinPt.getSignature().getName();
		String to = joinPt.getSignature().getDeclaringType().getSimpleName() + "."
				+ joinPt.getSignature().getName();

		return Pair.of(from, to);
	}
}
