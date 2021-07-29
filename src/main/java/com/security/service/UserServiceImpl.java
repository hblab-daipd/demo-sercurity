package com.security.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.security.entities.Users;
import com.security.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepository;
	
	@Override
	public boolean save(Users user) {
		try {  
			userrepository.save(user);
			return true;
		} catch(Exception e) {
		    System.out.println("khong the luu User");
		}  
	
		return false;
	}


	@Override
	public boolean edit(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletebyId(int id) {
		try {
			userrepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println("khong the xoa User");
			return false;
		}
	}


	@Override
	public List<Users> getAll() {
		return userrepository.findAll();
	}


	@Override
	public Users getOne(String username) {
		return userrepository.findByUsername(username);
	}


	@Override
	public Users getById(int id) {
		return userrepository.findById(id).get();
	}


	@Override
	public List<Users> findByUsername(String username) {
		return userrepository.findByUsernameContainingIgnoreCase(username);
	}


	@Override
	public Users getUserLogin() {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
		    username = ((UserDetails) principal).getUsername();
		} else {
		  username = principal.toString();
		}
		return new Users(username);
	}


	


	
	

}