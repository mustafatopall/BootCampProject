package com.boot.BootCampProject.service.abstracts;

import com.boot.BootCampProject.service.dtos.responses.employee.*;
import com.boot.BootCampProject.service.dtos.requests.employee.*;

import java.util.List;

public interface EmployeeService {

    CreateEmployeeResponse add(CreateEmployeeRequest request);
    List<GetListEmployeeResponse> getAll();
    UpdateEmployeeResponse update(UpdateEmployeeRequest request);
    void delete(int id);
    GetEmployeeResponse getById(int id);

}
