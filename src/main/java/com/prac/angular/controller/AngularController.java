package com.prac.angular.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl.Subcriteria;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prac.angular.common.Utill;
import com.prac.angular.dao.UserEntityDao;
import com.prac.angular.entity.BuildingEntity;
import com.prac.angular.entity.PhoneEntity;
import com.prac.angular.entity.PriceEntity;
import com.prac.angular.entity.UserEntity;
import com.prac.angular.model.UserVO;
import com.prac.angular.model.define.User;
import com.prac.angular.search.UserSearch;
import com.prac.angular.service.BuildingService;
import com.prac.angular.service.PhoneService;
import com.prac.angular.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AngularController {
	@Autowired
	UserService userService;
	@Autowired
	PhoneService phoneService;
	@Autowired
	BuildingService buildingService;
	@Autowired
	Utill utill;
	
	@PersistenceContext
	public EntityManager entityManager;
	
//	@Resource(name="sessionFactory")
//	private SessionFactory sessionFactory;
	
	@RequestMapping("/login.do")
	public String login() {
		return "login.html";
	}
	
	@RequestMapping(value="/loginProcess.do", method=RequestMethod.POST)
	public void loginProcess() {
		System.out.println("========= loginProcess 인입 =============");
	}
	
	@RequestMapping("/")
	public String index() {
		System.out.println("========= index 인입 =============");
		UserVO user = new UserVO();
		return "prac.html";
	}
	
	@RequestMapping("/resource")
	public @ResponseBody Map<String, Object> resource(){
		System.out.println("========= resource 인입 =============");
		Map<String, Object> map = new HashMap<>();
		map.put("id", UUID.randomUUID());
		map.put("content", "헬로 월드");
		return map;
	}
	
	@RequestMapping("/json")
	public @ResponseBody List<UserVO> json(){
		System.out.println("json 인입: !!!");
		List<UserVO> list = new ArrayList<>();
		for(int i=0; i<10; i++) {
			UserVO user = new UserVO();
			user.setId(String.valueOf(UUID.randomUUID()));
			user.setName(User.NAME.getInfo());
			user.setEmail(String.valueOf(UUID.randomUUID()));
			user.setRegDate(LocalDateTime.now());
			list.add(user);
			
		}
		System.out.println("json data 확인: "+list.get(0).getName()+", size: "+list.size());
		return list;
		
		
	}
	
	@RequestMapping(value="/login1", method=RequestMethod.POST)
	//@RequestMapping(value="/login1")
	public @ResponseBody String login(Map map) {
		System.out.println("login 인입"+map);
		List<Map<String, Object>> list = userService.getUserInfo(map);
		System.out.println("userList: "+list.get(0));
		return "";
	}
	
	@RequestMapping(value="/loginEntity", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> loginEntity(@RequestBody Map<String, Object> param){
		Map<String, Object> result = new HashMap<>();
		System.out.println("loginData 확인: "+param);
		String id = param.get("id").toString();
		
//		Session session = sessionFactory.openSession();
//		System.out.println("sessionFactory 확인: "+sessionFactory.openSession());
		Session session = (Session)entityManager.getDelegate();
		utill.println("entityManager 확인: "+session.isOpen());
		
		
		Criteria criteria = session.createCriteria(UserEntity.class);
		criteria.createAlias("phone", "phone");
		
		
		ProjectionList projection = Projections.projectionList();
		projection.add(Projections.property("seq"), "userSeq");
		projection.add(Projections.property("id"), "userId");
		projection.add(Projections.property("sex"), "userSex");
		projection.add(Projections.property("lastConnectDt"), "userLastConnectDt");
		projection.add(Projections.property("phone.phoneNumber"), "phonePhoneNumber");
		
		
		criteria.setProjection(projection);
		criteria.add(Restrictions.eq("id", id));
		criteria.setResultTransformer(Transformers.aliasToBean(UserSearch.class));
		List<UserSearch> list = criteria.list();
		utill.println("확인:"+list.get(0).toString());

		Long seq = list.get(0).getUserSeq();
		

		PhoneEntity phoneInfo = phoneService.getOne(seq);
		utill.println("phoneInfo 확인: "+phoneInfo.toString());
		
		//아래로직 기본적으로 user클래스 내의phoneEntity에 셋팅되서 리턴됨 단 쿼리문 2개 날림 where seq 로 users table과 phone table 2번 날림
		UserEntity userInfo = userService.getOne(seq);
		utill.println("userInfo 확인: "+userInfo.toString());

		//Object rs = entityManager.createNamedQuery("UserEntity.selectUserInfo").setParameter("map", map).getSingleResult();
		//System.out.println("rs 확인: "+rs);
		return result;
	}
	
	@RequestMapping("/building")
	public @ResponseBody List<BuildingEntity> building(@RequestBody String address){
		System.out.println("building 인입 address: "+address);
		
		//문제점 리턴시 building 내에 price있고 price 내에 building있고 무한반복됨
		//해결 방법 2가지 
		//1. entity 내의 조인된 다른 entity 내의 foreign key 컬럼 에 @jsonIgnore 설정.
		//2. 통합된 vo 클래스 생성후 리턴.
		List<BuildingEntity> building = buildingService.findByAddressContaining(address);
		
		//namedQuery 만의 문법이 존재 한다. 하.. native query가 아니다.
		BuildingEntity namedQuery = buildingService.findJoinPrice();
		System.out.println(namedQuery.toString());
		
		//customDao 접근
		List<BuildingEntity> inner = buildingService.innerSelect(address);
		return building;
	}
	
	@RequestMapping("/joinProcess")
	public @ResponseBody UserEntity joinProcess(UserEntity vo) {
		log.debug("vo확인 :", vo);
		return vo;
	}
	
}
