package com.boot.BootCampProject.service.dtos.responses.blacklist;

public record GetBlacklistResponse(int id,String reason,String date,int applicantId) {
}
