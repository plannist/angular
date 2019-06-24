package com.prac.angular.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prac.angular.entity.PhoneEntity;
import com.prac.angular.entity.UserEntity;

@Repository
public interface UserEntityDao extends JpaRepository<UserEntity, Long>{
//public interface UserEntityDao{
//	public List<UserEntity> findByIdLike(PhoneEntity id);
	public List<UserEntity> findByPwdEndingWith(String pwd);
	public UserEntity findById(String id);

}
