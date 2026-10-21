package com.example.university.service;

import com.example.university.dto.CreateInstructorRequest;
import com.example.university.dto.InstructorDto;
import com.example.university.model.Instructor;
import com.example.university.repository.InstructorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    private final InstructorRepository repo;

    public InstructorService(InstructorRepository repo) {
        this.repo = repo;
    }

    public List<InstructorDto> list() {
        return repo.findAllByOrderByFullNameAsc()
                .stream()
                .map(instructor -> new InstructorDto(
                        instructor.getId(),
                        instructor.getFullName(),
                        instructor.getEmail(),
                        instructor.getDepartment(),
                        instructor.getPosition()
                ))
                .toList();
    }

    public InstructorDto get(Long id) {
        Instructor instructor = repo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Instructor not found with id: " + id
                ));

        return new InstructorDto(
                instructor.getId(),
                instructor.getFullName(),
                instructor.getEmail(),
                instructor.getDepartment(),
                instructor.getPosition()
        );
    }

    public InstructorDto create(CreateInstructorRequest r) {

            Instructor instructor = new Instructor();

            instructor.setFullName(r.fullName());
            instructor.setEmail(r.email());
            instructor.setDepartment(r.department());
            instructor.setPosition(r.position());

            Instructor saved = repo.save(instructor);

            return new InstructorDto(
                    saved.getId(),
                    saved.getFullName(),
                    saved.getEmail(),
                    saved.getDepartment(),
                    saved.getPosition()
            );
        }

@Transactional
    public InstructorDto update(Long id, CreateInstructorRequest r) {
    Instructor instructor = repo.findByIdForUpdate(id)
            .orElseThrow(() -> new RuntimeException(
                    "Instructor not found with id: " + id
            ));

    instructor.setFullName(r.fullName());
    instructor.setEmail(r.email());
    instructor.setDepartment(r.department());
    instructor.setPosition(r.position());

    Instructor saved = repo.save(instructor);

    return new InstructorDto(
            saved.getId(),
            saved.getFullName(),
            saved.getEmail(),
            saved.getDepartment(),
            saved.getPosition()
    );
    }

    public void delete(Long id) {
        Instructor instructor = repo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Instructor not found with id: " + id
                ));

        repo.delete(instructor);
    }
}