package com.ironhack.Lab8.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;
    private LocalDate renewalDate;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    public Member(String name, MemberStatus status, LocalDate renewalDate, Chapter chapter) {
        this.name = name;
        this.status = status;
        this.renewalDate = renewalDate;
        this.chapter = chapter;
    }

    public Member() {

    }
}