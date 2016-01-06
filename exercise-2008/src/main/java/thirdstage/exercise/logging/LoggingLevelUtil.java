/**
 * 
 */
package thirdstage.exercise.logging;

import org.apache.log4j.Level;

/**
 * @author 3rdstage
 *
 */
public class LoggingLevelUtil{
	
	public static enum CompareResult{ 
		FIRST_GREATER, 
		EQUAL, 
		SENCOD_GREATER,
		UNKNOWN
	}

	
	public CompareResult compareLog4jLevel(Level level1, Level level2){
		if(level1 == null || level2 == null){
			return CompareResult.UNKNOWN;
		}else{
			if(level1.isGreaterOrEqual(level2)){
				if(level1.equals(level2)) return CompareResult.EQUAL;
				else return CompareResult.FIRST_GREATER;
			}else{
				return CompareResult.SENCOD_GREATER;
			}
		}
	}

}
