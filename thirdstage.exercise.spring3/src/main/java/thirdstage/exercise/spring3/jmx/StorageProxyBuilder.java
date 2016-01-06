/**
 *
 */
package thirdstage.exercise.spring3.jmx;

import java.io.FilenameFilter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 *
 * @author 3rdstage
 * @version
 * @since
 *
 */
@NotThreadSafe
public interface StorageProxyBuilder {

	void setBaseDir(@Nonnull String dir);

	void setFileNameFilter(@Nullable FilenameFilter filter);

	StorageProxy build();

}
