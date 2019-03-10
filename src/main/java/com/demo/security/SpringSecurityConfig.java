package com.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	// Create 2 users for demo
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER")
		.and().withUser("admin").password("{noop}password").roles("USER", "ADMIN");

	}

	// Secure the endpoins with HTTP Basic authentication
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				// HTTP Basic authentication
				.httpBasic().and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/user/**").hasRole("USER")
				.antMatchers(HttpMethod.POST, "/user").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/user/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.PATCH, "/user/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/user/**").hasRole("ADMIN")
				
				.and().csrf().disable().formLogin()
				
				.disable();
		http.authorizeRequests().antMatchers("/console/**").permitAll().and().csrf().disable();
		http.headers().frameOptions().disable();
	}

}