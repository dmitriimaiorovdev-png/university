package com.example.university.repository;


import com.example.university.model.Instructor;
import jakarta.persistence.LockModeType;
import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    Optional<Instructor> findByEmailIgnoreCase(String email);

    List<Instructor> findByDepartmentIgnoreCase(String d);

    List<Instructor> findAllByOrderByFullNameAsc();

    boolean existsByEmailIgnoreCase(String email);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT i FROM Instructor i WHERE i.id = :id")
    Optional<Instructor> findByIdForUpdate(@Param("id") Long id);
}
