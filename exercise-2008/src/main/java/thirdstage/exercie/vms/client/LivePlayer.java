/**
 *
 */
package thirdstage.exercie.vms.client;

/**
 * @author Sangmoon Oh
 * @since Dec 23, 2016
 *
 */
public interface LivePlayer{

   String getSystemId();

   /**
    * @param deviceId
    * @throws IllegalArtumentException when the specified {@code deviceId} value is not valid.
    * @throws RuntimeException when fail to
    */
   void start(String deviceId);

   void pause();

   void stop();

}
