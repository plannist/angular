package com.prac.angular.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.prac.angular.common.Pageable;
import com.prac.angular.common.Paginated;
import com.prac.angular.common.PaginatedList;
import com.prac.angular.entity.BuildingEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CustomDaoImpl<E> implements CustomDao<E>  {

	@PersistenceContext
	EntityManager entity;
	
	private Class<E> type;
	
//	@Resource(name="sessionFactory")
//	SessionFactory sessionFactory;
	

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

	//결국 이방법은 예전 hibernate 방식이다. em객체에서 CriteriaQuery 를 생성하는 위 innerSelect 방식을 추천하는구나.
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Override
//	public PaginatedList<E> findAll(E e, Pageable pageable) {
//		Session session = sessionFactory.getCurrentSession();
//		
//		CustomDaoSupport<E> support = new CustomDaoSupport(e.getClass());
//		@SuppressWarnings("deprecation")
//		Criteria  criteria = session.createCriteria(support.getClassName());
//		int firstResult = pageable.getOffset();
//		int lastResult = pageable.getSize();
//		long total = ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).longValue();
//		criteria.setFirstResult(firstResult);
//		criteria.setMaxResults(lastResult);
//		List<E> list = (List<E>) criteria.list();
//		
//		return new PaginatedList(list, pageable, total);
//	}
	
	//이방법을 사용하자
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public PaginatedList<E> findAll(E e, Pageable pageable) {
		CriteriaBuilder builder = entity.getCriteriaBuilder();
		CriteriaQuery<E> criteria =  (CriteriaQuery<E>) builder.createQuery(e.getClass());
		Root<E> root = (Root<E>) criteria.from(e.getClass());
		CriteriaQuery<E> select = criteria.select(root);
		select.orderBy(builder.desc(root.get("buRdate")));
		//데이터 조회할 필드명 입력. rownum은 해당없음...
		//select.select(root.get("rownum"));
		TypedQuery<E> typedQuery = entity.createQuery(select);
		int firstResult = pageable.getOffset();
		int maxResult = pageable.getSize();
		typedQuery.setFirstResult(firstResult);
		typedQuery.setMaxResults(maxResult);
		List<E> resultList = typedQuery.getResultList();
		
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		countQuery.select(builder.count(countQuery.from(e.getClass())));
		long total = entity.createQuery(countQuery).getSingleResult();
		return new PaginatedList(resultList, pageable, total);
	}
	
	@Override
	public E findOne (String id) {
		Session session = (Session)entity.getDelegate();
//		Criteria  criteria = session.createCriteria(persistentClass);
//		criteria.setResultTransformer(Transformers.aliasToBean(persistentClass));
//		return (E)criteria.uniqueResult();
		return null;
	}
	


}
