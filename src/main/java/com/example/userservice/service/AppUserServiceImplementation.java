package com.example.userservice.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.userservice.domain.AppUser;
import com.example.userservice.domain.Role;
import com.example.userservice.repository.AppUserRepository;
import com.example.userservice.repository.RoleRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
// Allows dependency injection
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImplementation implements IAppUserService {

    // Warning : do not forget the final
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<AppUser> getAllAppUsers() {
        log.info("Fetching all users");
        return appUserRepository.findAll();
    }

    @Override
    public AppUser getAppUser(String username) {
        log.info("Fetching user {}", username);
        return appUserRepository.findByUsername(username);
    }

    @Override
    public AppUser saveAppUser(AppUser appUser) {
        log.info("Saving user");
        return appUserRepository.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving role");
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToAppUser(String username, String roleName) {
        log.info("Adding role : {} to user : {}", roleName, username);
        // We define the appUser according to his username
        AppUser appUser = appUserRepository.findByUsername(username);
        // We define the role to add according to his name
        Role role = roleRepository.findByName(roleName);
        // We add the new role to the existing appUser collection of roles
        appUser.getRoles().add(role);
    }
    
}
