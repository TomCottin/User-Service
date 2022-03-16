package com.example.userservice.domain;

import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Table needs to be created in the database
@Entity
// Getter & Setter
@Data
// Definition of constructors
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;

    // When the user is loaded we also load all the roles
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

}
