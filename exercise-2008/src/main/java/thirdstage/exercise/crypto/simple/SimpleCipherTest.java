/**
 * 
 */
package thirdstage.exercise.crypto.simple;

import static java.lang.System.out;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * @author 3rdstage
 *
 */
public class SimpleCipherTest {
	
	
	public static void main(String[] args) throws Exception{
		
		String transf = "DES";
		
		Cipher c = Cipher.getInstance(transf);
		KeyGenerator kg = KeyGenerator.getInstance(c.getAlgorithm());
		Key k = kg.generateKey();
		c.init(Cipher.ENCRYPT_MODE, k);
		
		String str = "SangmoonOh";
		byte[] encodedBytes = c.doFinal(str.getBytes());
		String encodedStr = new String(encodedBytes);
		
		out.println("[Result of simple Cipher test]");
		out.println(". Algorithm : " + c.getAlgorithm());
		out.println(". Key encoded : " + k.getEncoded());
		out.println(". Key encoding format : " + k.getFormat());
		out.println(". String to encode : " + str);
		out.println(". String encoded : " + encodedStr);
		out.println(". Bytes encoded : " + encodedBytes);
		out.println(". Key generator provider : " + kg.getProvider().getName() + "(" + kg.getProvider().getInfo() + ")");
		out.println(". Cipher provider : " + c.getProvider().getName() + "(" + c.getProvider().getInfo() + ")");
	
	}

}
