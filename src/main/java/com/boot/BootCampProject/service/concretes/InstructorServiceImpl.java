package com.boot.BootCampProject.service.concretes;

import com.boot.BootCampProject.entity.Instructor;
import com.boot.BootCampProject.repository.InstructorRespository;
import com.boot.BootCampProject.service.abstracts.InstructorService;
import com.boot.BootCampProject.service.dtos.requests.instructor.CreateInstructorRequest;
import com.boot.BootCampProject.service.dtos.requests.instructor.UpdateInstructorRequest;
import com.boot.BootCampProject.service.dtos.responses.instructor.CreateInstructorResponse;
import com.boot.BootCampProject.service.dtos.responses.instructor.GetListInstructorResponse;
import com.boot.BootCampProject.service.dtos.responses.instructor.UpdateInstructorResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRespository instructorRepository;

    public InstructorServiceImpl(InstructorRespository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public CreateInstructorResponse add(CreateInstructorRequest request) {
        Instructor instructor = new Instructor();
        instructor.setFirstName(request.getFirstName());
        instructor.setLastName(request.getLastName());
        Instructor savedInstructor = instructorRepository.save(instructor);

        CreateInstructorResponse response = new CreateInstructorResponse();
        response.setId(savedInstructor.getId());
        response.setFirstName(savedInstructor.getFirstName());
        response.setLastName(savedInstructor.getLastName());
        return response;
    }

    @Override
    public List<GetListInstructorResponse> getAll() {
        return instructorRepository.findAll().stream()
                .map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public UpdateInstructorResponse update(UpdateInstructorRequest request) {
        Instructor instructor = instructorRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        instructor.setFirstName(request.getFirstName());
        instructor.setLastName(request.getLastName());
        Instructor updatedInstructor = instructorRepository.save(instructor);

        UpdateInstructorResponse response = new UpdateInstructorResponse();
        response.setId(updatedInstructor.getId());
        response.setFirstName(updatedInstructor.getFirstName());
        response.setLastName(updatedInstructor.getLastName());
        return response;
    }

    @Override
    public void delete(int id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public GetListInstructorResponse getById(int id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        return mapToInstructorResponse(instructor);
    }

    private GetListInstructorResponse mapToResponse(Instructor instructor) {
        GetListInstructorResponse response = new GetListInstructorResponse();
        response.setId(instructor.getId());
        response.setFirstName(instructor.getFirstName());
        response.setLastName(instructor.getLastName());
        return response;
    }

    private GetListInstructorResponse mapToInstructorResponse(Instructor instructor) {
        GetListInstructorResponse response = new GetListInstructorResponse();
        response.setId(instructor.getId());
        response.setFirstName(instructor.getFirstName());
        response.setLastName(instructor.getLastName());
        return response;
    }
}