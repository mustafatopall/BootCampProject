package com.boot.BootCampProject.service.concretes;

import com.boot.BootCampProject.entity.Applicant;
import com.boot.BootCampProject.repository.ApplicantRepository;
import com.boot.BootCampProject.service.abstracts.ApplicantService;
import com.boot.BootCampProject.service.dtos.requests.applicant.*;
import com.boot.BootCampProject.service.dtos.responses.applicant.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public CreateApplicantResponse add(CreateApplicantRequest request) {
        Applicant applicant = new Applicant();
        applicant.setFirstName(request.getFirstName());
        applicant.setLastName(request.getLastName());
        Applicant savedApplicant = applicantRepository.save(applicant);

        CreateApplicantResponse response = new CreateApplicantResponse();
        response.setId(savedApplicant.getId());
        response.setFirstName(savedApplicant.getFirstName());
        response.setLastName(savedApplicant.getLastName());
        return response;

    }

    @Override
    public List<GetListApplicantResponse> getAll() {
        return applicantRepository.findAll().stream()
                .map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public UpdateApplicantResponse update(UpdateApplicantRequest request) {
        Applicant applicant = applicantRepository.
                findById(request.getId()).orElseThrow(()-> new RuntimeException("Applicant not found"));
        applicant.setFirstName(request.getFirstName());
        applicant.setLastName(request.getLastName());
        Applicant updatedApplicant = applicantRepository.save(applicant);
        UpdateApplicantResponse response = new UpdateApplicantResponse();
        response.setId(updatedApplicant.getId());
        response.setFirstName(updatedApplicant.getFirstName());
        response.setLastName(updatedApplicant.getLastName());
        return response;
    }

    @Override
    public void delete(int id) {
        applicantRepository.deleteById(id);
    }

    @Override
    public GetListApplicantResponse getById(int id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        return mapToApplicantResponse(applicant);
    }

    private GetListApplicantResponse mapToResponse(Applicant applicant) {
        GetListApplicantResponse response = new GetListApplicantResponse();
        response.setId(applicant.getId());
        response.setFirstName(applicant.getFirstName());
        response.setLastName(applicant.getLastName());
        return response;
    }

    private GetListApplicantResponse mapToApplicantResponse(Applicant applicant) {
        GetListApplicantResponse response = new GetListApplicantResponse();
        response.setId(applicant.getId());
        response.setFirstName(applicant.getFirstName());
        response.setLastName(applicant.getLastName());
        return response;

    }
}
