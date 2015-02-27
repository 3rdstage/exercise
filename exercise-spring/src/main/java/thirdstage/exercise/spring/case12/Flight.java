package thirdstage.exercise.spring.case12;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.util.Assert;

/**
 * @author  3rdstage
 */
public class Flight {
	
	private java.util.List<FlightLeg> legs;
	/**
	 * @uml.property  name="totalCost"
	 */
	private BigDecimal totalCost;
	
	public Flight(java.util.List<FlightLeg> legs, BigDecimal totalCost){
		
		Assert.notNull(legs);
		Assert.isTrue(legs.size() >= 1, "Flight must have at least one leg");
		this.legs = legs;
		this.totalCost = totalCost;
	}
	
	
	/**
	 * @return
	 * @uml.property  name="totalCost"
	 */
	public BigDecimal getTotalCost(){
		return this.totalCost;
	}
	
	
	public boolean isNonStop(){ return (legs.size() == 1); }
	
	private FlightLeg getFirstLeg(){ return this.legs.get(0); }
	private FlightLeg getLastLeg(){ return this.legs.get(legs.size() - 1); }
	
	public Airport getDepartFrom(){
		return this.getFirstLeg().getDepartFrom();
	}
	
	public Airport getArriveAt(){
		return this.getLastLeg().getArriveAt();
	}
	
	public int getNumberOfLegs(){
		return this.legs.size();
	}
	
	public long getTotalTravelTime(){
		Date start = this.getFirstLeg().getDepartOn();
		Date end = this.getLastLeg().getArriveOn();
		
		Assert.isTrue(end.compareTo(start) > 0, "Start date must be before end date");
		return (end.getTime() - start.getTime());
	}
	
	
	

}
