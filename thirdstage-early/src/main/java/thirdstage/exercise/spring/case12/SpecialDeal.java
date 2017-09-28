package thirdstage.exercise.spring.case12;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.util.Assert;

public class SpecialDeal {
	
	private Airport departFrom;
	private Airport arriveAt;
	private BigDecimal cost;
	private Date beginOn;
	private Date endOn;
	
	public SpecialDeal(Airport departFrom, Airport arriveAt,
			           BigDecimal cost, Date beginOn, Date endOn){
	
		this.arriveAt = arriveAt;
		this.departFrom = departFrom;
		this.cost = cost;
		this.beginOn = new Date(beginOn.getTime());
		this.endOn = new Date(endOn.getTime());
		
	}

	public Airport getDepartFrom() {
		return this.departFrom;
	}

	public Airport getArriveAt() {
		return this.arriveAt;
	}

	public BigDecimal getCost() {
		return this.cost;
	}
	
	public boolean isValidNow(){
		return this.isValidOn(new Date());
	}
	
	public boolean isValidOn(Date date){
		Assert.notNull(date, "Date must not be null.");
		Date dateCopy = new Date(date.getTime());
		return ((dateCopy.equals(beginOn) || dateCopy.after(beginOn)) 
				&& ((dateCopy.equals(endOn) || dateCopy.before(endOn))));
	}
	

}
