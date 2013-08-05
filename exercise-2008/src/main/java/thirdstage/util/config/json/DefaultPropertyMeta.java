/**
 * 
 */
package thirdstage.util.config.json;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.RegEx;

/**
 * @author 3rdstage
 *
 */
public class DefaultPropertyMeta<T> implements PropertyMeta<T> {
	
	private String name;
	
	private PropertyType type;

	private String title;
	
	private String description;
	
	private Boolean isRequired;
	
	private Double max;
	
	private Boolean isExclusiveMax;
	
	private Double min;
	
	private Boolean isExclusiveMin;
	
	private Integer maxLength;
	
	private Integer minLength;
	
	private T[] enums;
	
	private String patttern;
	
	private T defaultValue;
	
	/**
	 * @param name
	 * @param type
	 * @param title
	 * @param desc
	 * @param required
	 * @param max
	 * @param exclusiveMax
	 * @param min
	 * @param exclusiveMin
	 * @param maxLen
	 * @param minLen
	 * @param enums
	 * @param pattern
	 * @throws IllegalArgumentException with one or more of the followings
	 * <ul>
	 *   <li>{@code name} is {@code null}</li>
	 *   <li>{@code type} is {@code null} (?)</li>
	 *   <li>{@code max} is less than {@code min}</li>
	 *   <li>{@code max} is equal {@code min} and one or both of {@code exclusiveMax}
	 *     and {@code exclusiveMin} is {@code false}.</li>
	 *   <li>{@code PropertyType} and {@code T} are incompatible</li>
	 *   <li>{@code enums} and {@code pattern} are incompatible</li>
	 * </ul>
	 * 
	 */
	protected DefaultPropertyMeta(@Nonnull String name, PropertyType type,
		String title, String desc, Boolean required,
		Double max, Boolean exclusiveMax, Double min, 
		Boolean exclusiveMin, Integer maxLen, Integer minLen, 
		T[] enums, String pattern, T defaultValue){
	
		// TODO(Sangmoon Oh, 2013-08-05) full validation can be very complex.
		if(name == null){
			throw new IllegalArgumentException("..");
		}
		if(type == null){
			throw new IllegalArgumentException("..");
		}
		if((max != null) && (min != null)){
			
		}
		
		this.name = name;
		this.type = type;
		this.title = title;
		this.description = desc;
		this.isRequired = required;
		this.isExclusiveMax = exclusiveMax;
		this.isExclusiveMin = exclusiveMin;
		this.maxLength = maxLen;
		this.minLength = minLen;
		this.enums = enums;
		this.patttern = pattern;
		this.defaultValue = defaultValue;
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.PropertyMeta#getName()
	 */
	@Override
	@Nonnull
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.PropertyMeta#getType()
	 */
	@Override
	@Nonnull
	public PropertyType getType() {
		return this.type;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.PropertyMeta#isRequired()
	 */
	@Override
	@Nonnull
	public Boolean isRequired() {
		return this.isRequired;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.PropertyMeta#getTitle()
	 */
	@Override
	@Nullable
	public String getTitle() {
		return this.title;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.PropertyMeta#getDescription()
	 */
	@Override
	@Nullable
	public String getDescription() {
		return this.description;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.PropertyMeta#getMin()
	 */
	@Override
	@Nullable
	public Double getMin() {
		return this.min;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.PropertyMeta#isExclusiveMin()
	 */
	@Override
	public Boolean isExclusiveMin() {
		return this.isExclusiveMin;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.PropertyMeta#getMax()
	 */
	@Override
	@Nullable
	public Double getMax() {
		return this.max;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.PropertyMeta#isExclusiveMax()
	 */
	@Override
	public Boolean isExclusiveMax() {
		return this.isExclusiveMax;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.PropertyMeta#getMaxLength()
	 */
	@Override
	@Nullable
	public Integer getMaxLength() {
		return this.maxLength;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.PropertyMeta#getMinLength()
	 */
	@Override
	@Nullable
	public Integer getMinLength() {
		return this.minLength;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.PropertyMeta#getEnum()
	 */
	@Override
	@Nullable
	public T[] getEnum() {
		return this.enums;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.PropertyMeta#getPattern()
	 */
	@Override
	@Nullable
	@RegEx
	public String getPattern() {
		return this.patttern;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.PropertyMeta#getDefault()
	 */
	@Override
	@Nullable
	public T getDefault() {
		return this.defaultValue;
	}
	
	

}
