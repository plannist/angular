package com.prac.angular.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prac.angular.dao.UserEntityDao;
import com.prac.angular.entity.PhoneEntity;
import com.prac.angular.entity.UserEntity;
import com.prac.angular.model.UserVO;
import com.prac.angular.model.define.User;
import com.prac.angular.service.PhoneService;
import com.prac.angular.service.UserService;

@Controller
public class AngularController {
	@Autowired
	UserService userService;
	@Autowired
	PhoneService phoneService;
//	@Autowired
//	UserEntityDao userEntityDao;
	
	@PersistenceContext
	public EntityManager entityManager;
	
//	@Resource(name="sessionFactory")
//	private SessionFactory sessionFactory;
	
	
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
		System.out.println("entityManager 확인: "+session.isOpen());
		
		
		Criteria criteria = session.createCriteria(UserEntity.class);
		Projection projection = Projections.property("id");
		criteria.setProjection(projection);
		criteria.add(Restrictions.eq("id", id));
		List<UserEntity> list = criteria.list();
		System.out.println("criteria list확인: "+list.get(0));
		

		PhoneEntity phoneInfo = phoneService.getOne(1L);
		System.out.println("phoneInfo 확인: "+phoneInfo.toString());
		
		UserEntity userInfo = userService.getOne(1L);
		System.out.println("userInfo 확인: "+userInfo.toString());

		//Object rs = entityManager.createNamedQuery("UserEntity.selectUserInfo").setParameter("map", map).getSingleResult();
		//System.out.println("rs 확인: "+rs);
		return result;
	}
	
}
