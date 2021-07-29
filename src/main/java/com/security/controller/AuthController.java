package com.security.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entities.JwtResponse;
import com.security.entities.MenuDto;
import com.security.entities.Menus;
import com.security.entities.Users;
import com.security.jwt.utils.JwtUtils;
import com.security.repository.MenuRepository;
import com.security.repository.UserRepository;
import com.security.service.UserService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
@Autowired
private AuthenticationManager authenticationmanager;
@Autowired
private UserRepository userRepository;

@Autowired
private UserService userservice;
@Autowired
JwtUtils jwtutitls;

@PostMapping("/signin")
public String  authenticateUser(@Validated @RequestBody Users loginrequest){
	
	Authentication authentication = authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(loginrequest.getUsername(), loginrequest.getPassword()));  
	SecurityContextHolder.getContext().setAuthentication(authentication);
	String jwt=jwtutitls.generateJwtToken(authentication);
	return jwt;
			
	}

}
