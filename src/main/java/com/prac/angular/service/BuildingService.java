package com.prac.angular.service;

import java.util.List;

import com.prac.angular.entity.BuildingEntity;

public interface BuildingService {
	List<BuildingEntity> findByAddress(String address);
	List<BuildingEntity> findByAddressContaining(String address);
	BuildingEntity findJoinPrice();
	List<BuildingEntity> innerSelect(String address);
}
