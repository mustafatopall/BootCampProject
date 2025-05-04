package com.boot.BootCampProject.service.dtos.responses.instructor;

public record GetInstructorResponse(int id, String firstName, String lastName,String email, String companyName) {
}
