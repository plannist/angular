package com.prac.angular.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.prac.angular.entity.UserEntity;
import com.prac.angular.model.BuildingVO;
import com.prac.angular.search.BuildingSearch;
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
	public ModelAndView buildList(BuildingVO vo, HttpServletRequest request) {
		log.debug("/building 패스 인입");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("buildList");
		BuildingVO building = buildingService.findAllByPaginated(vo, vo.getPageRequest());
		mv.addObject("data", building);
		
		return mv;
	}
	
	//중요 정리 ajax에서 dataType:json 일경우 @requestBody 사용 안함. contentType : application/json 일경우 @RequestBody 붙혀야됨
	@RequestMapping("/paginatedBuildList")
	public @ResponseBody Map<String, Object> paginatedBuildList(BuildingVO vo) {
		log.debug("paginatedBuildList 인입@"+vo.getPage());
		vo = buildingService.findAllByPaginated(vo, vo.getPageRequest());
		Map<String, Object> result = new HashMap<>();
		result.put("data", vo.getBuilding().getPaginatedInfo());
		result.put("rownum", vo.getRowNum());
		result.put("regDate", vo.getRegDate());
		result.put("searchType", vo.getBuildType());
		return result;
	}
	
	@RequestMapping("/searchBuildList")
	public @ResponseBody Map<String, Object> searchBuildList(BuildingVO vo){
		Map<String, Object> result = new HashMap<>();
		vo = buildingService.findSearchByPaginated(vo, vo.getPageRequest());
		log.debug("param map 확인:"+ vo.getPage());
		return result;
	}
}
