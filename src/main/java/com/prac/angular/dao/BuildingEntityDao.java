<<<<<<< HEAD
package com.prac.angular.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.angular.entity.BuildingEntity;

public interface BuildingEntityDao extends JpaRepository<BuildingEntity, Long>, CustomDao {
	List<BuildingEntity>findByAddress(String address);
	List<BuildingEntity>findByAddressContaining(String address);
}
=======
package com.prac.angular.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.angular.entity.BuildingEntity;

public interface BuildingEntityDao extends JpaRepository<BuildingEntity, Long>, CustomDao {
	List<BuildingEntity>findByAddress(String address);
	List<BuildingEntity>findByAddressContaining(String address);
}
>>>>>>> branch 'master' of https://github.com/plannist/angular.git
