package thirdstage.util.config.json;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/**
 * 
 * @author Sangmoon Oh
 * @version 0.9, Sangmoon Oh, 2013-08-01
 * @since 2013-08-01
 */
@Immutable
public interface SubjectMeta {
	
	@Nonnull
	public String getName();
	
	@Nullable
	public String getTitle(); 
	
	@Nullable
	public String getDescription();
	
	@Nonnull
	public List<PropertyMeta<?>> getPropertyMetas();
	
	/**
	 * If there's no such property meta, this method returns {@code null}.
	 * 
	 * @param prop the name of the property meta to get
	 * @return
	 * @throws IllegalArgumentException  if {@code prop} is {@code null}.
	 */
	@Nullable
	public PropertyMeta<?> getPropertyMeta(@Nonnull String prop);
}
