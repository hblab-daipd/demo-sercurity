package com.security.repository;

import java.awt.Menu;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.security.entities.Menus;
import com.security.entities.Users;
@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<Users, Integer> {
public Users findByUsername(String username);
public boolean existsByUsername(String username);
public List<Users> findByUsernameContainingIgnoreCase(String username);
}
