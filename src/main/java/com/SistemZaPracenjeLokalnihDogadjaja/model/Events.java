package com.SistemZaPracenjeLokalnihDogadjaja.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    private String titleEvent;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDate;
    private String eventDetails;
    private byte[] imageEvent;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @ManyToOne
    @JoinColumn(name = "category_id ")
    private Category category;

}
