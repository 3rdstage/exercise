/**
 *
 */
package thirdstage.exercise.spring3.jmx;

import java.io.FilenameFilter;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 *
 * @author 3rdstage
 * @version
 * @since
 *
 */
@ManagedResource(
		objectName=":type=bean,name=defaultStorageProxyBuilder",
		description="Default storage proxy builder"
	)
public class DefaultStorageProxyBuilder implements StorageProxyBuilder{

	private String base;

	@ManagedAttribute
	public String getBaseDir(){ return this.base; }

	@Override
	public void setBaseDir(@Nonnull String dir){ this.base = dir; }

	private FilenameFilter filter;

	@ManagedAttribute
	public FilenameFilter getFileNameFilter(){ return this.filter; }

	@Override
	public void setFileNameFilter(@Nullable FilenameFilter filter){ this.filter = filter; }

	public DefaultStorageProxyBuilder(){
	}


	@Override
	public StorageProxy build(){
		throw new java.lang.UnsupportedOperationException("Not yet implemented.");

	}


}
