/**
 *
 */
package thirdstage.exercise.netty.case1;

import org.testng.annotations.Test;

/**
 * @author 3rdstage
 *
 */
public class EchoClientTest{

   @Test
   public void testStart() throws Exception{

      String host = "127.0.0.1";
      int port = 2400;

      EchoClient client = new EchoClient(host, port);
      client.start();
   }

}
