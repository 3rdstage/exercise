/**
 *
 */
package thirdstage.exercise.lang.misc;

import java.util.Arrays;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author 3rdstage
 *
 */
public class TimeZoneTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testGetAvailableIDs(){
		String[] ids = TimeZone.getAvailableIDs();
		Arrays.sort(ids);

		TimeZone tz = null;
		for(String id: ids){
			tz = TimeZone.getTimeZone(id);
			logger.info("ID: {}, Display Name: {}", id, tz.getDisplayName());
		}
	}
}
