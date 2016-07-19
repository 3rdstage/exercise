/**
 *
 */
package thirdstage.exercise.concurrency.case5;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomUtils;

/**
 * @author Sangmoon Oh
 * @since 2016. 7. 19.
 *
 */
public class RunnableTaskServiceTest{

   public static void main(String[] args) throws Exception{

      RunnableTaskService service = new RunnableTaskService(10);
      int bundleNum = 20;
      int dataSize = 1000;
      long sleep = 1000;

      byte[] data = null;
      for(;;){
         List<byte[]> bundle = new ArrayList<byte[]>();
         for(int i = 0; i < bundleNum; i++){
            data = RandomUtils.nextBytes(dataSize);
            bundle.add(data);
         }

         service.service(bundle);

         Thread.currentThread().sleep(sleep);
      }
   }

}
