package thirdstage.exercise.parsing.html.case1;

import java.util.Currency;
import java.util.Date;




/**
 * For more on financial glossary, refer the followings
 * <ul>
 *   <li>http://www.nasdaq.com/investing/glossary/</li>
 *   <li>http://biz.yahoo.com/f/g/</li>
 *   <li>http://www.cnbc.com/id/46644158</li>
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
	public double prevClosingPrice; //previous day's closing price, 전일 종가
	
	public double openingPrice; //today's opening  price, 시가
	
	public double closingPrice; //today's closing or current price, 종가
	
	public long volume; //volume, 거래량
	
	public double dailyHighPrice; //today's highest price, 당일 고가
	
	public double dailyLowPrice; //today's lowest price, 당일 저가
	
	public double limitUp; //today's limit up, 상한가
	
	public double limitDown; //today's limit down, 하한가

	
	//statistical or non-daily data
	public double marketCap; //market capitalization, 시가총액 
	
	public long outstanding; //상장주식수
	
	public double highPrice; //52주 최고
	
	public double lowPrice; //52주 최저
	
	public double per; //PER - 
	
	public double eps; //EPS
	
	public double pbr; //PBR
	
	public double foreignerRatio; //외국인 보유율
	
	
	public String toString(){
		StringBuilder sb = new StringBuilder().append("[")
			.append("Stock code : ").append(this.stockCode).append(", ")
			.append("Date : ").append(this.date).append(", ")
			.append("Prev. closing price : ").append(this.prevClosingPrice).append(", ")
			.append("Today closing price : ").append(this.closingPrice).append(", ")
			.append("Opening price : ").append(this.openingPrice).append(", ")
			.append("Daily high price : ").append(this.dailyHighPrice).append(", ")
			.append("Daily low price : ").append(this.dailyLowPrice).append(", ")
			.append("Volume : ").append(this.volume)
			.append("]");
		
		return sb.toString();
	}

}
