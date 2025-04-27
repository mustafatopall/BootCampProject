package com.boot.BootCampProject.service.abstracts;

import com.boot.BootCampProject.service.dtos.requests.applicant.CreateApplicantRequest;
import com.boot.BootCampProject.service.dtos.requests.applicant.UpdateApplicantRequest;
import com.boot.BootCampProject.service.dtos.responses.applicant.CreateApplicantResponse;
import com.boot.BootCampProject.service.dtos.responses.applicant.GetListApplicantResponse;
import com.boot.BootCampProject.service.dtos.responses.applicant.UpdateApplicantResponse;

import java.util.List;

public interface ApplicantService {

    CreateApplicantResponse add(CreateApplicantRequest request);
    List<GetListApplicantResponse> getAll();
    UpdateApplicantResponse update(UpdateApplicantRequest request);
    void delete(int id);
    GetListApplicantResponse getById(int id);


}
