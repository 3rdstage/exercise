package thirdstage.exercise.spring3.aop.case2;

import java.util.Map;

public interface ElapsedTimeLogHandler { 
	
	
	void handleLog(String[] context, long startMilli, long endMilli);

}
