package com.boot.BootCampProject.service.abstracts;

import com.boot.BootCampProject.service.dtos.requests.applicant.*;
import com.boot.BootCampProject.service.dtos.responses.applicant.*;

import java.util.List;

public interface ApplicantService {

    CreateApplicantResponse add(CreateApplicantRequest request);
    List<GetListApplicantResponse> getAll();
    UpdateApplicantResponse update(UpdateApplicantRequest request);
    void delete(int id);
    GetApplicantResponse getById(int id);


}
