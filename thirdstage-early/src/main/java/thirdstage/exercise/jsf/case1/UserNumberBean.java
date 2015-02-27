/*
 * UserNumberBean.java
 *
 * Created on 2005-01-09
 */

package thirdstage.exercise.jsf.case1;

/**
 *
 * @author  3rdstage
 */
public class UserNumberBean {
	private Integer userNumber = null;
	private long maximum = 0;
	private long minimum = 0;
	
	private Integer randomNumber = new Integer((new java.util.Random()).nextInt());
	 
	/** Creates a new instance of UserNumberBean */
	public UserNumberBean() {
	}
	
	public Integer getUserNumber(){
		 return userNumber;
	}
	
	public void setUserNumber(Integer userNo){
		 this.userNumber = userNo;
	}
	
	public String getResponse(){
		 if(this.userNumber != null && this.userNumber.compareTo(randomNumber) == 0){
			  return "Yay! You got it!";
		 }
		 else{
			  return "Sorry, " + this.userNumber + " is incorrect.";
		 }
	}
	
	public long getMaximum(){ return this.maximum; }
	public void setMaximum(long max){ this.maximum = max; }
	public long getMinimum(){ return this.minimum; }
	public void setMinimum(long min){ this.minimum = min; }
	
	
}
