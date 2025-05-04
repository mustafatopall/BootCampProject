package com.boot.BootCampProject.service.dtos.requests.blacklist;

public record UpdateBlacklistRequest(int id,String reason,String date,int applicantId) {
}
