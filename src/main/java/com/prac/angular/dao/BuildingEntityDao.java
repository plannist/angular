package com.prac.angular.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.angular.entity.BuildingEntity;

public interface BuildingEntityDao extends JpaRepository<BuildingEntity, Long> {
	List<BuildingEntity>findByAddress(String address);
	List<BuildingEntity>findByAddressContaining(String address);
}
