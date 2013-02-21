/**
 * 
 */
package thirdstage.exercise.jmx.simple;

import java.util.Date;

/**
 * @author 3rdstage
 *
 */
public interface ComponentRuntimeMBean extends ComponentMetaMBean {
	
	boolean isBlocked();
	
	void setBlocked(boolean blocked);
	
	Date getLastStartedAt();
	
	long getExcecutionCount();

	//@to-do add attrib. for execution log
	
}
