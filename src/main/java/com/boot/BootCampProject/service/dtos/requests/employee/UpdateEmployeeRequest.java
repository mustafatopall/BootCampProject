package com.boot.BootCampProject.service.dtos.requests.employee;

public record UpdateEmployeeRequest(int id,String firstName, String lastName, String dateOfBirth, String nationalIdentity, String email, String password,String position) {
}
