package com.boot.BootCampProject.service.dtos.responses.bootcamp;

import com.boot.BootCampProject.entity.enums.BootcampState;

public record CreateBootcampResponse(int id, String name, int instructorId, String startDate, String endDate,
                                     BootcampState bootcampState) {
}
