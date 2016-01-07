/**
 * 
 */
package thirdstage.exercise.jmx.simple2;

/**
 * This class is immutable.
 * 
 * @author 3rdstage
 *
 */
public class SimpleComponentMeta implements ComponentMeta{
	
	private String title;
	
	private String name;
	
	private String domain;
	
	private String type;
	
	private String namespace;
	
	private String description;
	
	
	
	
	/**
	 * @param title
	 * @param name
	 * @param domain
	 * @param type
	 * @param namespace
	 */
	public SimpleComponentMeta(String title, String name, String domain, String type,
			String namespace, String descn) {
		super();
		this.title = title;
		this.name = name;
		this.domain = domain;
		this.type = type;
		this.namespace = namespace;
		this.description = descn;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple.ComponentMetaMBean#getDescription()
	 */
	public String getDescription() {
		return this.description;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple.ComponentMetaMBean#getDomain()
	 */
	public String getDomain() {
		return this.domain;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple.ComponentMetaMBean#getName()
	 */
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple.ComponentMetaMBean#getNamespace()
	 */
	public String getNamespace() {
		return this.namespace;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple.ComponentMetaMBean#getTitle()
	 */
	public String getTitle() {
		return this.title;
		
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.jmx.simple.ComponentMetaMBean#getType()
	 */
	public String getType() {
		return this.type;
	}


}
