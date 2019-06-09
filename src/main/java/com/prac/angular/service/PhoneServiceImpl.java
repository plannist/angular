package com.prac.angular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prac.angular.dao.PhoneEntityDao;
import com.prac.angular.entity.PhoneEntity;

@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {
	@Autowired
	PhoneEntityDao dao;
	
	@Override
	public PhoneEntity getOne(Long id) {
		return dao.getOne(id);
	}
	
}
