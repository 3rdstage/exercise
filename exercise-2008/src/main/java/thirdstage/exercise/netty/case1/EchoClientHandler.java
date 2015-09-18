/**
 *
 */
package thirdstage.exercise.netty.case1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.slf4j.LoggerFactory;

/**
 * @author 3rdstage
 *
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf>{

   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   @Override
   public void channelActive(ChannelHandlerContext cntx){
      cntx.writeAndFlush(Unpooled.copiedBuffer("Hi ~", CharsetUtil.UTF_8));
   }

   @Override
   public void channelRead0(ChannelHandlerContext cntx, ByteBuf in){
      this.logger.info("Client received message: {}.", ByteBufUtil.hexDump(
            in.readBytes(in.readableBytes())));
   }

   @Override
   public void exceptionCaught(ChannelHandlerContext cntx, Throwable th){
      this.logger.error("Exception caught.", th);
      cntx.close();
   }
}
