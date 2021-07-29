package com.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.security.entities.Menus;
@Repository
public interface MenuRepository extends CrudRepository<Menus, Integer> {
public Menus findByMenuName(String name);
@Query(value="select * from Menu where id in (Select menu_id from role_menu where role_id in (select id from Role where id in (select role_id from user_role where user_id in(select user_id from user_role where user_id =(select id from user where username=?1)))))\r\n",nativeQuery = true)
public List<Menus> findMenuByUsername(String name);

}
