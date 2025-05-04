package com.boot.BootCampProject.service.dtos.responses.blacklist;

public record UpdateBlacklistResponse(int id,String reason,String date,int applicantId) {
}
