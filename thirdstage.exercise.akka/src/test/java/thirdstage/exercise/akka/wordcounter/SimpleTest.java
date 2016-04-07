package thirdstage.exercise.akka.wordcounter;

import org.apache.commons.codec.binary.Hex;
import org.testng.annotations.Test;

public class SimpleTest {
   @Test
   public void testUtf8ToIsoLatin1() throws Exception{

      String name = new String("홍길동");
      byte[] bytes = name.getBytes("UTF-8");

      System.out.print("'");
      for(int i = 0, n = bytes.length; i < n; i++){
         System.out.write(bytes, i, 1);
         System.out.print(" ");
      }
      System.out.println("'");

      System.out.print("'");
      byte[] bytes2 = new byte[1];
      for(int i = 0, n = bytes.length; i < n; i++){
         bytes2[0] = bytes[i];
         System.out.print(new String(bytes2, "ISO-8859-1"));
         System.out.print(" ");
      }
      System.out.println("'");

      String hex = Hex.encodeHexString(bytes);
      System.out.println(hex);

      String name2 = new String(bytes, "UTF-8");
      System.out.println(name2);

      String name3 = new String(bytes, "ISO-8859-1");
      System.out.println(name3);

   }
}
