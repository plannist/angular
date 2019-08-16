package com.prac.angular.dao;

import java.util.List;
import java.util.Map;

import com.prac.angular.common.Pageable;
import com.prac.angular.common.PaginatedList;
import com.prac.angular.entity.BuildingEntity;

public interface CustomDao<E> {
	public List<BuildingEntity> innerSelect(String address);
	public PaginatedList<E> findAll(E e, Pageable pageable, Map<String, Object>where);
	public E findOne(String id);
}
