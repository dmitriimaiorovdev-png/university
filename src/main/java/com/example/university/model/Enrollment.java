
package com.example.university.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    private Course course;

    private Instant enrolledAt;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;

    private Integer grade;

    private Instant updatedAt;
}
