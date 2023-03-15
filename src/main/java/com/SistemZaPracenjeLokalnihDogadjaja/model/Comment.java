package com.SistemZaPracenjeLokalnihDogadjaja.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String message;

    private String dateOfComment;

    @ManyToOne()
    @JoinColumn(name = "event_id")
    private Events events;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
