package com.prac.angular.dao;

import java.util.List;

import com.prac.angular.entity.BuildingEntity;

public interface CustomDao {
	public List<BuildingEntity> innerSelect(String address);
}
