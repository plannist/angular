package com.prac.angular;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@SpringBootApplication
@MapperScan(basePackages= {"com.prac.angular.mapper"})
public class AngularApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AngularApplication.class, args);
	}
	
	@Configuration
	@Order(SecurityProperties.BASIC_AUTH_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter{
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		@Autowired
		MyAuthenticationProvider autenticationProvider;
		
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
			.loginPage("/login")
			.loginProcessingUrl("/loginProcess")
			.usernameParameter("id")
			.passwordParameter("pwd")
			.defaultSuccessUrl("/")
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.and().csrf().disable();
			//.anyRequest()
			//.authenticated();
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder builder) throws Exception {
			//db 사용 로그인 시 호출
			//흐름 .formLogin().loginProsessing() url 요청 -> builder.authenticationProvider(autenticationProvider)
			//-> MyAuthenticationProvider -> UserDetailsServiceImpl -> 
			builder.authenticationProvider(autenticationProvider);
			
			
			/*//inmemory 사용 로그인 시 주석 해제
			builder.inMemoryAuthentication()//.passwordEncoder(encoder)
			.withUser("user").roles("USER").password("{noop}1234").and()
			.withUser("admin").roles("ADMIN").password("{noop}1234");
			*/
		}
		
		@Bean
		public BCryptPasswordEncoder bycriptPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}
	}

}

