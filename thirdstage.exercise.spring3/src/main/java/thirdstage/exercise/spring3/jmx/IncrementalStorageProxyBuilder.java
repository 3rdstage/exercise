/**
 *
 */
package thirdstage.exercise.spring3.jmx;

import java.io.FilenameFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
		objectName=":type=bean,name=incrementalStorageProxyBuilder",
		description="Storage proxy builder that builds incrementally using background."
	)
public class IncrementalStorageProxyBuilder implements StorageProxyBuilder {

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

	private final ExecutorService executor;


	public IncrementalStorageProxyBuilder(){

		this.executor = Executors.newSingleThreadExecutor();
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.spring3.jmx.StorageProxyBuilder#build()
	 */
	@Override
	public StorageProxy build() {
		throw new java.lang.UnsupportedOperationException("Not yet implemented.");
	}

}
