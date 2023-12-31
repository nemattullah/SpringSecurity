package com.nemat.sbsecurity.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.nemat.sbsecurity.SpringSecurity.security.MySecurityFilter;

@Configuration
public class MySecurityConfig {

	/* 
	 * Implemented MyAuthenticationProvider.java 
	 * 	which implements AuthenticationProvider
	 * 
	 * and we no longer need UserDetailsService, so commenting
	 * 
	 * */
	
//	@Bean
//	UserDetailsService userDetailsService() {
////		InMemoryUserDetailsManager(C) is an implementation of UserDetailsService 
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
////		 Create a User (Inmemory)
//		UserDetails user = User.withUsername("tom")
//				.password(passwordEncoder().encode("cruise"))
//				.authorities("read").build();
//		userDetailsService.createUser(user);
//		return userDetailsService;
//	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic();
//		http.formLogin();
		http.authorizeHttpRequests().regexMatchers("/hello").authenticated().anyRequest().denyAll();
		http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
		return http.build();
	}

}
