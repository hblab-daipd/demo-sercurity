//package com.security.controller;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.security.entities.Menus;
//import com.security.entities.Roles;
//import com.security.entities.Users;
//import com.security.repository.MenuRepository;
//import com.security.repository.RoleRepository;
//import com.security.repository.UserRepository;
//
//
//
//@Component
//public class DataSend implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired 
//    private PasswordEncoder passwordEncoder;
//@Autowired
//private MenuRepository menuRepository;
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent arg0) {
//        // Roles
//        if (roleRepository.findByName("ROLE_ADMIN") == null) {
//            roleRepository.save(new Roles("ROLE_ADMIN"));
//        }
//
//        if (roleRepository.findByName("ROLE_MEMBER") == null) {
//            roleRepository.save(new Roles("ROLE_MEMBER"));
//        }
//        if (roleRepository.findByName("ROLE_USER") == null) {
//            roleRepository.save(new Roles("ROLE_USER"));
//        }
//        if(menuRepository.findByMenuName("RoleManagement")==null) {
//        	menuRepository.save(new Menus("RoleManagement"));
//        }
//        if(menuRepository.findByMenuName("MenuManagement")==null) {
//        	menuRepository.save(new Menus("MenuManagement"));
//        }
//        if(menuRepository.findByMenuName("UserManagement")==null) {
//        	menuRepository.save(new Menus("UserManagement"));
//        }
//        
//
//        // Admin account
//        if (userRepository.findByUsername("admin@gmail.com") == null) {
//            Users admin = new Users();
//            admin.setUsername("admin@gmail.com");
//            admin.setPassword(passwordEncoder.encode("123456"));
//            HashSet<Roles> roles = new HashSet<>();
//            List<Menus> list=new ArrayList<>();
//            list.add(new Menus("RoleManagement"));
//            list.add(new Menus("MenuManagement"));
//            list.add(new Menus("UserManagement"));
//            
//            roles.add(roleRepository.findByName("ROLE_ADMIN"));
//            roles.add(roleRepository.findByName("ROLE_MEMBER"));
//            for(Roles rolee: roles) {
//            	rolee.setMenus(list);
//            }
//            admin.setRoles(roles.stream().collect(Collectors.toList()));
//            userRepository.save(admin);
//        }
//
//        // Member account
//        if (userRepository.findByUsername("member@gmail.com") == null) {
//            Users user = new Users();
//            user.setUsername("member@gmail.com");
//            user.setPassword(passwordEncoder.encode("123456"));
//            HashSet<Roles> roles = new HashSet<>();
//            List<Menus> list=new ArrayList<>();
//            list.add(new Menus("UserManagement"));
//            roles.add(roleRepository.findByName("ROLE_ADMIN"));
//            roles.add(roleRepository.findByName("ROLE_MEMBER"));
//            for(Roles rolee: roles) {
//            	rolee.setMenus(list);
//            }
//            roles.add(roleRepository.findByName("ROLE_MEMBER"));
//            user.setRoles(roles.stream().collect(Collectors.toList()));
//            userRepository.save(user);
//        }
//        
//        if (userRepository.findByUsername("user@gmail.com") == null) {
//            Users user = new Users();
//            user.setUsername("user@gmail.com");
//            user.setPassword(passwordEncoder.encode("123456"));
//            HashSet<Roles> roles = new HashSet<>();
//            List<Menus> list=new ArrayList<>();
//            list.add(new Menus("UserManagement"));
//            roles.add(roleRepository.findByName("ROLE_USER"));
//            for(Roles rolee: roles) {
//            	rolee.setMenus(list);
//            }
//            user.setRoles(roles.stream().collect(Collectors.toList()));
//            userRepository.save(user);
//        }
//    }
//
//}
