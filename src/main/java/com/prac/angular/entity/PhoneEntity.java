package com.prac.angular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="PHONE")
public class PhoneEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="phoneSequence")
	@SequenceGenerator(name="phoneSequence", sequenceName="PHONE_SEQ", allocationSize=1)
	@Column(name="SEQ")
	private Long seq;
	
	@Column(name="USER_SEQ", columnDefinition="NUMBER", insertable=false, updatable=false)
	private Long userSeq;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="USER_SEQ", referencedColumnName="SEQ")
	@JsonIgnore
	private UserEntity users;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	public PhoneEntity() {
		super();
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
	}
	
	
	
}
