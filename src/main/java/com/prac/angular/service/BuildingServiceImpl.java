package com.prac.angular.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prac.angular.common.PageRequest;
import com.prac.angular.common.PaginatedList;
import com.prac.angular.dao.BuildingEntityDao;
import com.prac.angular.dao.NamedQueryDao;
import com.prac.angular.entity.BuildingEntity;
import com.prac.angular.model.BuildingVO;

@Service
@Transactional
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	BuildingEntityDao<BuildingEntity> dao;
	@Autowired
	NamedQueryDao namedDao;
	
	@Override
	public List<BuildingEntity> findByAddress(String address) {
		return dao.findByAddress(address);
	}

	@Override
	public List<BuildingEntity> findByAddressContaining(String address) {
		return dao.findByAddressContaining(address);
	}

	@Override
	public BuildingEntity findJoinPrice() {
		return namedDao.findJoinPrice();
	}

	@Override
	public List<BuildingEntity> innerSelect(String address) {
		// TODO Auto-generated method stub
		return dao.innerSelect(address);
	}

	@Override
	public PaginatedList<BuildingEntity> findAllByPaginated(BuildingVO vo, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		int page = vo.getPage();
		return dao.findAll(new BuildingEntity(), pageRequest);
	}
}
