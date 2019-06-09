package com.prac.angular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="PHONE")
@Data
public class PhoneEntity {
	@Id
	@GeneratedValue
	@Column(name="SEQ")
	private Long seq;
	
	@Column(name="ID")
	private String id;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	
	
}
