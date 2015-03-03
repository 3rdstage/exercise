package thirdstage.exercise.spring.case13;

/**
 * @author  3rdstage
 */
public class Name {

	/**
	 * @uml.property  name="first"
	 */
	private String first;
	/**
	 * @uml.property  name="last"
	 */
	private String last;
	/**
	 * @return
	 * @uml.property  name="first"
	 */
	public String getFirst() {
		return first;
	}
	/**
	 * @param first
	 * @uml.property  name="first"
	 */
	public void setFirst(String first) {
		this.first = first;
	}
	/**
	 * @return
	 * @uml.property  name="last"
	 */
	public String getLast() {
		return last;
	}
	/**
	 * @param last
	 * @uml.property  name="last"
	 */
	public void setLast(String last) {
		this.last = last;
	}
	
	@Override
	public String toString(){
		return first + " " + last;
	}
	
}
