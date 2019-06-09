package com.prac.angular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prac.angular.entity.PhoneEntity;

@Repository
public interface PhoneEntityDao extends JpaRepository<PhoneEntity, Long>{

}
