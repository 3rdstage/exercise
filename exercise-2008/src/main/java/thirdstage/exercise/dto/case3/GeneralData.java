/**
 * 
 */
package thirdstage.exercise.dto.case3;

import java.util.List;
import java.util.Map;

/**
 * @author 3rdstage
 *
 */
public interface GeneralData{
	
	SimpleType getLinearData(String key);

	Map<String, SimpleType> getAllLinearData();
	
	List<SimpleType> getSquareData(String key);
	
	Map<String, List<SimpleType>> getAllSqureDate();

}
