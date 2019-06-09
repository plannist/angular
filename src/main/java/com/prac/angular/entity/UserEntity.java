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
import javax.persistence.Table;

import lombok.Data;

@Entity
//@NamedQuery(name="UserEntity.selectUserInfo", query="select * from Users")
@Table(name="USERS")
@Data
public class UserEntity {
	@Id
	@GeneratedValue
	@Column(name="SEQ")
	private Long seq;
	
//	@Column(name="ID")
//	private String id;
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="ID")
	private Collection<PhoneEntity> phone;
	
	@Column(name="PWD")
	private String pwd;
	
	@Column(name="PT_DT")
	private Timestamp ptDt;
	
	@Column(name="LAST_CONNEC_DT")
	private Timestamp lastConnectDt;
	
	@Column(name="SEX")
	private String sex;
	
	public UserEntity() {
		super();
	}
}
