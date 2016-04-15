package thirdstage.exercise.spring.case12;

/**
 * @author  3rdstage
 */
public class Airport {
	
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="code"
	 */
	private String code;
	
	public Airport(String name, String code){
		this.name = name;
		this.code = code;
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName(){ return this.name; }
	/**
	 * @return
	 * @uml.property  name="code"
	 */
	public String getCode(){ return this.code; }
	
	public String toString(){ return name + "(" + code + ")"; }
	
	
}
