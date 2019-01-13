package com.prac.angular.model.define;

public enum User {
	NAME("박종석"),
	EMAIL("plannist@naver.com"),
	ID("plannist");
	
	private String info;
	
	private User (String info) {
		this.info = info;
	}
	
	public String getInfo() {
		return info;
	}
}
