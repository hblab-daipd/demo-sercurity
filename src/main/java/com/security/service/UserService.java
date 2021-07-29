package com.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.security.entities.Menus;
import com.security.entities.Users;

@Service
public interface UserService {
	
	
public List<Users> findByUsername(String username);
public boolean save(Users user);
public boolean edit(Users user);
public boolean deletebyId(int id);
public List<Users> getAll();
public Users getOne(String username);
public Users getById(int id);
public Users getUserLogin();
}
