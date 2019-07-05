package com.prac.angular.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prac.angular.dao.UserEntityDao;
import com.prac.angular.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserEntityDao dao;
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public List<Map<String, Object>> getUserInfo(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity getOne(Long seq) {
		return dao.getOne(seq);
		
	}

	@Override
	public List<UserEntity> findAll() {
		return dao.findAll();
	}

	@Override
	public void save(UserEntity vo) {
		dao.save(vo);
		
	}

	@Override
	public String passwordEncoding(UserEntity vo) {
		// TODO Auto-generated method stub
		return encoder.encode(vo.getPwd());
	}
}
