package com.prac.angular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AngularController {
	
	@RequestMapping("/index")
	public String index() {
		return "index.html";
	}
	
}
