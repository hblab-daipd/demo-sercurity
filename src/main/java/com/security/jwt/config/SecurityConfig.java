package com.security.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
private UserDetailsService userdetalsservice;
@Autowired
private EntryPointJwt entrypointjwt;

@Bean
public AuthenTokenFilter authenticationJwt() {
	return new AuthenTokenFilter();
}


@Override
public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws  Exception {
	authenticationManagerBuilder.userDetailsService(userdetalsservice).passwordEncoder(passwordEncoder());
}
@Bean
@Override
public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
}
@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}
@Override
protected void configure(HttpSecurity http) throws Exception {
	http.cors().and().csrf().disable().authorizeRequests().antMatchers("/auth/signin").permitAll() // Cho phép tất cả
	// mọi người
	// truy cập vào
	// 2 địa chỉ này
	.anyRequest().authenticated(); // Tất cả các request khác đều cần phải xác thực mới được truy cập

//Thêm một lớp Filter kiểm tra jwt
	 
	 http.addFilterBefore(authenticationJwt(), UsernamePasswordAuthenticationFilter.class);
}
}
