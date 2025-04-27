package com.boot.BootCampProject.service.abstracts;

import com.boot.BootCampProject.service.dtos.requests.instructor.CreateInstructorRequest;
import com.boot.BootCampProject.service.dtos.requests.instructor.UpdateInstructorRequest;
import com.boot.BootCampProject.service.dtos.responses.instructor.CreateInstructorResponse;
import com.boot.BootCampProject.service.dtos.responses.instructor.GetListInstructorResponse;
import com.boot.BootCampProject.service.dtos.responses.instructor.UpdateInstructorResponse;

import java.util.List;

public interface InstructorService {
    CreateInstructorResponse add(CreateInstructorRequest request);
    List<GetListInstructorResponse> getAll();
    UpdateInstructorResponse update(UpdateInstructorRequest request);
    void delete(int id);
    GetListInstructorResponse getById(int id);

}
