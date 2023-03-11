package com.SistemZaPracenjeLokalnihDogadjaja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @ManyToOne()
    @JoinColumn(name = "event_id")
    private Events events;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
