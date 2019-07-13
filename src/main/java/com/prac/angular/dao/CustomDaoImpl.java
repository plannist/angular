<<<<<<< HEAD
package com.prac.angular.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prac.angular.entity.BuildingEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CustomDaoImpl implements CustomDao {
	


	@PersistenceContext
	EntityManager entity;


	@Override
	public List<BuildingEntity> innerSelect(String address) {
		CriteriaBuilder builder = entity.getCriteriaBuilder();
		CriteriaQuery<BuildingEntity> criteria = builder.createQuery(BuildingEntity.class);
		Root<BuildingEntity> root = criteria.from(BuildingEntity.class);
		criteria.select(root);
		criteria.where(builder.like(root.get("address"), "%"+address+"%"));
		List<BuildingEntity>list = entity.createQuery(criteria).getResultList();
		log.debug("hi@@@@@@@@@@@@@@@@@@@@: {}", list.size());
		return list;
	}

}
=======
package com.prac.angular.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prac.angular.entity.BuildingEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CustomDaoImpl implements CustomDao {
	


	@PersistenceContext
	EntityManager entity;


	@Override
	public List<BuildingEntity> innerSelect(String address) {
		CriteriaBuilder builder = entity.getCriteriaBuilder();
		CriteriaQuery<BuildingEntity> criteria = builder.createQuery(BuildingEntity.class);
		Root<BuildingEntity> root = criteria.from(BuildingEntity.class);
		criteria.select(root);
		criteria.where(builder.like(root.get("address"), "%"+address+"%"));
		List<BuildingEntity>list = entity.createQuery(criteria).getResultList();
		log.debug("hi@@@@@@@@@@@@@@@@@@@@: {}", list.size());
		return list;
	}

}
>>>>>>> branch 'master' of https://github.com/plannist/angular.git
