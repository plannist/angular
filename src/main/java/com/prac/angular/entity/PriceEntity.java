package com.prac.angular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="PRICE")
@Getter
@Setter
@ToString
public class PriceEntity {
	@Id
	@GeneratedValue
	@Column(name="PRICE_NO", unique=true, nullable=false)
	private Long priceNo;
	
	@Column(name="LEASE")
	private Long lease;
	
	@Column(name="SALEPRICE")
	private Long salePrice;
	
	@Column(name="MONTHLY")
	private Long monthly;
	
	@Column(name="DEPOSIT")
	private Long deposit;
	
	/**
	 * 	1. price 테이블에서 build_no는 building 테이블의 PK 를 참조한다.
	 * 	2. @ManyToOne 이란 여러개의 price가 하나의 build_no를 참조 할 수 있다.
	 * 	3. 하나의 build_no만 참조 가능하므로 멤버변수의 타입은 단일 형인 BuildingEntity 로 설정.
	 * 	4. @JoinColumn 이란 참조키란 설명이며 해당 컬럼명을 name에 적는다.
	 * (fetch=FetchType.LAZY)
	 * */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BUILD_NO")
	@JsonIgnore
	private BuildingEntity building;
	
	
}
