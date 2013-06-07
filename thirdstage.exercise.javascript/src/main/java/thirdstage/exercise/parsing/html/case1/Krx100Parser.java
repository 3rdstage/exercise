package thirdstage.exercise.parsing.html.case1;

import java.util.List;

import net.sf.saxon.Configuration;
import net.sf.saxon.lib.Validation;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.XQueryCompiler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Krx100Parser {
	
	
	protected static final Logger logger = LoggerFactory.getLogger(Krx100Parser.class);
	protected static final String KRX100_LIST_URL = "http://www.krx.co.kr/por_kor/m1/m1_4/m1_4_2/m1_4_2_1/JHPKOR01004_02_01_05.jsp";
	
	
	private Processor xslProcessor;
	private DocumentBuilder docBuilder;

	public Krx100Parser(){
		Configuration cfg = new Configuration();
		cfg.setSchemaValidationMode(Validation.LAX);
		cfg.setValidation(false);
		cfg.setValidationWarnings(true);
		this.xslProcessor = new Processor(cfg);
		this.docBuilder = this.xslProcessor.newDocumentBuilder();
		
		String qryStr = "declare default element namespace \"http://www.w3.org/1999/xhtml\";\n";
		XQueryCompiler xqc = this.xslProcessor.newXQueryCompiler();
		//xqc.compile(arg0);

		
		
	}
	
	
	public List<Krx100Item> getCurrentItemsOfKrx100(){
		
		
		
		return null;
		
	}
	

}
