package com.boot.BootCampProject.service.dtos.requests.bootcamp;

import com.boot.BootCampProject.entity.enums.BootcampState;

public record UpdateBootcampRequest(int id,String name, int instructorId, String startDate, String endDate,
                                    BootcampState bootcampState) {}
