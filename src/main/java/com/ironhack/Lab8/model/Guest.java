package com.ironhack.Lab8.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private ResponseStatus status;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Guest(String name, ResponseStatus status) {
        this.name = name;
        this.status = status;
    }

    public Guest() {

    }
}
