package com.security.entities;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="menu")
public class Menus {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Column(name="menuname", nullable = false)
private String menuName;
@JsonIgnore
@ManyToMany(mappedBy = "menus")
private Set<Roles> roles;

public Menus(int id, String menuName, Set<Roles> roles) {
	super();
	this.id = id;
	this.menuName = menuName;
	this.roles = roles;
}
public Menus(String menuName, Set<Roles> roles) {
	super();
	this.menuName = menuName;
	this.roles = roles;
}
public Set<Roles> getRoles() {
	return roles;
}
public void setRoles(Set<Roles> roles) {
	this.roles = roles;
}
public Menus(String menuName) {
	super();
	this.menuName = menuName;
}
public Menus() {
	super();
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
public Menus(int id, String menuName) {
	super();
	this.id = id;
	this.menuName = menuName;
}
//public void show(String email) {
//	Set<Role> set=userrepository.findByEmail(email).getRoles();
//	String mail=userrepository.findByEmail(email).getEmail();
//	System.out.println(mail);
//	for(Role role: set)
//		System.out.println(role.getName());
//}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
	result = prime * result + ((roles == null) ? 0 : roles.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Menus other = (Menus) obj;
	if (id != other.id)
		return false;
	if (menuName == null) {
		if (other.menuName != null)
			return false;
	} else if (!menuName.equals(other.menuName))
		return false;
	if (roles == null) {
		if (other.roles != null)
			return false;
	} else if (!roles.equals(other.roles))
		return false;
	return true;
}


}
