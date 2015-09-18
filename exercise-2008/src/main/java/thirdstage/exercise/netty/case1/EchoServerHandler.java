/**
 *
 */
package thirdstage.exercise.netty.case1;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.LoggerFactory;

/**
 * @author 3rdstage
 *
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter{

   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   @Override
   public void channelRead(ChannelHandlerContext ctx, Object msg){
      logger.info("Server received message: {}", msg);

      ctx.write(msg);
   }

   @Override
   public void channelReadComplete(ChannelHandlerContext ctx){
      ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
         .addListener(ChannelFutureListener.CLOSE);
   }

   @Override
   public void exceptionCaught(ChannelHandlerContext ctx, Throwable ex){
      logger.error("Error caught", ex);
      ctx.close();
   }


}
