package com.boot.BootCampProject.service.concretes;

import com.boot.BootCampProject.entity.Instructor;
import com.boot.BootCampProject.repository.InstructorRepository;
import com.boot.BootCampProject.service.abstracts.InstructorService;
import com.boot.BootCampProject.service.dtos.requests.instructor.*;
import com.boot.BootCampProject.service.dtos.responses.instructor.*;
import com.boot.BootCampProject.service.mappers.instructor.InstructorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    public InstructorServiceImpl(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }

    @Override
    public CreateInstructorResponse add(CreateInstructorRequest request) {
        Instructor instructor = instructorMapper.toEntity(request);
        Instructor savedInstructor = instructorRepository.save(instructor);
        return instructorMapper.toCreateResponse(savedInstructor);
    }

    @Override
    public List<GetListInstructorResponse> getAll() {
        return instructorMapper.toGetListResponse(instructorRepository.findAll());
    }

    @Override
    public UpdateInstructorResponse update(UpdateInstructorRequest request) {
        Instructor instructor = instructorRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Instructor not found!"));

        instructor.setFirstName(request.firstName());
        instructor.setLastName(request.lastName());
        instructor.setEmail(request.email());
        instructor.setCompanyName(request.companyName());

        Instructor updated = instructorRepository.save(instructor);
        return instructorMapper.toUpdateResponse(updated);
    }

    @Override
    public void delete(int id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public GetInstructorResponse getById(int id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        return instructorMapper.toGetResponse(instructor);
    }
}
