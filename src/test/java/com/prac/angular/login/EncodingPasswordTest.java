package com.prac.angular.login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class EncodingPasswordTest {
	@Autowired
	BCryptPasswordEncoder encodingPassword;
	@Autowired
	UserDetailsService userDetailsService;
	
	@Test
	public void test() {
		userDetailsService.loadUserByUsername("plannist19");
	}
}
