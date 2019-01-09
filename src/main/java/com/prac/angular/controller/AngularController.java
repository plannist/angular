package com.prac.angular.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prac.angular.model.UserVO;

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
	
}
