package com.boot.BootCampProject.controller;

import com.boot.BootCampProject.service.abstracts.EmployeeService;
import com.boot.BootCampProject.service.dtos.requests.employee.CreateEmployeeRequest;
import com.boot.BootCampProject.service.dtos.requests.employee.UpdateEmployeeRequest;
import com.boot.BootCampProject.service.dtos.responses.employee.CreateEmployeeResponse;
import com.boot.BootCampProject.service.dtos.responses.employee.GetListEmployeeResponse;
import com.boot.BootCampProject.service.dtos.responses.employee.UpdateEmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<CreateEmployeeResponse> add(@RequestBody CreateEmployeeRequest request) {
        return ResponseEntity.ok(employeeService.add(request));
    }

    @GetMapping
    public ResponseEntity<List<GetListEmployeeResponse>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetListEmployeeResponse> getById(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @PutMapping
    public ResponseEntity<UpdateEmployeeResponse> update(@RequestBody UpdateEmployeeRequest request) {
        return ResponseEntity.ok(employeeService.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}