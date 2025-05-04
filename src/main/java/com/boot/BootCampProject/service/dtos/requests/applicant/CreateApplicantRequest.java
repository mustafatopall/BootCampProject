package com.boot.BootCampProject.service.dtos.requests.applicant;

public record CreateApplicantRequest(String firstName, String lastName, String dateOfBirth, String nationalIdentity, String email, String password, String about) {
}
