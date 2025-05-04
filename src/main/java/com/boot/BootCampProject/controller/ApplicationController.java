package com.boot.BootCampProject.controller;

import com.boot.BootCampProject.service.abstracts.ApplicationService;
import com.boot.BootCampProject.service.dtos.requests.application.*;
import com.boot.BootCampProject.service.dtos.responses.application.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<CreateApplicationResponse> add(@RequestBody CreateApplicationRequest request) {
        return ResponseEntity.ok(applicationService.add(request));
    }

    @PutMapping
    public ResponseEntity<UpdateApplicationResponse> update(@RequestBody UpdateApplicationRequest request) {
        return ResponseEntity.ok(applicationService.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        applicationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetApplicationResponse> getById(@PathVariable int id) {
        return ResponseEntity.ok(applicationService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<GetListApplicationResponse>> getAll() {
        return ResponseEntity.ok(applicationService.getAll());
    }
}