package com.prac.angular;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.prac.angular.entity.UserEntity;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserDetailsService userDetailService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
    public boolean supports(Class<? extends Object> authentication) {
		System.out.println("=====MyAuthenticationProvider supports() 인입");
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		UserDetails user;
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		String encodingPassword = passwordEncoder.encode(password);
		
		user = userDetailService.loadUserByUsername(username);
		UserEntity manager = (UserEntity) user;
		System.out.println("=====MyAuthenticationProvider authenticate() 인입 username:"+username+", password: "+password);
		System.out.println("=====MyAuthenticationProvider authenticate() 인입 manager 확인: "+manager.getPwd());
		
		if(passwordEncoder.matches(password, manager.getPassword())) {
			System.out.println("matches 성공");
			return new UsernamePasswordAuthenticationToken(user, encodingPassword, user.getAuthorities());
		}else {
			return null;
		}
	}
}

