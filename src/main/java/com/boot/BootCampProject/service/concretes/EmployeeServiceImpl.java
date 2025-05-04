package com.boot.BootCampProject.service.concretes;

import com.boot.BootCampProject.entity.Employee;
import com.boot.BootCampProject.repository.EmployeeRepository;
import com.boot.BootCampProject.service.abstracts.EmployeeService;
import com.boot.BootCampProject.service.dtos.requests.employee.CreateEmployeeRequest;
import com.boot.BootCampProject.service.dtos.requests.employee.UpdateEmployeeRequest;
import com.boot.BootCampProject.service.dtos.responses.employee.CreateEmployeeResponse;
import com.boot.BootCampProject.service.dtos.responses.employee.GetEmployeeResponse;
import com.boot.BootCampProject.service.dtos.responses.employee.GetListEmployeeResponse;
import com.boot.BootCampProject.service.dtos.responses.employee.UpdateEmployeeResponse;
import com.boot.BootCampProject.service.mappers.employee.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public CreateEmployeeResponse add(CreateEmployeeRequest request) {
        Employee employee = employeeMapper.toEntity(request);
        Employee saved = employeeRepository.save(employee);

        return employeeMapper.toCreateResponse(saved);
    }

    @Override
    public List<GetListEmployeeResponse> getAll() {
       return employeeMapper.toListResponse(employeeRepository.findAll());
    }

    @Override
    public UpdateEmployeeResponse update(UpdateEmployeeRequest request) {
       Employee employee = employeeRepository.findById(request.id())
               .orElseThrow(()-> new RuntimeException("Employee Not Found"));
       employee.setFirstName(request.firstName());
       employee.setLastName(request.lastName());
       employee.setEmail(request.email());
       employee.setPosition(request.position());

       Employee updated = employeeRepository.save(employee);
       return employeeMapper.toUpdateResponse(updated);

    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public GetEmployeeResponse getById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee Not Found"));

        return employeeMapper.toGetResponse(employee);
    }
}
