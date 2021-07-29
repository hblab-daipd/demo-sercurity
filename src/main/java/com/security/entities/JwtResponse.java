package com.security.entities;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private List<String> roles;
	private List<MenuDto> Menus;
	public JwtResponse(String token, String username) {
		super();
		this.token = token;
		this.username = username;
	}

	public JwtResponse(String token, String username, List<MenuDto> menus) {
		super();
		this.token = token;
		this.username = username;
		
		Menus = menus;
	}
	
	public List<MenuDto> getMenus() {
		return Menus;
	}
	public void setMenus(List<MenuDto> menus) {
		Menus = menus;
	}
	
	public JwtResponse() {
		super();
	}
	public JwtResponse(String token, String type,  String username, List<String> roles) {
		super();
		this.token = token;
		this.type = type;
		
		this.username = username;
		this.roles = roles;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}