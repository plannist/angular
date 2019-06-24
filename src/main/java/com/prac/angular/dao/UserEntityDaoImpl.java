package com.prac.angular.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.prac.angular.entity.UserEntity;

//@Repository
//public abstract class UserEntityDaoImpl extends HibernateDaoSupport implements UserEntityDao, JpaRepository<UserEntity, Long>  {
//
//	@Autowired
//	public UserEntityDaoImpl(SessionFactory sessionFactory) {
//		setSessionFactory(sessionFactory);
//	}
//	
//	@Override
//	public UserEntity findOne(String id) {
//		System.out.println("daoImpl 인입 확인:@@");
//		return null;
//	}
//}
