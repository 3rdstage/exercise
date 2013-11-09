package thirdstage.exercise.spring.case12;

import java.util.Date;

public class FlightSearchCriteria {
	
	private String departFrom;
	private Date departOn;
	private String arriveAt;
	private Date returnOn;
	public String getDepartFrom() {
		return this.departFrom;
	}
	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}
	public Date getDepartOn() {
		return this.departOn;
	}
	public void setDepartOn(Date departOn) {
		this.departOn = departOn;
	}
	public String getArriveAt() {
		return this.arriveAt;
	}
	public void setArriveAt(String arriveAt) {
		this.arriveAt = arriveAt;
	}
	public Date getReturnOn() {
		return this.returnOn;
	}
	public void setReturnOn(Date returnOn) {
		this.returnOn = returnOn;
	}
	
	

}
