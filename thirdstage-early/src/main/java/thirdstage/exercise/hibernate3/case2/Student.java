package thirdstage.exercise.hibernate3.case2;

import java.util.List;
/**
 * Hibernate Many-to-Many Collection Mapping Example 
 * 
 * @author 3rdstage
 * @version 1.0, 2005-11-17, 3rdstage
 * @since 2005-11-17
 * @see Course
 *
 * @hibernate.class table="Student" comment="학생 Master"
 */
public class Student {
	
	private String id = null;
	private String name = null;
	private List courses = null;
	
	/**
	 * Creates a new instance of Student
	 */
	public Student() {
	}
	
	/**
	 * @hibernate.id column="id" length="16" generator-class="assigned" unsaved-value="null"
	 */
	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @hibernate.property column="name" length="60"
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @hibernate.list table="StudentCourseMap" cascade="save-update" comment="수강"
	 * @hibernate.collection-many-to-many class="thirdstage.exercise.hibernate3.case2.Course" column="courseId" foreign-key="fk_studentcoursemap_1"
	 * @hibernate.collection-key column="studentId" foreign-key="fk_studentcoursemap_2"
	 * @hibernate.collection-index column="courseId"
	 */
	public List getCourses(){ return this.courses; }
	public void setCourses(List courses){ this.courses = courses; }
	
	
	
}
