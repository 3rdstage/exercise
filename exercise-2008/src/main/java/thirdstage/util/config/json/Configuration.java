package thirdstage.util.config.json;

import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull; 

/**
 * 
 * @author Sangmoon Oh
 * @version 0.9, Sangmoon Oh, 2013-08-01
 * @since 2013-08-01
 */
public interface Configuration {
	
	
	public Object getPropertyValue(@Nonnull final String subj, @Nonnull final String props);
	
	public <T> T getPropertyValue(@Nonnull final String subj, @Nonnull final String props, Class<T> type);
	
	public List<Map<String, Object>> getProperties(@Nonnull final String subj);

}
