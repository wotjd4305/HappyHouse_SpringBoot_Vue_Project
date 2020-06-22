package com.ssafy.vue.dto;

public class MemberLoginDTO {
	
	private String id;
	private String pass;
	
	
	
	public MemberLoginDTO(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "MemberLoginDTO [id=" + id + ", pass=" + pass + "]";
	}
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
	
	
	

	
}
