package com.prac.angular.service;

import java.util.List;
import java.util.Map;

import com.prac.angular.entity.UserEntity;

public interface UserService {

	List<Map<String, Object>> getUserInfo(Map map);

	UserEntity getOne(String id);
	
	List<UserEntity> findAll();

}
