package com.mini.javaProject.server;

import java.io.Serializable;
import java.sql.Timestamp;

public class UsersDTO implements Serializable {
	
	private String id;
	private String pw;
	private String name;
	private String nickName;
	private int phoneNumber;
	private Timestamp becomingDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Timestamp getBecomingDate() {
		return becomingDate;
	}
	public void setBecomingDate(Timestamp becomingDate) {
		this.becomingDate = becomingDate;
	}

	@Override
	public String toString() {
		return "UsersDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", nickName=" + nickName + ", phoneNumber="
				+ phoneNumber + ", becomingDate=" + becomingDate + "]";
	}
}
