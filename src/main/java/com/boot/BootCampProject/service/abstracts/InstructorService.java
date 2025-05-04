package com.boot.BootCampProject.service.abstracts;
import com.boot.BootCampProject.service.dtos.requests.instructor.*;
import com.boot.BootCampProject.service.dtos.responses.instructor.*;

import java.util.List;

public interface InstructorService {
    CreateInstructorResponse add(CreateInstructorRequest request);
    List<GetListInstructorResponse> getAll();
    UpdateInstructorResponse update(UpdateInstructorRequest request);
    void delete(int id);
    GetInstructorResponse getById(int id);

}
