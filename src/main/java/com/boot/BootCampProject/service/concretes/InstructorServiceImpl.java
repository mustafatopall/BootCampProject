package com.boot.BootCampProject.service.concretes;

import com.boot.BootCampProject.entity.Instructor;
import com.boot.BootCampProject.repository.InstructorRespository;
import com.boot.BootCampProject.service.abstracts.InstructorService;
import com.boot.BootCampProject.service.dtos.requests.instructor.CreateInstructorRequest;
import com.boot.BootCampProject.service.dtos.requests.instructor.UpdateInstructorRequest;
import com.boot.BootCampProject.service.dtos.responses.instructor.CreateInstructorResponse;
import com.boot.BootCampProject.service.dtos.responses.instructor.GetInstructorResponse;
import com.boot.BootCampProject.service.dtos.responses.instructor.GetListInstructorResponse;
import com.boot.BootCampProject.service.dtos.responses.instructor.UpdateInstructorResponse;
import com.boot.BootCampProject.service.mappers.instructor.InstructorMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRespository instructorRepository;
    private final InstructorMapper instructorMapper;

    public InstructorServiceImpl(InstructorRespository instructorRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }

    @Override
    public CreateInstructorResponse add(CreateInstructorRequest request) {
        Instructor instructor = instructorMapper.toEntity(request);
        Instructor saved = instructorRepository.save(instructor);

        return instructorMapper.toCreateResponse(saved);
    }

    @Override
    public List<GetListInstructorResponse> getAll() {
        return instructorMapper.toGetListResponse(instructorRepository.findAll());
    }

    @Override
    public UpdateInstructorResponse update(UpdateInstructorRequest request) {
       Instructor instructor = instructorRepository.findById(request.id())
               .orElseThrow(() -> new RuntimeException("Instructor not found!!!"));

       instructor.setFirstName(request.firstName());
       instructor.setLastName(request.lastName());
       instructor.setEmail(request.email());
       instructor.setCompanyName(request.companyName());

       Instructor saved = instructorRepository.save(instructor);

       return instructorMapper.toUpdateResponse(saved);

    }

    @Override
    public void delete(int id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public GetInstructorResponse getById(int id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found!!!"));
        return instructorMapper.toGetResponse(instructor);
    }
}