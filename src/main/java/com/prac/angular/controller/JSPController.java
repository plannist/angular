package com.prac.angular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.prac.angular.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class JSPController {
	@RequestMapping("/userInfo")
	public String test(UserEntity vo) {
		log.debug("/userInfo 콘트롤러 인입@@@@: "+vo.toString());
		return "userInfo";
	}
}
