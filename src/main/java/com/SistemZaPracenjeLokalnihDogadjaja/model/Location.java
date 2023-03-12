package com.SistemZaPracenjeLokalnihDogadjaja.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;

    private String locationName;

    private String locationDetails;

    @Lob
    private byte[] imageData;

    @OneToMany(mappedBy = "location")
    private Set<Events> events;

}
