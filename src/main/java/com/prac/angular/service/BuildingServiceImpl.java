package com.prac.angular.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prac.angular.common.PageRequest;
import com.prac.angular.common.PaginatedList;
import com.prac.angular.common.Utils;
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
	public BuildingVO findAllByPaginated(BuildingVO vo, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		vo.setBuilding(dao.findAll(new BuildingEntity(), pageRequest));
		List<String> strDate = new ArrayList<>();
		vo.getBuilding().forEach(e -> {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
			strDate.add(format.format(e.getBuRdate()));
		});
		vo.setRegDate(strDate);
		vo.setRowNum(Utils.getRowNumber(vo));
		return vo;
	}
}
