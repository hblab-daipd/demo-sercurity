package com.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.security.entities.Roles;
@Repository
public interface RoleRepository extends CrudRepository<Roles, Integer> {
public Roles findByName(String name);
}
