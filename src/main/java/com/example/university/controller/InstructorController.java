
package com.example.university.controller;

import com.example.university.dto.CreateInstructorRequest;
import com.example.university.dto.InstructorDto;
import com.example.university.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<InstructorDto> list() {
        return instructorService.list();
    }

    @GetMapping("/{id}")
    public InstructorDto get(@PathVariable Long id) {
        return instructorService.get(id);
    }

    @PostMapping
    public InstructorDto create(@Valid @RequestBody CreateInstructorRequest r) {
        return instructorService.create(r);
    }

    @PutMapping("/{id}")
    public InstructorDto update(
            @PathVariable Long id,
            @Valid @RequestBody CreateInstructorRequest r
    ) {
        return instructorService.update(id, r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        instructorService.delete(id);
    }
}
