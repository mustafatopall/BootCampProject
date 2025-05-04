package com.boot.BootCampProject.service.mappers.employee;

import com.boot.BootCampProject.entity.Employee;
import com.boot.BootCampProject.service.dtos.responses.employee.*;
import com.boot.BootCampProject.service.dtos.requests.employee.*;

import org.mapstruct.Mapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(CreateEmployeeRequest request);

    CreateEmployeeResponse toCreateResponse(Employee employee);

    UpdateEmployeeResponse toUpdateResponse(Employee employee);

    GetEmployeeResponse toGetResponse(Employee employee);

    List<GetListEmployeeResponse> toListResponse(List<Employee> employees);
}

