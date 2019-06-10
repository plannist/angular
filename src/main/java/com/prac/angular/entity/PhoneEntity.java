package com.prac.angular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name="USER_SEQ")
	private Long userSeq;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;

	@Override
	public String toString() {
		return "PhoneEntity [seq=" + seq + ", userSeq=" + userSeq + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
}
