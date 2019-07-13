package com.prac.angular.service;

import java.util.ArrayList;
import java.util.Collection;
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
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {
	@Autowired
	UserEntityDao dao;
	@Autowired
	BCryptPasswordEncoder encoder;
<<<<<<< HEAD
	@PersistenceContext
	EntityManager entityManager;
=======
>>>>>>> branch 'master' of https://github.com/plannist/angular.git
	
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
<<<<<<< HEAD

	@Override
	public void parsist(UserEntity vo) {
		Collection<PhoneEntity> col = new ArrayList<>();
		col = vo.getPhone();
		vo.setPhone(null);
		entityManager.persist(vo);
		for(PhoneEntity phone : col) {
			phone.setUsers(vo);
			entityManager.persist(phone);
		}
		
	}
=======
>>>>>>> branch 'master' of https://github.com/plannist/angular.git
}
