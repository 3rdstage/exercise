/**
 *
 */
package thirdstage.exercise.lang.misc;

import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Test for java.util.Calendar class
 *
 * @author 3rdstage
 *
 */
public class CalendarTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testCalendarWithTimeZoneToDate1(){

		int year = 2015;
		int month = 0;   //0 for January
		int day = 1;
		int hour = 12;
		int min = 0;
		int sec = 0;
		int milliSec = 500;

		FastDateFormat df = FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss.SSS zzz", TimeZone.getTimeZone("Asia/Seoul"));

		Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
		c1.set(year, month, day, hour, min, sec);
		c1.set(Calendar.MILLISECOND, milliSec);
		Date d1 = c1.getTime();
		long t1 = c1.getTimeInMillis();
		String sc1 = df.format(c1);
		String sd1 = df.format(d1);

		Calendar c2 = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
		c2.set(year, month, day, hour, min, sec);
		c2.set(Calendar.MILLISECOND, milliSec);
		Date d2 = c2.getTime();
		long t2 = c2.getTimeInMillis();
		String sc2 = df.format(c2);
		String sd2 = df.format(d2);

		logger.info("user.timezone : {}", System.getProperty("user.timezone"));
		logger.info("Default time-zone ID : {}", TimeZone.getDefault().getID());
		logger.info("");

		logger.info("Calendar c1 : {}", c1.toString());
		logger.info("c1.getTime().toGMTString() : {}", d1.toGMTString());
		logger.info("c1.getTime().toLocalString() : {}", d1.toLocaleString());
		logger.info("c1.getTime().toString() : {}", d1.toString());
		logger.info("c1.getTimeInMillis() : {}", t1);
		logger.info("DateFormat.format(c1) : {}", sc1);
		logger.info("DateFormat.format(c1.getTime()) : {}", sd1);
		logger.info("");

		logger.info("Calendar c2 : {}", c2.toString());
		logger.info("c2.getTime().toGMTString() : {}", d2.toGMTString());
		logger.info("c2.getTime().toLocalString() : {}", d2.toLocaleString());
		logger.info("c2.getTime().toString() : {}", d2.toString());
		logger.info("c2.getTimeInMillis() : {}", t2);
		logger.info("DateFormat.format(c2) : {}", sc2);
		logger.info("DateFormat.format(c2.getTime()) : {}", sd2);



	}

}
