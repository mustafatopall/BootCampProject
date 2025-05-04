package com.boot.BootCampProject.service.abstracts;

import com.boot.BootCampProject.service.dtos.requests.application.*;
import com.boot.BootCampProject.service.dtos.responses.application.*;

import java.util.List;

public interface ApplicationService {

    CreateApplicationResponse add(CreateApplicationRequest request);
    UpdateApplicationResponse update(UpdateApplicationRequest request);
    void delete(int id);
    GetApplicationResponse getById(int id);
    List<GetListApplicationResponse> getAll();
}