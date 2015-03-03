/**
 * 
 */
package thirdstage.util.config.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import checkers.javari.quals.ReadOnly;

/**
 * @author 3rdstage
 *
 */
public class DefaultSubjectMeta implements SubjectMeta {
	
	private String name;
	
	private String title;
	
	private String description;
	
	private final List<PropertyMeta<?>> props = new ArrayList<PropertyMeta<?>>();
	
	/**
	 * @param name
	 * @param title
	 * @param desc
	 * @param props
	 * @throws IllegalArgumentException if the {@code name} is {@code null}, or
	 * 		there's some property metas that have same name in the {@code props}.
	 */
	public DefaultSubjectMeta(@Nonnull String name, @Nullable String title,
		@Nullable String desc, @Nullable @ReadOnly List<PropertyMeta<?>> props){
		if(name == null) throw new IllegalArgumentException("The name should not be null.");
		
		this.name = name;
		this.title = title;
		this.description = desc;
		
		if(props != null){
			//check the uniqueness of property metas 
			List<String> names = new ArrayList<String>();
			for(PropertyMeta mt : props){
				if(names.contains(mt.getName())){
					throw new IllegalArgumentException("Each property meta should have unique name.");
				}
				names.add(mt.getName());
			}
			this.props.addAll(props);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.SubjectMeta#getName()
	 */
	@Override
	@Nonnull
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.SubjectMeta#getTitle()
	 */
	@Override
	@Nullable
	public String getTitle() {
		return this.title;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.SubjectMeta#getDescription()
	 */
	@Override
	@Nullable
	public String getDescription() {
		return this.description;
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.SubjectMeta#getPropertyMetas()
	 */
	@Override
	@Nonnull
	public List<PropertyMeta<?>> getPropertyMetas() {
		
		return Collections.unmodifiableList(this.props);
	}

	/* (non-Javadoc)
	 * @see thirdstage.util.config.json.SubjectMeta#getPropertyMeta(java.lang.String)
	 */
	@Override
	@Nullable
	public PropertyMeta<?> getPropertyMeta(@Nonnull String prop) {
		if(props == null) throw new IllegalArgumentException("The prop shouldn't be null");
		
		PropertyMeta<?> meta = null;
		for(PropertyMeta<?> mt : this.props){
			if(prop.equals(mt.getName())){
				meta = mt;
				break;
			}
		}
		return meta;
	}

}
