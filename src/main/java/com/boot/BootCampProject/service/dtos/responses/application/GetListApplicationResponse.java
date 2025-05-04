package com.boot.BootCampProject.service.dtos.responses.application;

import com.boot.BootCampProject.entity.enums.ApplicationState;

public record GetListApplicationResponse(
        int id,
        int applicantId,
        int bootcampId,
        ApplicationState state
) {}