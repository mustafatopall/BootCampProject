package com.boot.BootCampProject.service.dtos.responses.applicant;

public record CreateApplicantResponse(int id, String firstName, String lastName, String dateOfBirth,String email,String about) {
}
