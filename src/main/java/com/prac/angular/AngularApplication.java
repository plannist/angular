package com.prac.angular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@SpringBootApplication
public class AngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularApplication.class, args);
	}
	
	@Configuration
	@Order(SecurityProperties.BASIC_AUTH_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http
			.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/**") // "/index.html", "/about.html", "contact.html")
			.permitAll()
			.and()
			.authorizeRequests()
			.antMatchers("/index.html")
			.permitAll()
			.and()
			.formLogin()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.and().csrf().disable();
			//.anyRequest()
			//.authenticated();
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder builder) throws Exception {
			builder.inMemoryAuthentication()//.passwordEncoder(encoder)
			.withUser("user").roles("USER").password("{noop}1234").and()
			.withUser("admin").roles("ADMIN").password("{noop}1234");
//			User.withDefaultPasswordEncoder().username("user").password("1234").roles("USER").build();
//			User.withDefaultPasswordEncoder().username("admin").password("1234").roles("ADMIN").build();
		}
	}

}

