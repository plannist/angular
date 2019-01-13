package com.prac.angular.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prac.angular.model.UserVO;
import com.prac.angular.model.define.User;

@Controller
public class AngularController {
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("========= index 인입 =============");
		UserVO user = new UserVO();
		return "index.html";
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
	public @ResponseBody String login(@RequestBody UserVO vo) {
		System.out.println("login 인입"+vo);
		return "";
	}
	
}
