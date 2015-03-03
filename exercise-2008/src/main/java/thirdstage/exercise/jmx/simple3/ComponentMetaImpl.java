/**
 * 
 */
package thirdstage.exercise.jmx.simple3;

import java.beans.ConstructorProperties;


/**
 * @author 3rdstage
 *
 */
public class ComponentMetaImpl implements ComponentMeta {
	
	private String title;

	private String name;
	
	private String domain;
	
	private String namespace;
	
	private String type;

	private String descn;
	
	/**
	 * @param title
	 * @param name
	 * @param domain
	 * @param type
	 * @param namespace
	 */
	@ConstructorProperties({"title", "name", "domain", "type", "namespace", "descn"})
	public ComponentMetaImpl(String title, String name, String domain, String type,
			String namespace, String descn) {
		super();
		this.title = title;
		this.name = name;
		this.domain = domain;
		this.type = type;
		this.namespace = namespace;
		this.descn = descn;
	}

	

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple3.ComponentMeta#getDescription()
	 */
	@Override
	public String getDescription() {
		return this.descn;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple3.ComponentMeta#getDomain()
	 */
	@Override
	public String getDomain() {
		return this.domain;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple3.ComponentMeta#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple3.ComponentMeta#getNamespace()
	 */
	@Override
	public String getNamespace() {
		return this.namespace;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple3.ComponentMeta#getTitle()
	 */
	@Override
	public String getTitle() {
		return this.title;
		
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple3.ComponentMeta#getType()
	 */
	@Override
	public String getType() {
		return this.type;
	}

}
