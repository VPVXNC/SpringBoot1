package com.ilyabogatskiy.spring.springboot.spring_springboot.dao;

import com.ilyabogatskiy.spring.springboot.spring_springboot.model.Role;

import java.util.List;

public interface RoleDao {

    void saveRole(Role role);

    Role getRoleById(Long id);

    Role getRoleByName(String name);

    List<Role> getAllRoles();
}
