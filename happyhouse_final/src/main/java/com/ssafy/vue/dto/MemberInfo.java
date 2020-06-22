package com.ssafy.vue.dto;

public class MemberInfo {
	private String id;
	private String pass;
	private String name; 
	private String address; 
	private String phonenum;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	@Override
	public String toString() {
		return "MemberInfo [id=" + id + ", pass=" + pass + ", name=" + name + ", address=" + address + ", phonenum="
				+ phonenum + "]";
	}
	
	
}
