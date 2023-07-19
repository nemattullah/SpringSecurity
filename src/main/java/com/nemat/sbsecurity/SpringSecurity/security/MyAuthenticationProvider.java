package com.nemat.sbsecurity.SpringSecurity.security;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
		System.out.println("In Authenticate username : "+userName );
		System.out.println("In Authenticate username : "+password );
		if("tom".equals(userName) && "cruise".equals(password)) {
			System.out.println("IN IF");
			return new UsernamePasswordAuthenticationToken(userName, password, Arrays.asList());
		}else {
			System.out.println("IN ELSE");
			throw new BadCredentialsException("Invalid Username or Password");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
