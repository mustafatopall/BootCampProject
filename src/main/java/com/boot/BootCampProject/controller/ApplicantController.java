package com.boot.BootCampProject.controller;

import com.boot.BootCampProject.service.abstracts.ApplicantService;
import com.boot.BootCampProject.service.dtos.responses.applicant.*;
import com.boot.BootCampProject.service.dtos.requests.applicant.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping
    public ResponseEntity<CreateApplicantResponse> add(@RequestBody CreateApplicantRequest request) {
        return ResponseEntity.ok(applicantService.add(request));
    }

    @GetMapping
    public ResponseEntity<List<GetListApplicantResponse>> getAll() {
        return ResponseEntity.ok(applicantService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetApplicantResponse> getById(@PathVariable int id) {
        return ResponseEntity.ok(applicantService.getById(id));
    }

    @PutMapping
    public ResponseEntity<UpdateApplicantResponse> update(@RequestBody UpdateApplicantRequest request) {
        return ResponseEntity.ok(applicantService.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        applicantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}