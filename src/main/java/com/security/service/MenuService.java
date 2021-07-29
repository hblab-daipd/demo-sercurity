package com.security.service;

import java.util.List;

import com.security.entities.Menus;
import com.security.entities.Roles;

public interface MenuService {
	public boolean save(Menus menu);
	public boolean edit(Menus menu);
	public boolean deletebyId(int id);
	public List<Menus> findAll();
	public Menus findOne(String name);
	public List<Menus> findMenuByUsername();
	public Menus findMenuById(int id);
	
}
