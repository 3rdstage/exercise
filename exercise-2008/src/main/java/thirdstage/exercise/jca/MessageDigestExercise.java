/**
 *
 */
package thirdstage.exercise.jca;

import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Sangmoon Oh
 * @since 2020. 1. 17.
 *
 */
public class MessageDigestExercise{

  //https://www.tutorialspoint.com/java_cryptography/java_cryptography_creating_mac.htm

  final private Logger logger = LoggerFactory.getLogger(this.getClass());

  private String msg1 = "Rain and tears are the same. But in the Sun, you've got to play.";

  private KeyGenerator desKeyGen;


  @BeforeClass
  public void beforeClass() throws Exception{

    this.desKeyGen = KeyGenerator.getInstance("DES");
    SecureRandom rd = new SecureRandom();

    this.desKeyGen.init(rd);

  }


  @Test
  public void testSha256() throws Exception{

    MessageDigest md = MessageDigest.getInstance("SHA-256");

    md.update(msg1.getBytes());

    byte[] digest = md.digest();

    Assert.assertEquals(digest.length, 256/8);  // 256 bits output

    this.logger.info("Digest : {}", digest);
  }


  /**
   * @throws Exception
   *
   * @see <a href='https://en.wikipedia.org/wiki/Message_authentication_code'>Message authentication code</a>
   *
   */
  @Test
  public void testMac() throws Exception{

    // primary factors
    // A key generation algorithm - DES
    // A signing algorithm - HMAC SHA256
    // A verifying algorithm

    Key key = this.desKeyGen.generateKey();


  }

}
