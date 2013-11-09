
package thirdstage.sample.insurance.entities;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005년 11월 2일 (수)
 * @since 2005년 11월 2일 (수)
 *
 * @hibernate.subclass discriminator-value="LEA"
 */
public class Lease extends Right{
	
	/**
	 * duration for this lease in days
	 */
	private int duration = 0;
	
	/** Creates a new instance of Lease */
	public Lease() {
	}
	
	/**
	 * @hibernate.property name="duration" column="duration" type="integer" length="8"
	 */
	public int getDuration(){ return this.duration; }
	public void setDuration(int duration){ this.duration = duration; }
}
