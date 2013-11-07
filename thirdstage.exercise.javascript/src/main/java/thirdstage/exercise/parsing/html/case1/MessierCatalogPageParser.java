package thirdstage.exercise.parsing.html.case1;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import net.sf.saxon.Configuration;
import net.sf.saxon.lib.Validation;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.XQueryCompiler;
import net.sf.saxon.s9api.XQueryEvaluator;
import net.sf.saxon.s9api.XQueryExecutable;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmSequenceIterator;
import net.sf.saxon.s9api.XdmValue;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.validator.routines.DoubleValidator;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.ContentEncodingHttpClient;
import org.ccil.cowan.tagsoup.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * Using XQuery
 * 
 * @author 3rdstage
 *
 */
public class MessierCatalogPageParser{
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected static final String MESSIER_CATALOG_URL = "http://en.wikipedia.org/wiki/List_of_Messier_objects";
	protected static final String MESSIER_CATALOG_XPATH 
		= "for $x in //div[@id='mw-content-text']/table[1]/tr[(position() > 1) and (position() < last())] return $x";

	private Processor xslProcessor;
	private DocumentBuilder docBuilder;
	private XQueryExecutable xqrExe;
	private Map<String, XQueryExecutable> subXqrExes = new HashMap<String, XQueryExecutable>();
	
	private PropertiesConfiguration meta;
	private List<String> queryKeys;
	
	/**
	 * Note that XQueryExecutable is thread-safe 'cause it is immutable but
	 * XQueryEvaluator is NOT thread-safe.  So, XQueryExecutable intances can 
	 * be member variable. 
	 */
	private Map<String, XQueryExecutable> queryExecutables;
	
	
	public static void main(String... arg) throws Exception{
		
		MessierCatalogPageParser parser = new MessierCatalogPageParser();
		
		List<MessierObject> mos = parser.getMessierCatalog();
		
		for(MessierObject mo : mos){
			System.out.println(mo.toString());
		}
		
	}
	
	
	public MessierCatalogPageParser() throws Exception{

		Configuration cfg = new Configuration();
		cfg.setSchemaValidationMode(Validation.LAX);
		cfg.setValidation(false);
		cfg.setValidationWarnings(true);
		this.xslProcessor = new Processor(cfg);
		this.docBuilder = this.xslProcessor.newDocumentBuilder();
		String declQry = "declare default element namespace \"http://www.w3.org/1999/xhtml\";\n";
		
		XQueryCompiler xqc = this.xslProcessor.newXQueryCompiler();
		this.xqrExe = xqc.compile(declQry + MESSIER_CATALOG_XPATH);
		
		subXqrExes.put("number", xqc.compile(declQry 
			+ "for $x in ./td[1]/a[1]/string() return $x"));
		subXqrExes.put("ngcNumber", xqc.compile(declQry 
			+ "for $x in ./td[2]/string() return $x"));
		subXqrExes.put("commonName", xqc.compile(declQry 
			+ "for $x in ./td[3]/string() return $x"));
		subXqrExes.put("type", xqc.compile(declQry 
			+ "for $x in ./td[5]/string() return $x"));
		subXqrExes.put("distance", xqc.compile(declQry 
			+ "for $x in ./td[6]/string() return $x"));
		subXqrExes.put("constellation", xqc.compile(declQry 
			+ "for $x in ./td[7]/string() return $x"));
		subXqrExes.put("apparentMagnitude", xqc.compile(declQry 
			+ "for $x in ./td[8]/string() return $x"));
	}
	
	@Nonnull
	public List<MessierObject> getMessierCatalog() throws Exception{
		
		
		XMLReader xr = new Parser();
		InputSource in = new InputSource(new URL(MESSIER_CATALOG_URL).openStream());
		in.setEncoding("UTF-8");
		Source src = new SAXSource(xr, in);
		XdmNode doc = this.docBuilder.build(src);

		XQueryEvaluator xqev = this.xqrExe.load();
		xqev.setSource(doc.asSource());
		
		XdmValue value = xqev.evaluate(); //table node
		
		Map<String, XQueryEvaluator> subXqevs = new HashMap<String, XQueryEvaluator>();
		for(Map.Entry<String, XQueryExecutable> entry : this.subXqrExes.entrySet()){
			subXqevs.put(entry.getKey(), entry.getValue().load());
		}
		
		List<MessierObject> result = new ArrayList<MessierObject>(120);
		XdmSequenceIterator itr = value.iterator();
		XdmItem item = null;
		XdmNode node = null;
		XQueryEvaluator subXqev = null;
		XdmItem item2 = null;
		String number = null;
		String ngcNumber = null;
		String commonName = null;
		String type = null;
		Double distance = null;
		String constellation = null;
		Double apparentMagnitude = null;
		MessierObject mo = null;
		while(itr.hasNext()){
			item = itr.next();
			if(!item.isAtomicValue()){
				//for number column
				subXqev = subXqevs.get("number");
				subXqev.setSource(((XdmNode)item).asSource());
				item2 = subXqev.evaluateSingle();
				if(item2 != null && item2.isAtomicValue()) number = item2.getStringValue();
				
				//for ngcNumber column
				subXqev = subXqevs.get("ngcNumber");
				subXqev.setSource(((XdmNode)item).asSource());
				item2 = subXqev.evaluateSingle();
				if(item2 != null && item2.isAtomicValue()) ngcNumber = item2.getStringValue();
				
				//for commonName column
				subXqev = subXqevs.get("commonName");
				subXqev.setSource(((XdmNode)item).asSource());
				item2 = subXqev.evaluateSingle();
				if(item2 != null && item2.isAtomicValue()) commonName = item2.getStringValue();

				//for type column
				subXqev = subXqevs.get("type");
				subXqev.setSource(((XdmNode)item).asSource());
				item2 = subXqev.evaluateSingle();
				if(item2 != null && item2.isAtomicValue()) type = item2.getStringValue();
				
				//for distance column
				subXqev = subXqevs.get("distance");
				subXqev.setSource(((XdmNode)item).asSource());
				item2 = subXqev.evaluateSingle();
				if(item2 != null && item2.isAtomicValue()) distance = DoubleValidator.getInstance().validate(item2.getStringValue(), "#,##0.##");
				
				//for constellation column
				subXqev = subXqevs.get("constellation");
				subXqev.setSource(((XdmNode)item).asSource());
				item2 = subXqev.evaluateSingle();
				if(item2 != null && item2.isAtomicValue()) constellation = item2.getStringValue();
				
				//for apparentMagnitude column
				subXqev = subXqevs.get("apparentMagnitude");
				subXqev.setSource(((XdmNode)item).asSource());
				item2 = subXqev.evaluateSingle();
				if(item2 != null && item2.isAtomicValue()) apparentMagnitude = DoubleValidator.getInstance().validate(item2.getStringValue(), "#,##0.##");

				this.logger.debug("{}, {}, {}, {}, {}, {}, {}", number, ngcNumber, commonName, type, distance, constellation, apparentMagnitude);
				
				mo = new MessierObject();
				mo.setNumber(number);
				mo.setNgcNumber(ngcNumber);
				mo.setCommonName(commonName);
				mo.setType(type);
				mo.setDistance(distance);
				mo.setConstellation(constellation);
				mo.setApparentMagnitude(apparentMagnitude);
				
				result.add(mo);
			}
			
		}
		
		return result;
	}
	
	

	
	public static class MessierObject{
		
		private String number;
		
		private String ngcNumber;
		
		private String commonName;
		
		private String type;
		
		private Double distance;
		
		private String constellation;
		
		private Double apparentMagnitude;

		/**
		 * @return the number
		 */
		public String getNumber(){
			return number;
		}

		/**
		 * @param number the number to set
		 */
		public void setNumber(String number){
			this.number = number;
		}

		/**
		 * @return the ngcNumber
		 */
		public String getNgcNumber(){
			return ngcNumber;
		}

		/**
		 * @param ngcNumber the ngcNumber to set
		 */
		public void setNgcNumber(String ngcNumber){
			this.ngcNumber = ngcNumber;
		}

		/**
		 * @return the commonName
		 */
		public String getCommonName(){
			return commonName;
		}

		/**
		 * @param commonName the commonName to set
		 */
		public void setCommonName(String commonName){
			this.commonName = commonName;
		}

		/**
		 * @return the type
		 */
		public String getType(){
			return type;
		}

		/**
		 * @param type the type to set
		 */
		public void setType(String type){
			this.type = type;
		}

		/**
		 * @return the distance
		 */
		public Double getDistance(){
			return distance;
		}

		/**
		 * @param distance the distance to set
		 */
		public void setDistance(Double distance){
			this.distance = distance;
		}

		/**
		 * @return the constellation
		 */
		public String getConstellation(){
			return constellation;
		}

		/**
		 * @param constellation the constellation to set
		 */
		public void setConstellation(String constellation){
			this.constellation = constellation;
		}

		/**
		 * @return the apparentMagnitude
		 */
		public Double getApparentMagnitude(){
			return apparentMagnitude;
		}

		/**
		 * @param apparentMagnitude the apparentMagnitude to set
		 */
		public void setApparentMagnitude(Double apparentMagnitude){
			this.apparentMagnitude = apparentMagnitude;
		}
		
		
		@Override
		public String toString(){
			
			StringBuilder sb = new StringBuilder().append(this.number).append(", ")
					.append(this.ngcNumber).append(", ")
					.append(this.commonName).append(", ")
					.append(this.type).append(", ")
					.append(this.distance).append(", ")
					.append(this.constellation).append(", ").append(this.apparentMagnitude);
			
			return sb.toString();
		}
		
		
	}
	
	
}
