/**
 *
 */
package thirdstage.exercise.spring3.jmx;

import java.io.File;
import javax.annotation.RegEx;

/**
 *
 * @author 3rdstage
 * @version
 * @since
 *
 */
public interface StorageAccessService {


	File[] findFilesByRegex(@RegEx String regex);
}
