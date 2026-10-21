package com.example.university.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String fullName;

    @Column(unique = true)
    private String email;

    private String department;

    private String position;

    private LocalDate hiredAt;

    @CreationTimestamp
    private Instant createdAt;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;
}



