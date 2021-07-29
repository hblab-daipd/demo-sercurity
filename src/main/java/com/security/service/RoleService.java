package com.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.security.entities.Roles;
@Service
public interface RoleService {
	public boolean save(Roles role);
	public boolean edit(Roles role);
	public boolean deletebyId(int id);
	public List<Roles> findAll();
	public Roles findOne(String name);
	public Roles findById(int id);
	
}
