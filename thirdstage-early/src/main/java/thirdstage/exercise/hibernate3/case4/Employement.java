package thirdstage.exercise.hibernate3.case4;


import java.util.Date;
/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-12-29, 3rdstage
 * @since 2005-12-29
 *
 * @hibernate.class table="Employment4"
 */
public class Employement {
	
	private Long id = null;
	private Date startDate = null;
	private Date endDate = null;
	private Employer employer = null;
	private Employee employee = null;
	private MonetaryAmount hourlyRate = null;
	
	
	/**
	 * Creates a new instance of Employement
	 */
	public Employement() {
	}

	/**
	 * @hibernate.id column="id" generator-class="native"
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @hibernate.property column="startDate"
	 */
	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @hibernate.property column="endDate"
	 */
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @hibernate.many-to-one column="employerId"
	 *                        foreign-key="fk_employment_1"
	 *                        not-null="true"
	 */
	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	/**
	 * @hibernate.many-to-one column="employeeId"
	 *                        foreign-key="fk_employment_2"
	 *                        not-null="true"
	 */
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @hibernate.component prefix="hourly"
	 */
	public MonetaryAmount getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(MonetaryAmount hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
}
