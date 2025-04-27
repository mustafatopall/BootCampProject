package com.boot.BootCampProject.service.concretes;

import com.boot.BootCampProject.entity.Employee;
import com.boot.BootCampProject.repository.EmployeeRepository;
import com.boot.BootCampProject.service.abstracts.EmployeeService;
import com.boot.BootCampProject.service.dtos.requests.employee.CreateEmployeeRequest;
import com.boot.BootCampProject.service.dtos.requests.employee.UpdateEmployeeRequest;
import com.boot.BootCampProject.service.dtos.responses.employee.CreateEmployeeResponse;
import com.boot.BootCampProject.service.dtos.responses.employee.GetListEmployeeResponse;
import com.boot.BootCampProject.service.dtos.responses.employee.UpdateEmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public CreateEmployeeResponse add(CreateEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        Employee createdEmployee = employeeRepository.save(employee);

        CreateEmployeeResponse createEmployeeResponse = new CreateEmployeeResponse();
        createEmployeeResponse.setId(createdEmployee.getId());
        createEmployeeResponse.setFirstName(createdEmployee.getFirstName());
        createEmployeeResponse.setLastName(createdEmployee.getLastName());
        return createEmployeeResponse;
    }


    @Override
    public List<GetListEmployeeResponse> getAll() {
        return employeeRepository.findAll().stream()
                .map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public UpdateEmployeeResponse update(UpdateEmployeeRequest request) {
        Employee employee = employeeRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        Employee updatedEmployee = employeeRepository.save(employee);

        UpdateEmployeeResponse response = new UpdateEmployeeResponse();
        response.setId(updatedEmployee.getId());
        response.setFirstName(updatedEmployee.getFirstName());
        response.setLastName(updatedEmployee.getLastName());
        return response;
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public GetListEmployeeResponse getById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return mapToEmployeeResponse(employee);
    }

    private GetListEmployeeResponse mapToResponse(Employee employee) {
        GetListEmployeeResponse response = new GetListEmployeeResponse();
        response.setId(employee.getId());
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        return response;
    }

    private GetListEmployeeResponse mapToEmployeeResponse(Employee employee) {
        GetListEmployeeResponse response = new GetListEmployeeResponse();
        response.setId(employee.getId());
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        return response;
    }
}
