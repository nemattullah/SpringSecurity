# SpringSecurity

Here, Authentication is happening @MyAuthenticationProvider.authenticate() instead of @MySecurityConfig.UserDetailsService().


**Form Based Login**
	MySecurityConfig.filterChain().
		=> 	http.formLogin();
		we typically use form login for Web applications, more that Restful endpoints.
		
	login In using Web Browser.


		
		
 