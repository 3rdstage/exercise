package thirdstage.exercise.spring3.account;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class Account {
	
	private static final AtomicLong nextId = new AtomicLong();
	
	private Long id;
	
	@NotNull
	@Size(min=1, max=25)
	private String name;

	@NotNull
	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal balance = new BigDecimal("1000");
	
	@NotNull
	@NumberFormat(style=Style.PERCENT)
	private BigDecimal equityAllocation = new BigDecimal("0.60");
	
	@DateTimeFormat(style="S-")
	@Future
	private Date renewalDate = new Date(new Date().getTime() + 31536000000L);

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/**
	 * @return the equityAllocation
	 */
	public BigDecimal getEquityAllocation() {
		return equityAllocation;
	}

	/**
	 * @param equityAllocation the equityAllocation to set
	 */
	public void setEquityAllocation(BigDecimal equityAllocation) {
		this.equityAllocation = equityAllocation;
	}

	/**
	 * @return the renewalData
	 */
	public Date getRenewalDate() {
		return renewalDate;
	}
	

	/**
	 * @param renewalData the renewalData to set
	 */
	public void setRenewalDate(Date renewalDate) {
	}
	
	Long assignId(){
		this.id = nextId.incrementAndGet();
		return this.id;
	}
	
	
	
	
}
