package com.ironhack.Lab8.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String district;

    @OneToOne
    private Member president;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL)
    private List<Member> members;



    public Chapter(String name, String district, List<Member> members, Member president) {
        this.name = name;
        this.district = district;
        this.members = members;
        this.president = president;
    }

    public Chapter() {

    }
}
