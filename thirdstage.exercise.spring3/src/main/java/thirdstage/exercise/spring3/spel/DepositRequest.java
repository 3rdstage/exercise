package thirdstage.exercise.spring3.spel;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class is immutable.
 * 
 * @author 3rdstage
 *
 */
public class DepositRequest {
	
	private static AtomicInteger counter = new AtomicInteger(1);
	
	private String client;

	private String accountNo;
	
	private double amount;
	
	private int sequence;
	
	private Date date;
	
	public DepositRequest(String client, String accNo, double amt){
		this.client = client;
		this.accountNo = accNo;
		this.amount = amt;
		
		this.sequence = counter.getAndIncrement();
		this.date = new java.util.Date();
	}

	public String getClient() {
		return client;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public double getAmount() {
		return amount;
	}

	public int getSequence() {
		return sequence;
	}

	public Date getDate() {
		return date;
	}

	
}
