package com.boot.BootCampProject.service.abstracts;

import com.boot.BootCampProject.service.dtos.requests.bootcamp.*;
import com.boot.BootCampProject.service.dtos.responses.bootcamp.*;

import java.util.List;

public interface BootcampService {

    CreateBootcampResponse add(CreateBootcampRequest request);
    UpdateBootcampResponse update(UpdateBootcampRequest request);
    void delete(int id);
    GetBootcampResponse getById(int id);
    List<GetListBootcampResponse> getAll();
}