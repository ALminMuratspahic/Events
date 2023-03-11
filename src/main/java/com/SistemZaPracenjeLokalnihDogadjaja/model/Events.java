package com.SistemZaPracenjeLokalnihDogadjaja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titleEvent;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDate;
    private String eventDetails;
    //private byte[] imageEvent;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne()
    @JoinColumn(name = "category_id ")
    private Category category;

    @OneToMany(mappedBy = "events")
    private List<Comment> comments;


}
