package com.prac.angular.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prac.angular.dao.UserEntityDao;
import com.prac.angular.entity.PhoneEntity;
import com.prac.angular.entity.UserEntity;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
	@Autowired
	UserEntityDao dao;
	@Autowired
	BCryptPasswordEncoder encoder;
	@PersistenceContext
	EntityManager entity;
	
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
	
	@Override
	public void emSave(UserEntity vo) {
//		List<PhoneEntity> list = (List<PhoneEntity>) vo.getPhone();
//		for(PhoneEntity data : list) {
//			entity.persist(data);
//		}
		entity.persist(vo);
	}
}
