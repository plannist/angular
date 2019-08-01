package com.prac.angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prac.angular.common.PageRequest;
import com.prac.angular.common.PaginatedList;
import com.prac.angular.common.Sort;
import com.prac.angular.entity.BuildingEntity;
import com.prac.angular.entity.UserEntity;
import com.prac.angular.model.BuildingVO;
import com.prac.angular.service.BuildingService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class JSPController {
	
	@Autowired
	BuildingService buildingService;
	
	@RequestMapping("/userInfo")
	public String test(UserEntity vo) {
		log.debug("/userInfo 콘트롤러 인입@@@@: "+vo.toString());
		return "userInfo";
	}
	
	@RequestMapping("/buildList")
	public ModelAndView buildList(BuildingVO vo) {
		log.debug("/building 패스 인입");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("buildList");
//		PageRequest request = new PageRequest(1, 10);
		
		PaginatedList<BuildingEntity> building = buildingService.findAllByPaginated(vo, vo.getPageRequest());
		mv.addObject("data", building);
		return mv;
	}
}
