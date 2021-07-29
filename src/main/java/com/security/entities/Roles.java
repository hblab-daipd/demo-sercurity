package com.security.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<Users> users;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_menu",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<Menus> menus;

   

	public Roles(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Roles(int id, String name, Set<Users> users, List<Menus> menus) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.menus = menus;
	}

	public Roles(String name, List<Menus> menus) {
		super();
		this.name = name;
		this.menus = menus;
	}

	public Roles(int id, String name, List<Menus> menus) {
		super();
		this.id = id;
		this.name = name;
		this.menus = menus;
	}

	public List<Menus> getMenus() {
		return menus;
	}

	public void setMenus(List<Menus> menus) {
		this.menus = menus;
	}

	public Roles() {
    }

    public Roles(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

}
