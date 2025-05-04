package com.boot.BootCampProject.service.concretes;

import com.boot.BootCampProject.entity.Applicant;
import com.boot.BootCampProject.repository.ApplicantRepository;
import com.boot.BootCampProject.service.abstracts.ApplicantService;
import com.boot.BootCampProject.service.dtos.requests.applicant.*;
import com.boot.BootCampProject.service.dtos.responses.applicant.*;
import com.boot.BootCampProject.service.mappers.applicant.ApplicantMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final ApplicantMapper applicantMapper;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository, ApplicantMapper applicantMapper) {
        this.applicantRepository = applicantRepository;
        this.applicantMapper = applicantMapper;
    }

    @Override
    public CreateApplicantResponse add(CreateApplicantRequest request) {
        Applicant applicant = applicantMapper.toEntity(request);
        Applicant savedApplicant = applicantRepository.save(applicant);
        return applicantMapper.toCreateResponse(savedApplicant);
    }

    @Override
    public List<GetListApplicantResponse> getAll() {
        return applicantMapper.toGetListResponse(applicantRepository.findAll());
    }

    @Override
    public UpdateApplicantResponse update(UpdateApplicantRequest request) {
        Applicant applicant = applicantRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Applicant not found!!"));

        applicant.setFirstName(request.firstName());
        applicant.setLastName(request.lastName());
        applicant.setEmail(request.email());
        applicant.setAbout(request.about());

        Applicant updated = applicantRepository.save(applicant);
        return applicantMapper.toUpdateResponse(updated);

    }

    @Override
    public void delete(int id) {
        applicantRepository.deleteById(id);
    }

    @Override
    public GetApplicantResponse getById(int id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        return applicantMapper.toGetResponse(applicant);
    }

}
