package com.boot.BootCampProject.controller;

import com.boot.BootCampProject.service.abstracts.BootcampService;
import com.boot.BootCampProject.service.dtos.requests.bootcamp.CreateBootcampRequest;
import com.boot.BootCampProject.service.dtos.requests.bootcamp.UpdateBootcampRequest;
import com.boot.BootCampProject.service.dtos.responses.bootcamp.CreateBootcampResponse;
import com.boot.BootCampProject.service.dtos.responses.bootcamp.GetBootcampResponse;
import com.boot.BootCampProject.service.dtos.responses.bootcamp.GetListBootcampResponse;
import com.boot.BootCampProject.service.dtos.responses.bootcamp.UpdateBootcampResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bootcamps")
public class BootcampController {

    private final BootcampService bootcampService;

    public BootcampController(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }

    @PostMapping
    public ResponseEntity<CreateBootcampResponse> add(@RequestBody CreateBootcampRequest request) {
        return ResponseEntity.ok(bootcampService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateBootcampResponse> update(@PathVariable int id, @RequestBody UpdateBootcampRequest request) {
        request.setId(id);
        return ResponseEntity.ok(bootcampService.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        bootcampService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetBootcampResponse> getById(@PathVariable int id) {
        return ResponseEntity.ok(bootcampService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<GetListBootcampResponse>> getAll() {
        return ResponseEntity.ok(bootcampService.getAll());
    }
}