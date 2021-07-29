package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entities.Roles;
import com.security.service.RoleService;
import com.security.service.RoleServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleServiceImpl roleservice;

	@PostMapping("/addRole")
	@PreAuthorize("hasRole('ADMIN')")
	public void add(@RequestBody Roles role) {
		roleservice.save(role);
		System.out.println("ban da luu thanh cong");
	}
//	@PutMapping("/update")
//	@PreAuthorize("hasRole('ADMIN')")
//	public void update(@RequestBody Roles role) {
//		roleservice.save(role);
//		System.out.println("ban da luu thanh cong");
//	}
	@GetMapping("/getAll")
	@PreAuthorize("hasRole('USER') or hasRole('MEMBER') or hasRole('ADMIN')")
	public List<Roles> getAll() {
		return roleservice.findAll();
	}

	@GetMapping("/getOne/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Roles getOne(@PathVariable("id") int id) {
		return roleservice.findById(id);
	}

	@DeleteMapping("/deleteRole/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void delete(@PathVariable("id") int id) {
		roleservice.deletebyId(id);
	}

	@GetMapping("/getAll/{name}")
	@PreAuthorize("hasRole('ADMIN')")
	public Roles getall(@PathVariable("name") String name) {
		return roleservice.findOne(name);
	}

}
