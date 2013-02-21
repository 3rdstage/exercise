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
 * Test apache commons email package.</p>
 * 
 * @version 1.0, Sangmoon Oh, Initial revision
 * @author 3rdstage
 * @since 2010-04-19
 * @
 */
public class CommonsEmailTest{

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
		email.setCharset("euc-kr");

//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Username: ");
//		String passwd = in.readLine().trim();
	
		Map header = new HashMap();
		//header.put("Content-Type",	"text/plain; charset=\"utf-8\"");
		header.put("Content-Transfer-Encoding", "base64");

		email.setHostName("mail.chollian.net");
		email.setAuthentication("halfface", "");

		email.setHeaders(header);
		email.setFrom("halfface@skcc.com");
//		email.addTo("halfface@chollian.net");
		email.addTo("halfface@chol.com", "상문");
		
		String subj = "테스트 Mail : 18 and Life by Skid Row";
		email.setSubject(new String(subj.getBytes(), "euc-kr"));
		//email.setSubject(new String(subj.getBytes("UTF-8"), "US-ASCII"));
		
		StringBuilder msg = new StringBuilder(300)
			.append("Ricky was a young boy. He had a heart of stone.\n")
			.append(".\n\n")
			.append("Lived 9 to 5 and worked his fingers to the bone.\n")
			.append("\n\n")
			.append("~~~\n");
		
		//email.setMsg(msg.toString());
		String body = "한글이 깨어저요";		
		email.setContent(new String(body.getBytes("euc-kr"), "euc-kr"), "text/plain; charset=euc-kr");
		email.send();
		
		Assert.assertTrue(true);
	}

	@Test
	public void testHtmlEmail1() throws Exception{
		
		HtmlEmail email = new HtmlEmail();

//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Username: ");
//		String passwd = in.readLine().trim();
	
 		email.setHostName("mail.chollian.net");
		email.setAuthentication("halfface", "");

		Map header = new HashMap();
		header.put("Content-Transfer-Encoding", "8bit");
		
		email.setCharset("utf-8");
		email.setHeaders(header);
		email.setFrom("halfface@skcc.com");
		email.addTo("halfface@chollian.net");
		email.addTo("halfface@chol.com");
		email.setSubject("Mail : 18 and Life by Skid Row");
		
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
		//email.send();
		
		Assert.assertTrue(true);
	}
	

}
