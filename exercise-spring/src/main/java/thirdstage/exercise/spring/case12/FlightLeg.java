package thirdstage.exercise.spring.case12;

import java.util.Date;

/**
 * @author   3rdstage
 */
public class FlightLeg {
	
	private Airport departFrom;
	/**
	 * @uml.property  name="departOn"
	 */
	private Date departOn;
	private Airport arriveAt;
	/**
	 * @uml.property  name="arriveOn"
	 */
	private Date arriveOn;
	
	public FlightLeg(Airport departFrom, Date departOn, Airport arriveAt, Date arriveOn){
		this.departFrom = departFrom;
		this.departOn = departOn;
		this.arriveAt = arriveAt;
		this.arriveOn = arriveOn;
	}
	
	
	
	/**
	 * @return
	 * @uml.property  name="departFrom"
	 */
	public Airport getDepartFrom() {
		return departFrom;
	}
	/**
	 * @return
	 * @uml.property  name="departOn"
	 */
	public Date getDepartOn() {
		return departOn;
	}
	/**
	 * @return
	 * @uml.property  name="arriveAt"
	 */
	public Airport getArriveAt() {
		return arriveAt;
	}
	/**
	 * @return
	 * @uml.property  name="arriveOn"
	 */
	public Date getArriveOn() {
		return arriveOn;
	}
	
	

}
