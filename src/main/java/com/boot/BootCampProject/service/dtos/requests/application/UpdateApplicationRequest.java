package com.boot.BootCampProject.service.dtos.requests.application;

import com.boot.BootCampProject.entity.enums.ApplicationState;

public record UpdateApplicationRequest(int id, int applicantId, int bootcampId, ApplicationState state) {
}
