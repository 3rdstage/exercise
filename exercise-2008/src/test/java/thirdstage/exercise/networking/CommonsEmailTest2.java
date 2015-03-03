/**
 * 
 */
package thirdstage.exercise.networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * <p>
 * Test apache commons email package.<br/><br/>
 * This file should be edited with encoding of EUC-KR to work correctly.
 * </p>
 * 
 * 
 * @version 1.0, Sangmoon Oh, Initial revision
 * @author 3rdstage
 * @since 2010-05-02
 * @
 */
public class CommonsEmailTest2{

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception{}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{}
	
	
	
	@Test
	public void testSimpleEmail1() throws Exception{
		
		SimpleEmail email = new SimpleEmail();

		email.setHostName("mail.chollian.net");
		email.setAuthentication("halfface", "");
		email.setCharset("euc-kr");
		
		Map header = new HashMap();
		header.put("Content-Type",	"text/plain; charset=euc-kr");
		header.put("Content-Transfer-Encoding", "base64");
		email.setHeaders(header);
		
		email.setFrom("halfface@skcc.com", "");
		email.setFrom("halfface@skcc.com", "");
		email.addTo("halfface@chollian.net", "");
		email.addTo("halfface@chol.com", "");
		
		String subj = "Mail for Plain Text";
		email.setSubject(subj);
		
		StringBuilder msg = new StringBuilder(300)
			.append("Ricky was a young boy. He had a heart of stone.\n")
			.append("\n\n")
			.append("Lived 9 to 5 and worked his fingers to the bone.\n")
			.append("\n\n")
			.append("~~~\n");
		
		email.setMsg(msg.toString());
		email.send();
		
		Assert.assertTrue(true);
	}

	@Test
	public void testHtmlEmail1() throws Exception{
		
		HtmlEmail email = new HtmlEmail();

 		email.setHostName("mail.chollian.net");
		email.setAuthentication("halfface", "");

		Map header = new HashMap();
		header.put("Content-Type",	"text/html; charset=euc-kr");
		header.put("Content-Transfer-Encoding", "base64");
		email.setHeaders(header);

		email.setFrom("halfface@skcc.com", "");
		email.addTo("halfface@chollian.net", "");
		email.addTo("halfface@chol.com", "");
		email.setSubject("Mail for HTML Contents");
		
		StringBuilder msg = new StringBuilder(300)
		   .append("<html>\n")
		   .append("<head><META HTTP-EQUIV='Content-Type' CONTENT='text/html; charset=utf-8'></head>\n")
		   .append("<title> : 18 and Life</title>\n")
		   .append("<body>\n")
		   .append("<pre>\n")
			.append("Ricky was a young boy. He had a heart of stone.\n")
			.append("\n\n")
			.append("Lived 9 to 5 and worked his fingers to the bone.\n")
			.append("\n\n")
			.append("~~~\n")
			.append("</pre>\n")
			.append("</body></html>\n");
		
		email.setHtmlMsg(msg.toString());
		email.send();
		
		Assert.assertTrue(true);
	}
	

}
