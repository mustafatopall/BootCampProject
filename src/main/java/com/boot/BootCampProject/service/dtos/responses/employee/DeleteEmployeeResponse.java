package com.boot.BootCampProject.service.dtos.responses.employee;

public class DeleteEmployeeResponse {
    private int id;

    public DeleteEmployeeResponse() {}

    public DeleteEmployeeResponse(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
