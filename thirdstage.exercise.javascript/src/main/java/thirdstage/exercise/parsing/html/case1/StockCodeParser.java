package thirdstage.exercise.parsing.html.case1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * This class parses standard stock codes of KRX in a HTML file downloaded from http://isin.krx.co.kr/
 * For more about ISIN, refer http://en.wikipedia.org/wiki/International_Securities_Identification_Number.
 *
 * @author 3rdstage
 * @version 0.7
 * @since 2013-05-03
 */
public class StockCodeParser {
	
	protected static final Logger logger = LoggerFactory.getLogger(StockCodeParser.class);

	public StockCodeParser(){
		

	}


	public static List<StockCode> parseStockCodes(File f, String charSet) throws Exception{
		Document doc = Jsoup.parse(f, charSet);

		Elements stocks = doc.select("body table tr:gt(0)");
		Element stock = null;
		List<StockCode> codes = new ArrayList<StockCode>(stocks.size());
		for(int i = 0, n = stocks.size(); i < n; i++){
			stock = stocks.get(i);
			codes.add(new StockCode(stock.child(0).ownText(), /* issuerCode */
					stock.child(1).ownText(), /* issue */
					stock.child(2).ownText(), /* issueInEng */
					stock.child(3).ownText(), /* code */
					stock.child(4).ownText(), /* shortCode */
					stock.child(5).ownText() /* marketType */
					)
			);
		}
		
		System.out.printf("%1$d codes are found.\n", stocks.size());
		
		return codes;
	}

	public static JSONArray parseStockCodesIntoJSONArry(File f, String charSet) throws Exception{

		Document doc = Jsoup.parse(f, charSet);

		Elements stocks = doc.select("body table tr:gt(0)");
		Element stock = null;
		JSONArray codes = new JSONArray();
		for(int i = 0, n = stocks.size(); i < n; i++){
			stock = stocks.get(i);
			
			codes.put(new JSONObject().
					put("issuerCode", stock.child(0).ownText()).
					put("issue", stock.child(1).ownText()).
					put("issueInEng", stock.child(2).ownText()).
					put("code", stock.child(3).ownText()).
					put("shortCode", stock.child(4).ownText()).
					put("marketType", stock.child(5).ownText())
			);
		}
		
		System.out.printf("%1$d codes are found.\n", stocks.size());
		
		return codes;		
	}
	
	public static void parseStockCodesIntoFile(File src, String srcCharSet, 
			String trgPath, String trgCharSet, Boolean forceOverwrite) throws Exception{
		
		File f = new File(trgPath);
		if(!forceOverwrite && f.exists()){
			throw new IllegalStateException("The file specified exist and specified not to overwrite.");
		}
		
		PrintStream ps = null;
		try{
			ps = new PrintStream(new FileOutputStream(f), true, trgCharSet);
			JSONObject codes = new JSONObject();
			codes.put("stockCodes", parseStockCodesIntoJSONArry(src, srcCharSet));
			ps.print(codes.toString(2));
			
			logger.info("%1$d codes are written into the file %2$s in JSON format.\n", codes.length(), f.getCanonicalPath());
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			if(ps != null){
				try{ ps.close(); }
				catch(Exception ex){}
			}
		}
	}
	
}
