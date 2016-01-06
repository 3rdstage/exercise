/**
 *
 */
package thirdstage.exercise.commons.lang;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author 3rdstage
 *
 */
public class FastDateFormatTest {

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


	@Nonnull
	public Date safeParse(FastDateFormat format, String src){
		Date d = null;
		try{ d = format.parse(src);	}
		catch(Exception ex){ d = null; }

		return d;
	}

	@Test
	public void testParseWithValidString() throws Exception{

		FastDateFormat format = FastDateFormat.getInstance("yyyyMMddHHmm");

		List<String> strs = new ArrayList<String>();

		strs.add("201501011030");
		strs.add("201602291030"); //a leap day
		strs.add("201501010000");
		strs.add("201501010059");
		strs.add("201501012300");
		strs.add("201501012359");
		strs.add("000101012359");
		strs.add("001001012359");
		strs.add("010001012359");
		strs.add("100001012359");

		Date d = null;
		for(String str : strs){
			d = this.safeParse(format, str);
			Assert.assertNotNull(d);
			logger.info("String: {}, Parsed Date: {}", str, d);
		}
	}

	@Test
	public void testParseWithInvalidString() throws Exception{

		FastDateFormat format = FastDateFormat.getInstance("yyyyMMddHHmm");

		List<String> strs = new ArrayList<String>();

		strs.add(null);
		strs.add(""); //empty string
		strs.add("            "); //blank string
		strs.add("  7111231200"); //leading white-spaces instead of digits
		strs.add("1971112312  "); //trailing white-spaces instead of digits
		strs.add("  197111231200"); //leading white-spaces
		strs.add("197111231200  "); //trailing white-space
		strs.add("1971112312000"); //additional last 0
		strs.add("19711123120000"); //additional last 00
		strs.add("1971112312"); //year-2-hour string
		strs.add("20150101230020"); //year-2-second string
		strs.add("20150101103020"); //year-2-second string
		strs.add("201400011030"); //wrong month - 00
		strs.add("201413011030"); //wrong month - 13
		strs.add("201401001030"); //wrong day - 00
		strs.add("201401321030"); //wrong day - 32
		strs.add("201402301030"); //wrong day - 0431
		strs.add("201404311030"); //wrong day - 0431
		strs.add("201401012430"); //wrong hour - 24
		strs.add("201401015030"); //wrong hour - 50
		strs.add("201401012360"); //wrong min - 60
		strs.add("201401012377"); //wrong min - 77

		for(String str : strs){
			logger.info("Testee expected NOT to be in 'yyyyMMddHHmm' format: {}", str);
			Assert.assertNull(this.safeParse(format, str));
		}
	}

}
