package com.boot.BootCampProject.service.dtos.responses.applicant;

public class DeleteApplicantResponse {
    private int id;

    public DeleteApplicantResponse() {}

    public DeleteApplicantResponse(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
