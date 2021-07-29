package com.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.security.entities.Menus;
import com.security.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuRepository menurepository;

	@Override
	public boolean save(Menus menu) {
		try {
			menurepository.save(menu);
			return true;
		} catch (Exception e) {
			System.out.println("khong the luu menu");
			return false;
		}

	}

	@Override
	public boolean edit(Menus menu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletebyId(int id) {
		try {
			menurepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("khong the xoa menu");
			return false;
		}
	}

	@Override
	public List<Menus> findAll() {
		return (List<Menus>) menurepository.findAll();
	}

	@Override
	public Menus findOne(String name) {
		return menurepository.findByMenuName(name);
	}

	@Override
	public List<Menus> findMenuByUsername() {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		return menurepository.findMenuByUsername(username);
	}

	@Override
	public Menus findMenuById(int id) {
		return menurepository.findById(id).get();
	}
}
