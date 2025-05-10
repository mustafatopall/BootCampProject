package com.boot.BootCampProject.service.concretes;

import com.boot.BootCampProject.entity.Application;
import com.boot.BootCampProject.entity.Applicant;
import com.boot.BootCampProject.entity.Bootcamp;
import com.boot.BootCampProject.repository.ApplicationRepository;
import com.boot.BootCampProject.repository.ApplicantRepository;
import com.boot.BootCampProject.repository.BootcampRepository;
import com.boot.BootCampProject.service.abstracts.ApplicationService;
import com.boot.BootCampProject.service.dtos.requests.application.CreateApplicationRequest;
import com.boot.BootCampProject.service.dtos.requests.application.UpdateApplicationRequest;
import com.boot.BootCampProject.service.dtos.responses.application.CreateApplicationResponse;
import com.boot.BootCampProject.service.dtos.responses.application.GetApplicationResponse;
import com.boot.BootCampProject.service.dtos.responses.application.GetListApplicationResponse;
import com.boot.BootCampProject.service.dtos.responses.application.UpdateApplicationResponse;
import com.boot.BootCampProject.service.mappers.application.ApplicationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicantRepository applicantRepository;
    private final BootcampRepository bootcampRepository;
    private final ApplicationMapper applicationMapper;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository,
                                  ApplicationMapper applicationMapper,
                                  ApplicantRepository applicantRepository,
                                  BootcampRepository bootcampRepository) {
        this.applicationRepository = applicationRepository;
        this.applicationMapper = applicationMapper;
        this.applicantRepository = applicantRepository;
        this.bootcampRepository = bootcampRepository;
    }

    @Override
    public CreateApplicationResponse add(CreateApplicationRequest request) {
        Applicant applicant = applicantRepository.findById(request.applicantId())
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        Bootcamp bootcamp = bootcampRepository.findById(request.bootcampId())
                .orElseThrow(() -> new RuntimeException("Bootcamp not found"));

        Application application = new Application();
        application.setApplicant(applicant);
        application.setBootcamp(bootcamp);
        application.setApplicationState(request.state());

        Application saved = applicationRepository.save(application);
        return applicationMapper.toCreateResponse(saved);
    }

    @Override
    public UpdateApplicationResponse update(UpdateApplicationRequest request) {
        Application application = applicationRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Application not found!"));

        Applicant applicant = applicantRepository.findById(request.applicantId())
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        Bootcamp bootcamp = bootcampRepository.findById(request.bootcampId())
                .orElseThrow(() -> new RuntimeException("Bootcamp not found"));

        application.setApplicant(applicant);
        application.setBootcamp(bootcamp);
        application.setApplicationState(request.state());

        Application updated = applicationRepository.save(application);
        return applicationMapper.toUpdateResponse(updated);
    }

    @Override
    public void delete(int id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public GetApplicationResponse getById(int id) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found!"));
        return applicationMapper.toGetResponse(application);
    }

    @Override
    public List<GetListApplicationResponse> getAll() {
        List<Application> applications = applicationRepository.findAll();
        return applicationMapper.toGetListResponse(applications);
    }
}
