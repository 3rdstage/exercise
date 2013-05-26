package thirdstage.exercise.parsing.html.case1;

import java.util.Currency;
import java.util.Date;




/**
 * For more on financial glossary, refer the followings
 * <ul>
 *   <li>http://www.nasdaq.com/investing/glossary/</li>
 *   <li>http://biz.yahoo.com/f/g/</li>
 * </ul>
 * 
 * @author 3rdstage
 *
 */
public class DailySummaryByStock {
	
	public String stockCode;
	
	public Date date;
	
	public Currency currency;
	
	//daily trading data 
	public double prevClosingPrice; //전일 종가
	
	public double openingPrice; //시가
	
	public double closingPrice; //종가
	
	public long volume; //거래량
	
	public double dailyHighPrice; //당일 고가
	
	public double dailyLowPrice; //당일 저가
	
	//statistical or non-daily data
	public double marketCap; //시가총액 Market Capitalization
	
	public long outstanding; //상장주식수
	
	public double highPrice; //52주 최고
	
	public double lowPrice; //52주 최저
	
	public double per; //PER - 
	
	public double eps; //EPS
	
	public double pbr; //PBR
	
	public double foreignerRatio; //외국인 보유율
	
	
	public String toString(){
		StringBuilder sb = new StringBuilder()
			.append("Stock code : ").append(this.stockCode).append(", ")
			.append("Date : ").append(this.date).append(", ")
			.append("Prev. closing price : ").append(this.prevClosingPrice);
		
		return sb.toString();
	}

}
