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
public class PhoneEntity {
	@Id
	@GeneratedValue
	@Column(name="SEQ")
	private Long seq;
	
	@Column(name="USER_SEQ")
	private Long userSeq;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	public PhoneEntity() {
		super();
	}

	public Long getSeq() {
		return seq;
	}



	public void setSeq(Long seq) {
		this.seq = seq;
	}



	public Long getUserSeq() {
		return userSeq;
	}



	public void setUserSeq(Long userSeq) {
		this.userSeq = userSeq;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	@Override
	public String toString() {
		return "PhoneEntity [seq=" + seq + ", userSeq=" + userSeq + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
}
