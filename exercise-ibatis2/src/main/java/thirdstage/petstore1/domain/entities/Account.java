package thirdstage.petstore1.domain.entities;

import java.io.Serializable;

public class Account implements Serializable{

	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String status;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String phone;
	private String favoriteCategoryId;
	private String languagePreference;
	private boolean listOption;
	private boolean bannerOption;
	private String bannerName;

	public Account(){}
	
	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getStatus(){
		return status;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getCity(){
		return city;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getState(){
		return state;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getZip(){
		return zip;
	}

	public void setZip(String zip){
		this.zip = zip;
	}

	public String getCountry(){
		return country;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getPhone(){
		return phone;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getFavoriteCategoryId(){
		return favoriteCategoryId;
	}

	public void setFavoriteCategoryId(String favoriteCategoryId){
		this.favoriteCategoryId = favoriteCategoryId;
	}

	public String getLanguagePreference(){
		return languagePreference;
	}

	public void setLanguagePreference(String languagePreference){
		this.languagePreference = languagePreference;
	}

	public boolean isListOption(){
		return listOption;
	}

	public void setListOption(boolean listOption){
		this.listOption = listOption;
	}

	public int getListOptionAsInt(){
		return this.listOption ? 1 : 0;
	}

	public boolean isBannerOption(){
		return bannerOption;
	}

	public void setBannerOption(boolean bannerOption){
		this.bannerOption = bannerOption;
	}

	public int getBannerOptionAsInt(){
		return this.bannerOption ? 1 : 0;
	}

	public String getBannerName(){
		return this.bannerName;
	}

	public void setBannerName(String bannerName){
		this.bannerName = bannerName;
	}

	public String getAddress1(){
		return address1;
	}

	public void setAddress1(String address1){
		this.address1 = address1;
	}

	public String getAddress2(){
		return address2;
	}

	public void setAddress2(String address2){
		this.address2 = address2;
	}

}
