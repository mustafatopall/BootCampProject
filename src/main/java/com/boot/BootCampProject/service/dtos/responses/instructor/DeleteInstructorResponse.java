package com.boot.BootCampProject.service.dtos.responses.instructor;

public class DeleteInstructorResponse {
    private int id;

    public DeleteInstructorResponse() {}

    public DeleteInstructorResponse(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
