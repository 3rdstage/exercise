/**
 *
 */
package thirdstage.exercise.netty.case1;

import org.testng.annotations.Test;

/**
 * @author 3rdstage
 *
 */
public class EchoServerTest{

   @Test
   public void testStart() throws Exception{

      int port = 2400;
      EchoServer server = new EchoServer(port);
      server.start();
   }

}
