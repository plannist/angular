package com.prac.angular.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@NamedQuery(name="UserEntity.selectUserInfo", query="select * from Users")
@Table(name="USERS")
public class UserEntity implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usersSequence")
	@SequenceGenerator(name="usersSequence", sequenceName="USERS_SEQ", allocationSize=1)
	@Column(name="SEQ", columnDefinition="NUMBER")
	private Long seq;
	
	@Column(name="ID")
	private String id;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
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
