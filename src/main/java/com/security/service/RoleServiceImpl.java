package com.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.entities.Roles;
import com.security.repository.RoleRepository;
@Service
public class RoleServiceImpl implements RoleService {
@Autowired
private RoleRepository roleRepository;
	@Override
	public boolean save(Roles role) {
		try {
			roleRepository.save(role);
			return true;
		} catch (Exception e) {
			System.out.println("khong the luu Role");
			return false;
		}
	}

	

	@Override
	public boolean deletebyId(int id) {
		try {
			roleRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println("khong the xoa role");
			return false;
		}
		
	}

	@Override
	public List<Roles> findAll() {
		// TODO Auto-generated method stub
		return (List<Roles>) roleRepository.findAll();
	}

	@Override
	public Roles findOne(String name) {
		// TODO Auto-generated method stub
		return roleRepository.findByName(name);
	}

	@Override
	public Roles findById(int id) {
		return roleRepository.findById(id).get();
	}



	@Override
	public boolean edit(Roles role) {
		// TODO Auto-generated method stub
		return false;
	}

}
