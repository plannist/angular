package com.prac.angular.model;

import java.time.LocalDateTime;

import com.prac.angular.model.define.User;

import lombok.Data;

@Data
public class UserVO {
	private String name;
	private String id;
	private String pwd;
	private String email;
	private LocalDateTime regDate;

	
}
