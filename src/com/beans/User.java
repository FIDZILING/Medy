package com.beans;

import java.util.Date;

public class User {
	private int Id;
	private String username;
	private String password;
	private String ability;
	private java.sql.Date signuptime;
	/*
	 *无参数构造方法
	 */
	
	public User() {
		
	}
	/*参数构造*/
	public User(int Id,String username,String password,String ability,java.sql.Date signuptime) {
		this.Id = Id;
		this.username = username;
		this.password = password;
		this.ability = ability;
		this.signuptime = signuptime;
	}
	public int getId() {
		return Id;
	}
	
	public void setid(int Id) {
		this.Id = Id;
	}
	
	public String getusername() {
		return username;
	}
	
	public void setname(String username) {
		this.username = username;
	}
	
	public String getpassword() {
		return password;
	}
	
	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getability() {
		return ability;
	}
	
	public void setability(String ability) {
		this.ability = ability;
	}
	
	public java.sql.Date getsignuptime() {
		return signuptime;
	}
	
	public void setsignuptime(java.sql.Date signuptime) {
		this.signuptime = signuptime;
	}
}
