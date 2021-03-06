package thirdstage.exercise.parsing.html.case1;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.ccil.cowan.tagsoup.Parser;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import net.sf.saxon.Configuration;
import net.sf.saxon.lib.Validation;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.XQueryCompiler;
import net.sf.saxon.s9api.XQueryEvaluator;
import net.sf.saxon.s9api.XQueryExecutable;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;



/**
 * @author 3rdstage
 * @todo Identify the thread-safeness of org.ccil.cowan.tagsoup.Parser
 * @todo Search the general inputstream implementation awaring the prefix of URL such as file:///, http:///
 * @todo How to execute multiple XQueries in one time.
 */
public class NaverFinanceParser2 {
	
	private Processor xslProcessor;
	
	private DocumentBuilder docBuilder;
	
	private PropertiesConfiguration meta;
	
	private List<String> queryKeys;
	
	/**
	 * Note that XQueryExecutable is thread-safe 'cause it is immutable but
	 * XQueryEvaluator is NOT thread-safe.  So, XQueryExecutable intances can 
	 * be member variable. 
	 */
	private Map<String, XQueryExecutable> queryExecutables;
	
	
	public NaverFinanceParser2(File metaFile) throws Exception{

		Configuration cfg = new Configuration();
		cfg.setSchemaValidationMode(Validation.LAX);
		cfg.setValidation(false);
		cfg.setValidationWarnings(true);
		this.xslProcessor = new Processor(cfg);
		this.docBuilder = this.xslProcessor.newDocumentBuilder();
		
		this.meta = new PropertiesConfiguration(metaFile);
		
		this.queryKeys = new ArrayList<String>();
		this.queryKeys.add("stock.dailysummary.xquery.prevClosingPrice"); //previous day closing price
		this.queryKeys.add("stock.dailysummary.xquery.dailyHighPrice"); //daily high price
		//this.queryKeys.add("stock.dailysummary.xquery.limitUp");
		this.queryKeys.add("stock.dailysummary.xquery.volume");
		this.queryKeys.add("stock.dailysummary.xquery.openingPrice");
		this.queryKeys.add("stock.dailysummary.xquery.dailyLowPrice");
		//this.queryKeys.add("stock.dailysummary.xquery.limitDown");
		this.queryKeys.add("sotck.dailysummary.xquery.amountInMillion");
		
		this.queryExecutables = new HashMap<String, XQueryExecutable>();

		String namespaceDecl = "declare default element namespace \"http://www.w3.org/1999/xhtml\";\n";
		XQueryCompiler xqc = this.xslProcessor.newXQueryCompiler();

		for(String queryKey : queryKeys){
			queryExecutables.put(queryKey, xqc.compile(namespaceDecl + this.meta.getString(queryKey)));
		}
		
	}
	
	
	/**
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 * @underConstruction
	 * @todo Replace the akaward FileInputStream with proper one. 
	 */
	public DailySummaryByStock parseDailySummaryByStock(String code) throws Exception{

		DailySummaryByStock result = new DailySummaryByStock();
		
		String url = String.format(this.meta.getString("stock.dailysummary.url"), code);
		XMLReader xr = new Parser();
		InputSource in = new InputSource(new URL(url).openStream());
		in.setEncoding(this.meta.getString("stock.dailysummary.url.encoding"));
		Source src = new SAXSource(xr, in);
		XdmNode doc = this.docBuilder.build(src);

		XQueryEvaluator xqev 
			= this.queryExecutables.get("stock.dailysummary.xquery.prevClosingPrice").load();
		xqev.setSource(doc.asSource());
		result.prevClosingPrice = Double.valueOf(xqev.evaluate().toString());
		
		xqev = this.queryExecutables.get("stock.dailysummary.xquery.dailyHighPrice").load();
		xqev.setSource(doc.asSource());
		result.dailyHighPrice = Double.valueOf(xqev.evaluate().toString());

//		xqev = this.queryExecutables.get("stock.dailysummary.xquery.limitUp").load();
//		xqev.setSource(doc.asSource());
//		result.limitUp = Double.valueOf(xqev.evaluate().toString());

		xqev = this.queryExecutables.get("stock.dailysummary.xquery.volume").load();
		xqev.setSource(doc.asSource());
		result.volume = Long.valueOf(xqev.evaluate().toString());

		xqev = this.queryExecutables.get("stock.dailysummary.xquery.openingPrice").load();
		xqev.setSource(doc.asSource());
		result.openingPrice = Double.valueOf(xqev.evaluate().toString());
		
		xqev = this.queryExecutables.get("stock.dailysummary.xquery.dailyLowPrice").load();
		xqev.setSource(doc.asSource());
		result.dailyLowPrice = Double.valueOf(xqev.evaluate().toString());

//		xqev = this.queryExecutables.get("stock.dailysummary.xquery.limitDown").load();
//		xqev.setSource(doc.asSource());
//		result.limitDown = Double.valueOf(xqev.evaluate().toString());
		
		xqev = this.queryExecutables.get("sotck.dailysummary.xquery.amountInMillion").load();
		xqev.setSource(doc.asSource());
		
		result.stockCode = code;
		return result;
	}

}
