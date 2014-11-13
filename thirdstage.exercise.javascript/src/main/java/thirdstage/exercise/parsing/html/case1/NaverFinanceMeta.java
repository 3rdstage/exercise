package thirdstage.exercise.parsing.html.case1;

public class NaverFinanceMeta {

	//@todo Use templating or expression language such and SPEL or FreeMarker

	public static class StockDailySummary{

		public static final String URL_FORMAT = "http://finance.naver.com/item/main.nhn?code=%1$s";

		public static final String SELECTOR_PREV_CLOSING_PRICE = "#chart_area div.rate_info";
	}

}
