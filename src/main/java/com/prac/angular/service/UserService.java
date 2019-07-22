package com.prac.angular.service;

import java.util.List;
import java.util.Map;

import com.prac.angular.entity.UserEntity;

public interface UserService {

	List<Map<String, Object>> getUserInfo(Map map);

	UserEntity getOne(Long seq);
	
	List<UserEntity> findAll();

	void save(UserEntity vo);

	String passwordEncoding(UserEntity vo);

	void parsist(UserEntity vo);

	UserEntity findById(String id);

}
