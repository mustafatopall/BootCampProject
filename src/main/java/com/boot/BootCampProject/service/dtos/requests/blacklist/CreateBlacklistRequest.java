package com.boot.BootCampProject.service.dtos.requests.blacklist;

public record CreateBlacklistRequest(String reason,String date,int applicantId) {
}
