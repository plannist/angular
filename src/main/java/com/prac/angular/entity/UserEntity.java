package com.prac.angular.entity;

import java.util.ArrayList;
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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
//@NamedQuery(name="UserEntity.selectUserInfo", query="select * from Users")
@Table(name="USERS")
public class UserEntity implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="SEQ")
	private Long seq;
	
	@Column(name="ID")
	private String id;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="USER_SEQ")
	private Collection<PhoneEntity> phone;
	
	@Column(name="PWD")
	private String pwd;
	
	@Column(name="PT_DT")
	private String ptDt;
	
	@Column(name="LAST_CONNEC_DT")
	private String lastConnectDt;
	
	@Column(name="SEX")
	private String sex;
	
	@Column(name="AUTH")
	private String auth;
	
	public UserEntity() {
		super();
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Collection<PhoneEntity> getPhone() {
		return phone;
	}

	public void setPhone(Collection<PhoneEntity> phone) {
		this.phone = phone;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPtDt() {
		return ptDt;
	}

	public void setPtDt(String ptDt) {
		this.ptDt = ptDt;
	}

	public String getLastConnectDt() {
		return lastConnectDt;
	}

	public void setLastConnectDt(String lastConnectDt) {
		this.lastConnectDt = lastConnectDt;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
	}

	//Implements for UserDetails
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		ArrayList<GrantedAuthority> authorize = new ArrayList<>();
		authorize.add(new SimpleGrantedAuthority(auth));
		return authorize;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.pwd;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
