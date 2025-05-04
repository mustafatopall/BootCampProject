package com.boot.BootCampProject.service.dtos.requests.bootcamp;

import com.boot.BootCampProject.entity.enums.BootcampState;

public record CreateBootcampRequest(String name,int instructorId,String startDate,String endDate,BootcampState bootcampState) {
}
