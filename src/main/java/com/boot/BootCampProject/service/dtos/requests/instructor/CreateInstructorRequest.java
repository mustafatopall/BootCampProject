package com.boot.BootCampProject.service.dtos.requests.instructor;

public record CreateInstructorRequest(String firstName, String lastName, String dateOfBirth, String nationalIdentity, String email, String password , String companyName) {
}
