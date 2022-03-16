package com.example.userservice.controller;

import java.net.URI;
import java.util.List;

import com.example.userservice.domain.AppUser;
import com.example.userservice.domain.Role;
import com.example.userservice.service.IAppUserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
// Allows dependency injection
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AppUserController {

    private final IAppUserService AppUserService;

    @GetMapping(path = "/users")
    public ResponseEntity<List<AppUser>> getUsers() {
        return ResponseEntity.ok().body(AppUserService.getAllAppUsers());
    }

    @GetMapping(path = "/user/{username}")
    public ResponseEntity<AppUser> getUser(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(AppUserService.getAppUser(username));
    }

    @PostMapping(path = "/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser appUser) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user/save").toUriString());
        return ResponseEntity.created(uri).body(AppUserService.saveAppUser(appUser));
    }

    @PostMapping(path = "/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/role/save").toUriString());
        return ResponseEntity.created(uri).body(AppUserService.saveRole(role));
    }

    @PostMapping(path = "/role/addtouser")
    public ResponseEntity<?> saveRole(@RequestBody RoleToUserForm form) {
        AppUserService.addRoleToAppUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
