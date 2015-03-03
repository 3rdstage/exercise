package thirdstage.exercise.parsing.html.case1;

import java.io.File;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverFinanceParser {


	protected PropertiesConfiguration meta;

	public NaverFinanceParser(File meta) throws Exception{
		this.meta = new PropertiesConfiguration(meta);

	}

	public DailySummaryByStock parseDailySummaryByStock(String code) throws Exception{

		String urlFormat = meta.getString("stock.dailysummary.urlFormat");
		String prevClosingPriceSelector = meta.getString("stock.dailysummary.selector.prevClosingPrice");

		String url = String.format(urlFormat, code);

		Document doc = Jsoup.connect(url).get();

		Elements elements1 = doc.select(prevClosingPriceSelector);
		StringBuilder sb1 = new StringBuilder();
		for(Element m: elements1){
			sb1.append(m.ownText());
		}

		DailySummaryByStock summary = new DailySummaryByStock();
		summary.prevClosingPrice = Double.valueOf(sb1.toString());

		return summary;
	}

}
