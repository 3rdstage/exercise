package anyframe.exercise.domain;

public class User{
	
	private String userId;
	
	private String userName;
	
	private String password;
	
	private String birthDay;
	
	private String cellPhone;
	
	private String addr;

	public User(){
		super();
	}

	/**
	 * @return the userId
	 */
	public String getUserId(){
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName(){
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword(){
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password){
		this.password = password;
	}

	/**
	 * @return the birthDay
	 */
	public String getBirthDay(){
		return birthDay;
	}

	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(String birthDay){
		this.birthDay = birthDay;
	}

	/**
	 * @return the cellPhone
	 */
	public String getCellPhone(){
		return cellPhone;
	}

	/**
	 * @param cellPhone the cellPhone to set
	 */
	public void setCellPhone(String cellPhone){
		this.cellPhone = cellPhone;
	}

	/**
	 * @return the addr
	 */
	public String getAddr(){
		return addr;
	}

	/**
	 * @param addr the addr to set
	 */
	public void setAddr(String addr){
		this.addr = addr;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder(100).append("ID : ").append(this.getUserId())
			.append(", Name : ").append(this.getUserName());
		return sb.toString();
	}
	
	

}
