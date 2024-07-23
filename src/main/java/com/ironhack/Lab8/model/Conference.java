package com.ironhack.Lab8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Conference extends Event {

    @OneToMany
    private List<Speaker> speakers;

    public Conference() {

    }
}