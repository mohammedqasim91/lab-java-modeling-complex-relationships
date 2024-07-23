package com.ironhack.Lab8.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private int duration;
    private String location;
    private String title;

    @OneToMany
    private List<Guest> guests;


    public Event(LocalDate date, int duration, String location, String title, List<Guest> guests) {
        this.date = date;
        this.duration = duration;
        this.location = location;
        this.title = title;
        this.guests = guests;
    }

    public Event() {

    }
}
