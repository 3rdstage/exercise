package thirdstage.exercise.hibernate3.case5;


/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-01-02, 3rdstage
 * @since 2006-01-02
 *
 * @hibernate.class table="Employment5" comment="고용"
 * @hibernate.mapping auto-import="false"
 */
public class Employment {
	
	private EmploymentId id = null;
	private Employer employer = null;
	private Employee employee = null;
	
	
	/**
	 * Creates a new instance of Employment
	 */
	public Employment() {
	}
	
	/**
	 * @hibernate.composite-id
	 */
	public EmploymentId getId(){ return this.id; }
	public void setId(EmploymentId id){ this.id = id; }
	
	
	/**
	 * @hibernate.many-to-one column="employerId"
	 *                        class="thirdstage.exercise.hibernate3.case5.Employer"
	 *                        foreign-key="fk_employment_1"
	 *                        not-null="true"
	 *                        lazy="false"
	 */
	public Employer getEmployer(){ return this.employer; }
	public void setEmployer(Employer employer){ this.employer = employer; }
	
	/**
	 * @hibernate.many-to-one column="employeeId"
	 *                        class="thirdstage.exercise.hibernate3.case5.Employee"
	 *                        foreign-key="fk_employment_2"
	 *                        not-null="true"
	 *                        lazy="false"
	 */
	public Employee getEmployee(){ return this.employee; }
	public void setEmployee(Employee employee){ this.employee = employee; }
	
	
	public static class EmpId{
		
		private Long employerId = null;
		private Long employeeId = null;
		
		public EmpId(){}
		
		/**
		 * @hibernate.key-property column="employerId" type="long"
		 */
		public Long getEmployerId(){ return this.employerId; }
		public void setEmployerId(Long id){ this.employerId = id; }
		
		/**
		 * @hibernate.key-property column="employeeId" type="long"
		 */
		public Long getEmployeeId(){ return this.employeeId; }
		public void setEmployeeId(Long id){ this.employeeId = id; }
		
		
	}
	
	
}
