package thirdstage.exercise.parsing.html.case1;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import net.sf.saxon.Configuration;
import net.sf.saxon.lib.Validation;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.XQueryCompiler;
import net.sf.saxon.s9api.XQueryEvaluator;
import net.sf.saxon.s9api.XQueryExecutable;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;

import org.ccil.cowan.tagsoup.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

/**
 * @author 3rdstage
 *
 */
public class Krx100Parser {
	
	
	protected static final Logger logger = LoggerFactory.getLogger(Krx100Parser.class);
	protected static final String KRX100_LIST_URL = "http://www.krx.co.kr/por_kor/m1/m1_4/m1_4_2/m1_4_2_1/JHPKOR01004_02_01_05.jsp?noScript=Y&work_dt=%1$s";
	protected static final String KRX100_LIST_XPATH = "for $x in /html[1]/body[1]/div[1]/table[1]/tbody[1]/tr return $x";
	
	private Processor xslProcessor;
	private DocumentBuilder docBuilder;
	private XQueryExecutable xqrExe;

	public Krx100Parser() throws Exception{
		Configuration cfg = new Configuration();
		cfg.setSchemaValidationMode(Validation.LAX);
		cfg.setValidation(false);
		cfg.setValidationWarnings(true);
		this.xslProcessor = new Processor(cfg);
		this.docBuilder = this.xslProcessor.newDocumentBuilder();
		
		String declQry = "declare default element namespace \"http://www.w3.org/1999/xhtml\";\n";
		this.xqrExe = this.xslProcessor.newXQueryCompiler().compile(declQry + KRX100_LIST_XPATH);
		
	}
	
	
	/**
	 * @return
	 * @throws Exception
	 * @fixme should use HttpClient to parse gzipped response without complex codes.
	 */
	public List<Krx100Item> getLatestItemsOfKrx100() throws Exception{
		
		String url = String.format(KRX100_LIST_URL, "");
		
		InputStream is = null;
		try{
			is = new URL(url).openStream();
			InputSource in = new InputSource(is);
			in.setEncoding("utf-8");
			Source src = new SAXSource(in);
			XdmNode doc = this.docBuilder.build(src);
			
			XQueryEvaluator xqev = this.xqrExe.load();
			xqev.setSource(doc.asSource());
			XdmValue xv = xqev.evaluate();
			
			int n = xv.size();
			
			
		}catch(Exception ex){
			throw ex;
		}finally{
			if(is != null){
				try{ is.close(); }
				catch(Exception ex){}
			}
			
		}

		return null;
		
	}
	

}
