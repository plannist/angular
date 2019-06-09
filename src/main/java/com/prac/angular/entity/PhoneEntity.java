package com.prac.angular.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PHONE")
@Getter
@Setter
public class PhoneEntity {
	@Id
	@GeneratedValue
	@Column(name="SEQ")
	private Long seq;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="USER_ID")
	private UserEntity user;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	
	
}
