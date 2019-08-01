package com.prac.angular.dao;

import org.springframework.core.GenericTypeResolver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomDaoSupport<E> {
	private Class<E> type;
	//private E e;
	
	public CustomDaoSupport(Class<E> type) {
		this.type = type;
//		this.persistentClass = (Class<E>) GenericTypeResolver.resolveTypeArgument(getClass(), CustomDaoSupport.class);
		log.debug("customDao 생성자에서 type 확인:", type.getName());
	}
	
	public String getClassName() {
		return type.getName();
	}
}
