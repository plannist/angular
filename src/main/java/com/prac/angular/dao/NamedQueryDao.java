package com.prac.angular.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.prac.angular.entity.BuildingEntity;

@Repository
public class NamedQueryDao {
	@PersistenceContext
	EntityManager entity;
	
	public BuildingEntity findJoinPrice() {
		return entity.createNamedQuery("Building.findJoinPrice", BuildingEntity.class).getSingleResult();
	}
}
