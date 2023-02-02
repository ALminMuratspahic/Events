package com.SistemZaPracenjeLokalnihDogadjaja.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Entity
@Table
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int category_id;
    private String title;
    @OneToMany(mappedBy = "category")
    private Set<Events> listaOfEventsByCategory;
}
