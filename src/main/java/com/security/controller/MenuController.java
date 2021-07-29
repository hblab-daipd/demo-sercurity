package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entities.Menus;
import com.security.service.MenuServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/menu")
public class MenuController {
@Autowired
private MenuServiceImpl menuService;
@GetMapping("/getAll")
@PreAuthorize("hasRole('ADMIN')")
public List<Menus> findAll(){
	return menuService.findAll();
}
//@GetMapping("/getOne/{name}")
//@PreAuthorize("hasRole('ADMIN')")
//public Menus getOne(@PathVariable("name") String name) {
//	return menuService.findOne(name);
//}
@GetMapping("/getOne/{id}")
@PreAuthorize("hasRole('USER') or hasRole('MEMBER') or hasRole('ADMIN')")
public Menus getOneById(@PathVariable("id") int id) {
	return menuService.findMenuById(id);
}
@PostMapping("/addMenu")
@PreAuthorize("hasRole('ADMIN')")
public void save(@RequestBody Menus menu) {
	try {
		menuService.save(menu);
		System.out.println( "daluu thanh cong");
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println( "khong the luu");
	}
}
 @DeleteMapping("/deleteMenu/{id}")
 @PreAuthorize("hasRole('ADMIN')")
 public void delete(@PathVariable("id") int id) {

	 try {
		menuService.deletebyId(id);
		System.out.println( "da xoa menu thanh cong");
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println( "ban khong the xoa");
		// TODO: handle exception
	}
 }
 


}
