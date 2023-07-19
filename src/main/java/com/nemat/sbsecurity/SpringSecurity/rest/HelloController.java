package com.nemat.sbsecurity.SpringSecurity.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Spring Security Rocks";
	}

	@GetMapping("/bye")
	public String bye() {
		return "Get lost !!";
	}

	
	
}
