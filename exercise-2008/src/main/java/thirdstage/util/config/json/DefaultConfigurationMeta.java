/**
 * 
 */
package thirdstage.util.config.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import checkers.javari.quals.ReadOnly;

/**
 * @author 3rdstage
 *
 */
public class DefaultConfigurationMeta implements ConfigurationMeta {
	
	 
	private final List<SubjectMeta> subjects = new ArrayList<SubjectMeta>();
 
	
	/**
	 * @param subjs
	 * @throws IllegalArgumentException if there's some subject metas that have same
	 * 		name in the given {@code metas}.
	 */
	public DefaultConfigurationMeta(@Nonnull @ReadOnly List<SubjectMeta> subjs){
		if(subjs != null){
			Set<String> names = new HashSet<String>();
		 	
			for(SubjectMeta mt : subjs){
				if(names.contains(mt.getName())){
					throw new IllegalArgumentException("Each meta in the metas should have unique name.");
				}
				names.add(mt.getName());
			}
			this.subjects.addAll(subjs);
		}
	}
	
	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.ConfigurationMeta#getSubjectMetas()
	 */
	@Override
	@Nonnull
	public List<SubjectMeta> getSubjectMetas() {
		return Collections.unmodifiableList(subjects);
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.ConfigurationMeta#getSubjectMeta(java.lang.String)
	 */
	@Override
	@Nullable
	public SubjectMeta getSubjectMeta(@Nonnull String subj) {
		if(subj == null) throw new IllegalArgumentException("The subj should not null.");
		
		SubjectMeta meta = null;
		for(SubjectMeta mt : this.subjects){
			if(subj.equals(mt.getName())){
				meta = mt;
				break;
			}
		}
		return meta;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.ConfigurationMeta#getPropertyMeta(java.lang.String, java.lang.String)
	 */
	@Override
	@Nullable
	public PropertyMeta getPropertyMeta(@Nonnull String subj,
			@Nonnull String prop) {
		if(subj == null) throw new IllegalArgumentException("The subj should not null.");
		if(prop == null) throw new IllegalArgumentException("The prop should not null.");
		
		SubjectMeta meta = this.getSubjectMeta(subj);
		
		if(meta == null){
			return null;
		}else{
			return meta.getPropertyMeta(prop);
		}
	}
}
