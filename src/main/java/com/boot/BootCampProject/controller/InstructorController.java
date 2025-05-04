package com.boot.BootCampProject.controller;

import com.boot.BootCampProject.service.abstracts.InstructorService;
import com.boot.BootCampProject.service.dtos.responses.instructor.*;
import com.boot.BootCampProject.service.dtos.requests.instructor.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public ResponseEntity<CreateInstructorResponse> add(@RequestBody CreateInstructorRequest request) {
        return ResponseEntity.ok(instructorService.add(request));
    }

    @GetMapping
    public ResponseEntity<List<GetListInstructorResponse>> getAll() {
        return ResponseEntity.ok(instructorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetInstructorResponse> getById(@PathVariable int id) {
        return ResponseEntity.ok(instructorService.getById(id));
    }

    @PutMapping
    public ResponseEntity<UpdateInstructorResponse> update(@RequestBody UpdateInstructorRequest request) {
        return ResponseEntity.ok(instructorService.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        instructorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}