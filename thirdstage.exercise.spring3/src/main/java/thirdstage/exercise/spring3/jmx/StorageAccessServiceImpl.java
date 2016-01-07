/**
 *
 */
package thirdstage.exercise.spring3.jmx;

import java.io.File;
import java.io.FilenameFilter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.RegEx;

import org.slf4j.LoggerFactory;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 *
 * @author 3rdstage
 * @version
 * @since
 *
 */
@ManagedResource(
		objectName=":type=bean,name=defaultStorageAccessService",
		description="Default storage access service."
	)
public class StorageAccessServiceImpl implements StorageAccessService {

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	private StorageProxy proxy;

	public StorageProxy getStorageProxy(){ return this.proxy; }

	private StorageProxyBuilder proxyBuilder;

	public StorageAccessServiceImpl(@Nonnull String baseDir, @Nullable FilenameFilter filter,
			@Nonnull StorageProxyBuilder proxyBuilder){

		this.proxyBuilder = proxyBuilder;
		this.proxyBuilder.setBaseDir(baseDir);
		this.proxyBuilder.setFileNameFilter(filter);

	}

	public void buildStorageProxy(){
		this.proxy = this.proxyBuilder.build();
	}


	/* (non-Javadoc)
	 * @see thirdstage.exercise.spring3.jmx.StorageAccessService#findFilesByRegex(java.lang.String)
	 */
	@Override
	public File[] findFilesByRegex(@RegEx String regex) {
		// TODO Auto-generated method stub
		return null;
	}

}
