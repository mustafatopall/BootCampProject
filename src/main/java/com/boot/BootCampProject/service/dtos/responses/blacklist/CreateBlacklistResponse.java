package com.boot.BootCampProject.service.dtos.responses.blacklist;

public record CreateBlacklistResponse(int id,String reason,String date,int applicantId) {
}
