/**
 *
 */
package thirdstage.exercise.jca;

import java.io.InputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Sangmoon Oh
 * @since 2020. 1. 9.
 *
 */
public class KeyGenExercise{

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private KeyStore keyStore;

  // For Java 9+, https://support.portswigger.net/customer/portal/questions/17529891-java-9-pkcs-11-support
  @BeforeClass
  public void beforeClass() throws Exception{

    try {
      InputStream is = ClassLoader.getSystemResourceAsStream("thirdstage/exercise/jca/pkcs11-softhsm2.cfg");

      Provider p = Security.getProvider("SunPKCS11");
      Security.addProvider(p);

      final char[] pin = "abcd".toCharArray();
      this.keyStore = KeyStore.getInstance("PKCS11", p);
      this.keyStore.load(null, pin);

    }catch(Exception ex) {
      this.logger.error("Fail to create PKCS#11 KeyStore.", ex);
      throw ex;
    }
  }

  @Test
  public void testKeyGen() throws Exception{

    SecureRandom sr = new SecureRandom();
    KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
    kg.initialize(2048, sr);
    KeyPair kp = kg.generateKeyPair();
    PrivateKey k1 = kp.getPrivate();
    PublicKey k2 = kp.getPublic();

    this.logger.info("Key-pair generated - public key: {}", k2.toString());


  }

}
