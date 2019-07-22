package com.prac.angular;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
										Authentication authentication) throws IOException, ServletException {
		log.debug("loginSuccessHandler 인입 @@@@@");
		System.out.println("loginSuccessHandler 인입 @@@@@");
		HttpSession session = request.getSession();
		session.setAttribute("userId", authentication.getName());
		
		super.setDefaultTargetUrl("/");
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
