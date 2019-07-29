package com.prac.angular.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.prac.angular.common.PageRequest;
import com.prac.angular.common.PaginatedList;
import com.prac.angular.entity.BuildingEntity;
import com.prac.angular.model.BuildingVO;

public interface BuildingService {
	List<BuildingEntity> findByAddress(String address);
	List<BuildingEntity> findByAddressContaining(String address);
	BuildingEntity findJoinPrice();
	List<BuildingEntity> innerSelect(String address);
	PaginatedList<BuildingEntity> findAllByPaginated(BuildingVO vo, PageRequest request);
}
