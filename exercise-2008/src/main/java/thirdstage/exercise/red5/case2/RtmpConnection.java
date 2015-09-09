/**
 *
 */
package thirdstage.exercise.red5.case2;

import javax.annotation.Nonnull;
import javax.validation.constraints.Min;
import org.red5.client.net.rtmp.RTMPClient;
import org.red5.server.net.rtmp.RTMPConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 3rdstage
 *
 */
public class RtmpConnection{

   public final static int CONNECTION_TIMEOUT_DEFAULT = 10000;

   private final transient Logger logger = LoggerFactory.getLogger(this.getClass());

   private final String host;

   public String getHost(){ return this.host; }

   private final int port;

   public int getPort(){ return this.port; }

   private final String app;

   public String getApp(){ return this.app; }

   private final RTMPClient client = new RTMPClient(){

      @Override
      public void connectionOpened(RTMPConnection conn){
         super.connectionOpened(conn);
         logger.debug("RTMP Connection is opening.");
      }

      @Override
      public void connectionClosed(RTMPConnection conn){
         super.connectionClosed(conn);
         logger.debug("RTMP Connection is closing.");
      }
   };

   public RtmpConnection(@Nonnull String host, @Min(1) int port, String app){
      this.host = host;
      this.port = port;
      this.app = app;
   }


   public void connect(){


   }

   public RtmpStream getStream(final String file, final int start, final int duration){




      return null;
   }


}
