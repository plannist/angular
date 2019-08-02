package com.prac.angular.model;

import java.util.List;

import com.prac.angular.common.BaseVO;
import com.prac.angular.common.PaginatedList;
import com.prac.angular.entity.BuildingEntity;

import lombok.Data;

@Data
public class BuildingVO extends BaseVO{
	private PaginatedList<BuildingEntity> building;
	private List<Integer> rowNum;
}
