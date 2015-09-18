/**
 *
 */
package thirdstage.exercise.netty.case1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;
import org.slf4j.LoggerFactory;

/**
 * @author 3rdstage
 *
 */
public class EchoServer{

   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   private final int port;

   public EchoServer(int port){
      this.port = port;
   }

   public void start() throws Exception{

      EventLoopGroup group = new NioEventLoopGroup();

      try{
         ServerBootstrap b = new ServerBootstrap();
         b.group(group)
            .channel(NioServerSocketChannel.class)
            .localAddress(new InetSocketAddress(this.port))
            .childHandler(new ChannelInitializer<SocketChannel>(){
               @Override
               public void initChannel(SocketChannel ch) throws Exception{
                  ch.pipeline().addLast(new EchoServerHandler());
               }
            });

         ChannelFuture f = b.bind().sync();
         logger.info("{} started and listen on {}.", this.getClass().getName(),
               f.channel().localAddress());
         f.channel().closeFuture().sync();
      }finally{
         group.shutdownGracefully().sync();
      }

   }
}
