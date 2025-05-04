package com.boot.BootCampProject.service.concretes;

import com.boot.BootCampProject.entity.Application;
import com.boot.BootCampProject.repository.ApplicationRepository;
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
    private final ApplicationMapper applicationMapper;


    public ApplicationServiceImpl(ApplicationRepository applicationRepository, ApplicationMapper applicationMapper) {
        this.applicationRepository = applicationRepository;
        this.applicationMapper = applicationMapper;
    }

    @Override
    public CreateApplicationResponse add(CreateApplicationRequest request) {
        Application application = applicationMapper.toEntity(request);
        Application saved = applicationRepository.save(application);

        return applicationMapper.toCreateResponse(saved);
    }

    @Override
    public UpdateApplicationResponse update(UpdateApplicationRequest request) {
        Application application = applicationRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Application not found!"));

        application.setApplicantId(request.applicantId());
        application.setBootcampId(request.bootcampId());

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
