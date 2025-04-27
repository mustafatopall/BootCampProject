package com.boot.BootCampProject.service.abstracts;

import com.boot.BootCampProject.service.dtos.requests.employee.CreateEmployeeRequest;
import com.boot.BootCampProject.service.dtos.requests.employee.UpdateEmployeeRequest;
import com.boot.BootCampProject.service.dtos.responses.employee.CreateEmployeeResponse;
import com.boot.BootCampProject.service.dtos.responses.employee.GetListEmployeeResponse;
import com.boot.BootCampProject.service.dtos.responses.employee.UpdateEmployeeResponse;

import java.util.List;

public interface EmployeeService {

    CreateEmployeeResponse add(CreateEmployeeRequest request);
    List<GetListEmployeeResponse> getAll();
    UpdateEmployeeResponse update(UpdateEmployeeRequest request);
    void delete(int id);
    GetListEmployeeResponse getById(int id);

}
