package com.example.university.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", length = 150)
    private String fullName;

    @Column(name = "group_name", length = 20)
    private String groupName;

    @Column(name = "enrolled_year")
    private Integer enrolledYear;

    @Column(name = "email", length = 255, unique = true)
    private String email;

    @Column(name = "scholarship")
    private boolean scholarship;

    @Column(name = "created_at")
    private Instant createdAt;

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEnrolledYear() {
        return enrolledYear;
    }

    public void setEnrolledYear(Integer enrolledYear) {
        this.enrolledYear = enrolledYear;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @PrePersist
    public void onCreate() {
        createdAt = Instant.now();
    }

}

