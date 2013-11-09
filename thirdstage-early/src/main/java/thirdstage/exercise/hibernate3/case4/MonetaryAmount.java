package thirdstage.exercise.hibernate3.case4;


import java.util.Currency;
import java.math.BigDecimal;
/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-12-30, 3rdstage
 * @since 2005-12-30
 */
public class MonetaryAmount {
	
	private BigDecimal amount = null;
	private Currency currency = null;
	
	/**
	 * Creates a new instance of MonetaryAmount
	 */
	public MonetaryAmount() {
	}

	/**
	 * @hibernate.property type="double"
	 * @hibernate.column name="amount"
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @hibernate.property length="16"
	 * @hibernate.column name="currency"
	 */
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	
	
}
