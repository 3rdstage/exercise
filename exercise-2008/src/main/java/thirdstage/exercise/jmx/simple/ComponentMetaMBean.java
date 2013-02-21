/**
 * 
 */
package thirdstage.exercise.jmx.simple;

/**
 * @author 3rdstage
 *
 */
public interface ComponentMetaMBean {
	
	String getTitle();
	
	String getName();
	
	String getDomain();
	
	String getType();
	
	String getNamespace();
	
	String getDescription();
	
	void setDescription(String desc);

}
