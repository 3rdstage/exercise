package thirdstage.exercise.parsing.html.case1;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;



/**
 * This class parses standard stock codes of KRX in a HTML file downloaded from http://isin.krx.co.kr/
 * For more about ISIN, refer http://en.wikipedia.org/wiki/International_Securities_Identification_Number.
 *
 * @author 3rdstage
 * @version 0.7
 * @since 2013-05-03
 */
public class StockCodeParser {

	public StockCodeParser(){


	}


	public static List<StockCode> parseStockCodes(File f, String charSet) throws Exception{


		Document doc = Jsoup.parse(f, charSet);

		Elements issuerCodes = doc.select("body > table > tr:gt(1) > td:eq(0)");

		Iterator<Element> issuerCodes2 = issuerCodes.iterator();
		Element issuer = null;


		return null;

	}

}
