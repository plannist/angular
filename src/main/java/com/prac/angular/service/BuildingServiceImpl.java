package com.prac.angular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.angular.dao.BuildingEntityDao;
import com.prac.angular.dao.NamedQueryDao;
import com.prac.angular.entity.BuildingEntity;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	BuildingEntityDao dao;
	@Autowired
	NamedQueryDao namedDao;
	
	@Override
	public List<BuildingEntity> findByAddress(String address) {
		return dao.findByAddress(address);
	}

	@Override
	public List<BuildingEntity> findByAddressContaining(String address) {
		return dao.findByAddressContaining(address);
	}

	@Override
	public BuildingEntity findJoinPrice() {
		return namedDao.findJoinPrice();
	}

	@Override
	public List<BuildingEntity> innerSelect(String address) {
		// TODO Auto-generated method stub
		return dao.innerSelect(address);
	}

}
