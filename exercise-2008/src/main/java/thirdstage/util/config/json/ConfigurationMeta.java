package thirdstage.util.config.json;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/**
 * 
 * @author Sangmoon Oh
 * @version 0.8, Sangmoon Oh, 2013-08-05, Add documentations for symantics
 * @version 0.7, Sangmoon Oh, 2013-08-01
 * @since 2013-08-01
 */
@Immutable
public interface ConfigurationMeta {

	/**
	 * If there's no subjects in this configuration schema, this method 
	 * returns empty list instead of {@code null}.
	 * 
	 * @return 
	 */
	@Nonnull
	public List<SubjectMeta> getSubjectMetas();
	
	/**
	 * If there's no such subject, this method returns {@code null}.
	 * 
	 * @param subj the name of subject meta to get
	 * @throws IllegalArgumentException if {@code subj} is {@code null}
	 * @return
	 */
	@Nullable
	public SubjectMeta getSubjectMeta(@Nonnull final String subj);
	
	/**
	 * If there's no such subject or no such property in the subject, 
	 * this method returns {@code null}.
	 * 
	 * @param subj the name of subject meta
	 * @param prop the name of property in the subject to get
	 * @throws IllegalArgumentException if {@code subj} or {@code prop} is {@code null}.
	 * @return 
	 */
	@Nullable
	public PropertyMeta<?> getPropertyMeta(@Nonnull final String subj, @Nonnull final String prop);
}
