package com.prac.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prac.angular.service.AccountBookService;

@Controller
public class AccountBookController {
	@Autowired
	private AccountBookService accoutBookService;
	
	@RequestMapping("/account/form")
	public String accountForm() {
		return "/account/form";
	}
	
	
}
