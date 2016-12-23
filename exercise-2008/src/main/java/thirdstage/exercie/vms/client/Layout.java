/**
 *
 */
package thirdstage.exercie.vms.client;

import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Sangmoon Oh
 * @since Dec 23, 2016
 *
 */
public interface Layout{

   @NotBlank
   String getId();

   @NotBlank
   String getName();

   @Min(1)
   int getNumberOfTiles();


   boolean isEven();

   String getDesc();



}
