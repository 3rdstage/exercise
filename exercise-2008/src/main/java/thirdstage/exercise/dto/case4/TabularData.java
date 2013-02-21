/**
 * 
 */
package thirdstage.exercise.dto.case4;

import java.util.List;

/**
 * @author 3rdstage
 *
 */
public interface TabularData {
	
	List<Record> getRows();
	
	Record getRow(int i);

}
