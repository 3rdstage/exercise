package thirdstage.exercise.hibernate3.case5;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-01-02, 3rdstage
 * @since 2006-01-02
 */
public class EmploymentId implements java.io.Serializable{
	
	/**
	 * Creates a new instance of EmploymentId
	 */
	public EmploymentId() {
	}
	
	
		private Long employerId = null;
		private Long employeeId = null;
		
		public EmploymentId(Long employerId, Long employeeId){
			this.employerId = employerId;
			this.employeeId = employeeId;
			
		}
		
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
		
		public boolean eqauls(Object obj){ 
			//TO-DO
			return true;
		}
		
		
		public int hashCode(){
			//TO-DO
			return 0;
		}
}
