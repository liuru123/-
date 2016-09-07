package com.example.model;

public class User {
	private int User_Id;
	private String User_Password;
	private String User_Name;
	private String User_Nickname;				//昵称
	private String User_Address;				//	家庭住址
	private String User_Company;
	private String User_IDNum;					//身份证
	private String User_Sex;
	private String User_Tel;
	private int    User_DriLicense;				//驾照
	public int getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(int User_Id) {
		this.User_Id = User_Id;
	}
	public String getUser_Password() {
		return User_Password;
	}
	public void setUser_Password(String user_Password) {
		User_Password = user_Password;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getUser_Nickname() {
		return User_Nickname;
	}
	public void setUser_Nickname(String user_Nickname) {
		User_Nickname = user_Nickname;
	}
	public String getUser_Address() {
		return User_Address;
	}
	public void setUser_Address(String user_Address) {
		User_Address = user_Address;
	}
	public String getUser_Company() {
		return User_Company;
	}
	public void setUser_Company(String user_Company) {
		User_Company = user_Company;
	}
	public String getUser_IDNum() {
		return User_IDNum;
	}
	public void setUser_IDNum(String user_IDNum) {
		User_IDNum = user_IDNum;
	}
	public String getUser_Sex() {
		return User_Sex;
	}
	public void setUser_Sex(String user_Sex) {
		User_Sex = user_Sex;
	}
	public String getUser_Tel() {
		return User_Tel;
	}
	public void setUser_Tel(String user_Tel) {
		User_Tel = user_Tel;
	}
	public int getUser_DriLicense() {
		return User_DriLicense;
	}
	public void setUser_DriLicense(int user_DriLicense) {
		User_DriLicense = user_DriLicense;
	}
}