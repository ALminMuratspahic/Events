package com.SistemZaPracenjeLokalnihDogadjaja.model;

import com.SistemZaPracenjeLokalnihDogadjaja.security.roles.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastname;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

}
