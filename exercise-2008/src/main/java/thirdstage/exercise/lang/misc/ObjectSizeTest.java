package thirdstage.exercise.lang.misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;


@SuppressWarnings("unused")
public class ObjectSizeTest {

	String[] strings = null;  

	/**
	 * This test shows java.lang.String object has 24byte overhead aside by
	 * the characters consisting of the string.<br/>
	 * This test uses Oracle JVM 1.6 32-bit version, and the exact number (24)
	 * can vary depending on the version or edition of the VM. 
	 * 
	 * The data correspondent with this object in the heap dump is :
	 * 
	 * <pre>
       434 (0.01%) [12] 1 thirdstage/exercise/lang/misc/ObjectSizeTest 0x280473b0
          422 (0.01%) [24] 6 array of [Ljava/lang/String; 0x2804a450
             174 (0.01%) [24] 1 java/lang/String 0x28052ae8
                150 (0%) [150] 0 char[] 0x2805afe8
             102 (0%) [24] 1 java/lang/String 0x28052ad0
                78 (0%) [78] 0 char[] 0x32cbdee0
             40 (0%) [24] 1 java/lang/String 0x28052aa0
                16 (0%) [16] 0 char[] 0x32cbdea8
             34 (0%) [24] 1 java/lang/String 0x28052ab8
                10 (0%) [10] 0 char[] 0x2805afd0
             24 (0%) [24] 1 java/lang/String 0x32cbdec8
                78 (0%) [78] 0 char[] 0x32cbdee0
             24 (0%) [24] 0 java/lang/String 0x37a77c18
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testStringObjectSize() throws Exception{

		strings = new String[6];

		//
		strings[0] = "January"; //7 character

		// 8 character
		//size of string object : 40 byte -> overhead : 24 byte (40 - 8*2)
		strings[1] = new String("Feburary"); 

		//3 character
		//size of string object : 34 byte -> overhead : 24 byte (34 - 5*2)
		strings[2] = new StringBuilder().append("March").toString(); 

		//39 character, counting '\n' as one.
		//size of string object : 102 byte -> overhead : 24 byte (102 - 39 * 2)
		strings[3] = "APRIL is the cruellest month, breeding\n";  

		//19 character is expected
		strings[4] = strings[3].substring(0, Math.round(strings[3].length()/2));  

		//75 character (39 + 36)
		//size of string object : 174 byte -> overhead : 24 byte (174 - 75 * 2)
		strings[5] = strings[3] + "Lilacs out of the dead land, mixing\n"; 



		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter any key to close this program.\n");

			while(System.in.available() < 1){
				Thread.currentThread().sleep(1000);
			}
			br.readLine();
		}catch(Exception ex){
			ex.printStackTrace(System.out);
		}finally{
			if(br != null) try{ br.close(); }catch(Exception ex){}
		}
	}

}
