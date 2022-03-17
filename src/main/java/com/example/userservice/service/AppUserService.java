package com.example.userservice.service;

import java.util.List;

import com.example.userservice.domain.AppUser;
import com.example.userservice.domain.Role;

public interface AppUserService {

    List<AppUser> getAllAppUsers();
    AppUser getAppUser(String username);
    AppUser saveAppUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToAppUser(String username, String roleName);
    
}
