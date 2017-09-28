
package thirdstage.sample.insurance.values;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005년 10월 23일 (일)
 * @since 2005년 10월 23일 (일)
 */
public class IndividualNormalValue implements thirdstage.framework.mars.Value{
	
	private String id = "";
	private String firstName = "";
	private String lastName = "";
	
	
	/** Creates a new instance of IndividualNormalValue */
	public IndividualNormalValue() {
	}
	
	public IndividualNormalValue(String id, String firstName, String lastName){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
