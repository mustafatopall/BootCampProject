package com.boot.BootCampProject.service.abstracts;

import com.boot.BootCampProject.service.dtos.requests.blacklist.*;
import com.boot.BootCampProject.service.dtos.responses.blacklist.*;

import java.util.List;

public interface BlacklistService {

    CreateBlacklistResponse add(CreateBlacklistRequest request);
    UpdateBlacklistResponse update(UpdateBlacklistRequest request);
    void delete(int id);
    GetBlacklistResponse getById(int id);
    List<GetListBlacklistResponse> getAll();
}