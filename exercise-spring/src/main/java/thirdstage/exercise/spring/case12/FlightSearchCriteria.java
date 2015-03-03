package thirdstage.exercise.spring.case12;

import java.util.Date;

/**
 * @author  3rdstage
 */
public class FlightSearchCriteria {
	
	/**
	 * @uml.property  name="departFrom"
	 */
	private String departFrom;
	/**
	 * @uml.property  name="departOn"
	 */
	private Date departOn;
	/**
	 * @uml.property  name="arriveAt"
	 */
	private String arriveAt;
	/**
	 * @uml.property  name="returnOn"
	 */
	private Date returnOn;
	/**
	 * @return
	 * @uml.property  name="departFrom"
	 */
	public String getDepartFrom() {
		return this.departFrom;
	}
	/**
	 * @param departFrom
	 * @uml.property  name="departFrom"
	 */
	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}
	/**
	 * @return
	 * @uml.property  name="departOn"
	 */
	public Date getDepartOn() {
		return this.departOn;
	}
	/**
	 * @param departOn
	 * @uml.property  name="departOn"
	 */
	public void setDepartOn(Date departOn) {
		this.departOn = departOn;
	}
	/**
	 * @return
	 * @uml.property  name="arriveAt"
	 */
	public String getArriveAt() {
		return this.arriveAt;
	}
	/**
	 * @param arriveAt
	 * @uml.property  name="arriveAt"
	 */
	public void setArriveAt(String arriveAt) {
		this.arriveAt = arriveAt;
	}
	/**
	 * @return
	 * @uml.property  name="returnOn"
	 */
	public Date getReturnOn() {
		return this.returnOn;
	}
	/**
	 * @param returnOn
	 * @uml.property  name="returnOn"
	 */
	public void setReturnOn(Date returnOn) {
		this.returnOn = returnOn;
	}
	
	

}
