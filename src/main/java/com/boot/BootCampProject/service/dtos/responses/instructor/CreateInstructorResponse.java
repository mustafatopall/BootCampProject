package com.boot.BootCampProject.service.dtos.responses.instructor;

public record CreateInstructorResponse(int id, String firstName, String lastName, String dateOfBirth,String email, String companyName) {
}
