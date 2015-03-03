package thirdstage.finance.stock.entities;

public class StockCode {

	private String code;

	private String shortCode;

	private String name;

	private String issue;

	private String issueInEng;

	private String issuerCode;

	private String marketType;

	public StockCode(){}

	public StockCode(String code, String shortCode, String name, 
			String issue, String issueInEng, String issuerCode,
			String marketType) {
		super();
		this.code = code;
		this.shortCode = shortCode;
		this.name = name;
		this.issue = issue;
		this.issueInEng = issueInEng;
		this.issuerCode = issuerCode;
		this.marketType = marketType;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the shortCode
	 */
	public String getShortCode() {
		return shortCode;
	}

	/**
	 * @param shortCode the shortCode to set
	 */
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the issue
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * @param issue the issue to set
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

	/**
	 * @return the issueInEng
	 */
	public String getIssueInEng() {
		return issueInEng;
	}

	/**
	 * @param issueInEng the issueInEng to set
	 */
	public void setIssueInEng(String issueInEng) {
		this.issueInEng = issueInEng;
	}

	/**
	 * @return the issuerCode
	 */
	public String getIssuerCode() {
		return issuerCode;
	}

	/**
	 * @param issuerCode the issuerCode to set
	 */
	public void setIssuerCode(String issuerCode) {
		this.issuerCode = issuerCode;
	}

	/**
	 * @return the marketType
	 */
	public String getMarketType() {
		return marketType;
	}

	/**
	 * @param marketType the marketType to set
	 */
	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}






}
