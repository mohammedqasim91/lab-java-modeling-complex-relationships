package com.ironhack.Lab8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private int presentationDuration;

    public Speaker(String name, int presentationDuration) {
        this.name = name;
        this.presentationDuration = presentationDuration;
    }

    public Speaker() {

    }
}
