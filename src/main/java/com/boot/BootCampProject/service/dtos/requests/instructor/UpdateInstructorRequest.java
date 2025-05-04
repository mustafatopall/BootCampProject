package com.boot.BootCampProject.service.dtos.requests.instructor;

public record UpdateInstructorRequest(int id, String firstName, String lastName, String dateOfBirth, String nationalIdentity, String email, String password , String companyName) {
}
