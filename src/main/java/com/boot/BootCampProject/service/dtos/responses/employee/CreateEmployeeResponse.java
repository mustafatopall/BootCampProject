package com.boot.BootCampProject.service.dtos.responses.employee;

public record CreateEmployeeResponse(int id, String firstName, String lastName, String dateOfBirth,String email,String position) {
}
