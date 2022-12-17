package com.bean;

public class User {
	
	private String uName;
	private String uPass;
	private String uEmail;
	private long uMob;
	
	
	public User() {}
	public User(String uName, String uPass, String uEmail, long uMob) {
		super();
		this.uName = uName;
		this.uPass = uPass;
		this.uEmail = uEmail;
		this.uMob = uMob;
	}
	
	
	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public String getuPass() {
		return uPass;
	}


	public void setuPass(String uPass) {
		this.uPass = uPass;
	}


	public String getuEmail() {
		return uEmail;
	}


	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}


	public long getuMob() {
		return uMob;
	}


	public void setuMob(long uMob) {
		this.uMob = uMob;
	}

	
	@Override
	public String toString() {
		return "User [uName=" + uName + ", uPass=" + uPass + ", uEmail=" + uEmail + ", uMob=" + uMob + "]";
	}
	
	public static void main(String[] args) {
		

	}

}
