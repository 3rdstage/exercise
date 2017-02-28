/**
 *
 */
package thirdstage.exercise.vms.client;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

/**
 * @author Sangmoon Oh
 * @since Dec 23, 2016
 *
 */
@Immutable
public class DeviceKey{

   /**
    * The identity for the external system (usually VMS system) managing the current device (usually CCTV)
    */
   @Nonnull private final String systemId;


   /**
    * The identity for the device(usually CCTV) in the its own system
    */
   @Nonnull private final String deviceId;


   public DeviceKey(@Nonnull String systemId, @Nonnull String deviceId){
      this.systemId = systemId;
      this.deviceId = deviceId;
   }

   public String getSystemId(){ return this.systemId; }


   public String getDeviceId(){ return this.deviceId; }




}
