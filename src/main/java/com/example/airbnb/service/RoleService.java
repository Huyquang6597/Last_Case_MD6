package com.example.airbnb.service;


import com.example.airbnb.model.user.Role;


public interface RoleService {
    Iterable<Role> findAll();


    void save(Role role);

    Role findByName(String name);
}
