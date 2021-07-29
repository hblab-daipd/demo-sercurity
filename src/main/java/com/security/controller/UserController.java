package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entities.Menus;
import com.security.entities.Roles;
import com.security.entities.Users;
import com.security.service.MenuServiceImpl;
import com.security.service.RoleServiceImpl;
import com.security.service.UserServiceImpl;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private PasswordEncoder passwordencoder;
	@Autowired
	private UserServiceImpl userservice;
	@Autowired
	private MenuServiceImpl menuservice;
	@Autowired
	private RoleServiceImpl roleService;
	
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('USER') or hasRole('MEMBER') or hasRole('ADMIN')")
	public void add(@RequestBody Users user) {
		user.setPassword(passwordencoder.encode(user.getPassword()));
		userservice.save(user);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update")
	public void Update(@RequestBody Users user) {
		user.setPassword(passwordencoder.encode(user.getPassword()));
		userservice.save(user);
	}
	@PreAuthorize("hasRole('USER') or hasRole('MEMBER') or hasRole('ADMIN')")
	@GetMapping("/getMenu")
	public List<Menus> getMenu(){
		return menuservice.findMenuByUsername();
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('MEMBER') or hasRole('ADMIN')")
	@GetMapping("/getRole/{id}")
	public Roles getRoles(@PathVariable("id") int id){
		return roleService.findById(id);
	}
	@GetMapping("/getAllUser")
	@PreAuthorize("hasRole('USER') or hasRole('MEMBER') or hasRole('ADMIN')")
	public List<Users> getUser(){
		return userservice.getAll();
	}
	@GetMapping("/getUserByUsername/{username}")
	@PreAuthorize("hasRole('USER') or hasRole('MEMBER') or hasRole('ADMIN')")
	public List<Users> getUserByUsername(@PathVariable("username") String username){
		return userservice.findByUsername(username);
	}
	
	@GetMapping("/getUserById/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MEMBER') or hasRole('ADMIN')")
	public Users getUserById(@PathVariable("id") int id){
		return userservice.getById(id);
	}
	
	@GetMapping("/getUserLogin")
	@PreAuthorize("hasRole('USER') or hasRole('MEMBER') or hasRole('ADMIN')")
	public Users getUserLogin(){
		return userservice.getUserLogin();
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUser(@PathVariable("id") int id) {
		userservice.deletebyId(id);
		System.out.println( "ban da xoa thanh cong");
	}
	@GetMapping("/getOne/{username}")
	@PreAuthorize("hasRole('USER') or hasRole('MEMBER') or hasRole('ADMIN')")
	public Users getOne(@PathVariable("username") String username) {
		try {
			return userservice.getOne(username);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
