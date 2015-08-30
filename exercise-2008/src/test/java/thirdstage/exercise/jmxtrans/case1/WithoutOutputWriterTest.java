package thirdstage.exercise.jmxtrans.case1;

import org.testng.annotations.Test;
import com.googlecode.jmxtrans.model.JmxProcess;
import com.googlecode.jmxtrans.model.Server;
import com.googlecode.jmxtrans.util.JsonPrinter;

public class WithoutOutputWriterTest {

   private static final JsonPrinter printer = null;

   @BeforeClass
   public void beforeClass(){
      printer = new JsonPrinter(System.out);
   }

   @Test
   public void testPrettyPrint() {

      Query qry = Query.builder()
            .setObject("java.lang:type=Memory")
            .addAttr("HeapMemoryUsage", "NonHeapMemoryUsage")
            .build();

      Server server = Server.builder().setHost("localhost").setPort("1099")
            .setNumQueryThreads(2)
            .addQuery(qry).build();

      JmxProcess process = new JmxProcess(server);

      printer.prettyPrint(process);

   }
}
