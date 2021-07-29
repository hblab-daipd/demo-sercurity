package com.security.entities;

public class MenuDto {
	
	private int id;
	private String menuName;
	public MenuDto(int l, String menuName) {
	
		this.id = l;
		this.menuName = menuName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
}
