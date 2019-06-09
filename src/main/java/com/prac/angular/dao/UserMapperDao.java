package com.prac.angular.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prac.angular.mapper.UserMapper;

@Repository
public class UserMapperDao {
	@Autowired
	UserMapper userMapper;
	
	public List<Map<String, Object>> getUserInfo(Map map){
		return userMapper.getUserInfo(map);
	}
}
