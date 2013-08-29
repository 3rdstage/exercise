package thirdstage.finance.stock.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import thirdstage.finance.stock.daos.StockCodeDao;
import thirdstage.finance.stock.entities.StockCode;

public class MainServiceImpl implements MainService {
	
	private StockCodeDao stockCodeDao;
	
	public void setStockCodeDao(@Nonnull StockCodeDao dao){
		this.stockCodeDao = dao;
	}
	
	protected StockCodeDao getStockCodeDao(){ return this.stockCodeDao; }
	
	
	@Override
	public void updateStockCodes(File f, String charSet) throws Exception{
		
		Document doc = Jsoup.parse(f, charSet);

		Elements stocks = doc.select("body table tr:gt(0)");
		Element stock = null;
		List<StockCode> codes = new ArrayList<StockCode>(stocks.size());
		for(int i = 0, n = stocks.size(); i < n; i++){
			stock = stocks.get(i);
			codes.add(new StockCode(
					stock.child(3).ownText(), /* code */
					stock.child(4).ownText(), /* shortCode */
					"", /* name */
					stock.child(1).ownText(), /* issue */
					stock.child(2).ownText(), /* issueInEng */
					stock.child(0).ownText(), /* issuerCode */
					stock.child(5).ownText() /* marketType */
					)
			);
		}
		
		
	}

}
