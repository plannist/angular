package com.prac.angular;

import java.io.Serializable;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class MyAuthenticationProvider implements AuthenticationProvider, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public boolean supports(Class<? extends Object> authentication) {
		System.out.println("=====MyAuthenticationProvider supports() 인입");
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("=====MyAuthenticationProvider authenticate() 인입");
		return null;
	}



    // ...
}
