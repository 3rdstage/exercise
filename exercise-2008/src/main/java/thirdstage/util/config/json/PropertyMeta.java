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
public interface PropertyMeta<T>{
	
	
	@Nonnull
	public String getName();
	
	@Nonnull
	public PropertyType getType();
	
	@Nonnull
	public Boolean isRequired();
	
	@Nullable
	public String getTitle();

	@Nullable
	public String getDescription();

	//constraining facets : min, max, length, enum, pattern ...
	@Nullable
	public Double getMin();
	
	public Boolean isExclusiveMin();
	
	@Nullable
	public Double getMax();
	
	public Boolean isExclusiveMax();
	
	@Nullable
	public Integer getMaxLength();
	
	@Nullable
	public Integer getMinLength();
	
	@Nullable
	public T[] getEnum();
	
	@Nullable
	public String getPattern();
	
	@Nullable
	public T getDefault();
	
	
}
