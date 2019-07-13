package com.prac.angular.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearch {
	private Long userSeq;
	private String userId;
	private String userPwd;
	private String userSex;
	private String userPtDt;
	private String userLastConnectDt;
	
	private String phonePhoneNumber;

	@Override
	public String toString() {
		return "UserSearch [userSeq=" + userSeq + ", userId=" + userId + ", userPwd=" + userPwd + ", userSex=" + userSex
				+ ", userPtDt=" + userPtDt + ", userLastConnectDt=" + userLastConnectDt + ", phonePhoneNumber="
				+ phonePhoneNumber + "]";
	}


	
	
}
