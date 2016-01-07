/**
 *
 */
package thirdstage.exercise.lang.misc;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author 3rdstage
 *
 */
public class DateTest {

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	private FastDateFormat dateFormat = FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss z");


	@Test
	public void testTimeZone(){

		logger.info("'user.timezone' system variable at JVM startup command-line : {}", System.getProperty("user.timezone"));
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		logger.info("The current date is {} using 'new Date()'", this.dateFormat.format(d));
		logger.info("The current date is {} using 'Calendar.getInstance()'", this.dateFormat.format(c));

		c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
		logger.info("The current date is {} using 'Calendar.getInstance(TimeZone.getTimeZone(\"Asia/Seoul\"))'", this.dateFormat.format(c));

		TimeZone.setDefault(TimeZone.getTimeZone("GMT+5:00"));

		logger.info("");
		logger.info("Changed default time-zone to '{}' using TimeZone.setDefault()", TimeZone.getDefault());
		d = new Date();
		c = Calendar.getInstance();
		logger.info("The current date is {} using 'new Date()'", this.dateFormat.format(d));
		logger.info("The current date is {} using 'Calendar.getInstance()'", this.dateFormat.format(c));

		c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
		logger.info("The current date is {} using 'Calendar.getInstance(TimeZone.getTimeZone(\"Asia/Seoul\"))'", this.dateFormat.format(c));

		c.setTime(d);
		logger.info("The current date is {} using Calendar instance set by Date instance.", this.dateFormat.format(c));

	}

}
