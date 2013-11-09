package thirdstage.exercise.hibernate3.case7;


/**
 *
 * @author 3rdstage
 * @hibernate.class table="Customer7" schema="test"
 */
public class Customer {

	private Long id = null;
	private String residentsNo = null;
	private String telephoneNo = null;
	private String address = null;
	private java.util.Date entryDate = null;

	
	/** Creates a new instance of Customer */
	public Customer() {}

	/**
	 * @hibernate.id column="id" generator-class="native"
	 */
	public Long getId() { return this.id;}
	public void setId(Long id) { this.id = id; }

	/**
	 * @hibernate.property column="residentsno" type="string"
	 * @hibernate.column name="residentsno" sql-type="vachar" length="13" not-null="false" 
	 *                   unique="true" index="idx_customer7_1" comment="주민등록번호"
	 */
	public String getResidentsNo() { return residentsNo; }
	public void setResidentsNo(String residentsNo) { this.residentsNo = residentsNo; }

	/**
	 * @hibernate.property column="telno" type="string"
	 * @hibernate.column name="telno" sql-type="vachar" length="16" not-null="false" 
	 *                   unique="false" comment="전화번호"
	 */
	public String getTelephoneNo() { return telephoneNo; }
	public void setTelephoneNo(String telephoneNo) { this.telephoneNo = telephoneNo; }

	/**
	 * @hibernate.property column="address" type="string"
	 * @hibernate.column name="address" sql-type="vachar" length="100" not-null="false" 
	 *                   unique="false" comment="주소"
	 */
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }

	/**
	 * @hibernate.property column="entrydate" type="date"
	 * @hibernate.column name="entrydate" sql-type="date" not-null="false" 
	 *                   unique="false" comment="가입일"
	 */
	public java.util.Date getEntryDate() { return entryDate; }
	public void setEntryDate(java.util.Date entryDate) { this.entryDate = entryDate;	}
	
}
