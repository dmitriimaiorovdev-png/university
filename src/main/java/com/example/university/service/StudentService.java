package com.example.university.service;

import com.example.university.model.Student;
import com.example.university.repository.StudentRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
    	 return studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                 HttpStatus.NOT_FOUND, "Student not found with id: " + id));
    }

    public void deleteStudent(Long id) {
    	if (!studentRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Cannot delete. Student not found with id: " + id
            );
    	}
    	///
    }

    public Student updateStudent(Long id, Student updatedStudent) {
    	 Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional == null) {
        	throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Student not found with id: " + id);
        }

        Student student = studentOptional.get();

        student.setFullName(updatedStudent.getFullName());
        student.setEmail(updatedStudent.getEmail());
        student.setGroupName(updatedStudent.getGroupName());
        student.setEnrolledYear(updatedStudent.getEnrolledYear());
        student.setScholarship(updatedStudent.isScholarship());

        return studentRepository.save(student);
    }

}