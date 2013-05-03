package thirdstage.exercise.parsing.html.case1;

public class StockCode {

	private String issuerCode;

	private String issue;

	private String issueInEng;

	private String code;

	private String shortCode;

	private String marketType;

	public StockCode(){}

	public StockCode(String issuerCode, String issue, String issueInEng,
			String code, String shortCode, String marketType) {
		super();
		this.issuerCode = issuerCode;
		this.issue = issue;
		this.issueInEng = issueInEng;
		this.code = code;
		this.shortCode = shortCode;
		this.marketType = marketType;
	}

	public String getIssuerCode() {
		return issuerCode;
	}

	public void setIssuerCode(String issuerCode) {
		this.issuerCode = issuerCode;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getIssueInEng() {
		return issueInEng;
	}

	public void setIssueInEng(String issueInEng) {
		this.issueInEng = issueInEng;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getMarketType() {
		return marketType;
	}

	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}





}
