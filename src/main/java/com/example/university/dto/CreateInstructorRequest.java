package com.example.university.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateInstructorRequest(
        @NotBlank String fullName,
        @Email String email,
        String department,
        String position) {
}
