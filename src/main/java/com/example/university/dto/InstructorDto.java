package com.example.university.dto;

public record InstructorDto(
    Long id,
    String fullName,
    String email,
    String department,
    String position
) {

}
