package com.prac.angular.entity;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
//@NamedQuery(name="UserEntity.selectUserInfo", query="select * from Users")
@Table(name="USERS")
@Getter
@Setter
public class UserEntity {
	
	@GeneratedValue
	@Column(name="SEQ")
	private Long seq;
	
	@Id
	@Column(name="ID")
	private String id;
	
//	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private Collection<PhoneEntity> phone;
	
	@Column(name="PWD")
	private String pwd;
	
	@Column(name="PT_DT")
	private String ptDt;
	
	@Column(name="LAST_CONNEC_DT")
	private String lastConnectDt;
	
	@Column(name="SEX")
	private String sex;
	
	public UserEntity() {
		super();
	}
}
