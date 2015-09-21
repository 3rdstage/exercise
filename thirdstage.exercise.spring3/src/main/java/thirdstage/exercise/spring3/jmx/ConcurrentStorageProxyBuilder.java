/**
 *
 */
package thirdstage.exercise.spring3.jmx;

import java.io.FilenameFilter;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.Min;

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
		objectName=":type=bean,name=concurrentStorageProxyBuilder",
		description="Storage proxy builder that builds quickly using multi-threads"
	)
public class ConcurrentStorageProxyBuilder implements StorageProxyBuilder {

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

	private final int maxThreads;

	@ManagedAttribute
	public int getMaxThreads(){ return this.maxThreads; }


	public ConcurrentStorageProxyBuilder(@Min(1) int maxThreads){
		this.maxThreads = maxThreads;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.spring3.jmx.StorageProxyBuilder#build()
	 */
	@Override
	public StorageProxy build() {
		throw new java.lang.UnsupportedOperationException("Not yet implemented.");
	}

}
