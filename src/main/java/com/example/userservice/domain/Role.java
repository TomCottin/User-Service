package com.example.userservice.domain;

import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Role {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
}
