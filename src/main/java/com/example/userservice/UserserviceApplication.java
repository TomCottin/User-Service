package com.example.userservice;

import java.util.ArrayList;

import com.example.userservice.domain.AppUser;
import com.example.userservice.domain.Role;
import com.example.userservice.service.AppUserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
    CommandLineRunner commandLineRunner(AppUserService appUserService) {
        return args -> { 
			appUserService.saveRole(new Role(null, "ROLE_USER"));
			appUserService.saveRole(new Role(null, "ROLE_MANAGER"));
			appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
			appUserService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			appUserService.saveAppUser(new AppUser(null, "Tom Cottin", "rani69", "test", new ArrayList<>()));
			appUserService.saveAppUser(new AppUser(null, "Sylvain Morand", "symorand", "test", new ArrayList<>()));
			appUserService.saveAppUser(new AppUser(null, "Maxence Perrier", "maxouloup", "test", new ArrayList<>()));
			appUserService.saveAppUser(new AppUser(null, "Nouveau Liam", "ombre69", "test", new ArrayList<>()));

			appUserService.addRoleToAppUser("rani69", "ROLE_SUPER_ADMIN");
			appUserService.addRoleToAppUser("rani69", "ROLE_ADMIN");
			appUserService.addRoleToAppUser("symorand", "ROLE_MANAGER");
			appUserService.addRoleToAppUser("symorand", "ROLE_USER");
			appUserService.addRoleToAppUser("maxouloup", "ROLE_USER");
			appUserService.addRoleToAppUser("ombre69", "ROLE_ADMIN");
		};
	}

}
