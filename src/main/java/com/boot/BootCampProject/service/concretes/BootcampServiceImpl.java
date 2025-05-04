package com.boot.BootCampProject.service.concretes;

import com.boot.BootCampProject.entity.Bootcamp;
import com.boot.BootCampProject.repository.BootcampRepository;
import com.boot.BootCampProject.service.abstracts.BootcampService;
import com.boot.BootCampProject.service.dtos.requests.bootcamp.CreateBootcampRequest;
import com.boot.BootCampProject.service.dtos.requests.bootcamp.UpdateBootcampRequest;
import com.boot.BootCampProject.service.dtos.responses.bootcamp.CreateBootcampResponse;
import com.boot.BootCampProject.service.dtos.responses.bootcamp.GetBootcampResponse;
import com.boot.BootCampProject.service.dtos.responses.bootcamp.GetListBootcampResponse;
import com.boot.BootCampProject.service.dtos.responses.bootcamp.UpdateBootcampResponse;
import com.boot.BootCampProject.service.mappers.bootcamp.BootcampMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BootcampServiceImpl implements BootcampService {

    private final BootcampRepository bootcampRepository;
    private final BootcampMapper bootcampMapper;

    public BootcampServiceImpl(BootcampRepository bootcampRepository, BootcampMapper bootcampMapper) {
        this.bootcampRepository = bootcampRepository;
        this.bootcampMapper = bootcampMapper;
    }

    @Override
    public CreateBootcampResponse add(CreateBootcampRequest request) {
        Bootcamp bootcamp = bootcampMapper.toEntity(request);
        Bootcamp saved = bootcampRepository.save(bootcamp);

        return bootcampMapper.toCreateResponse(saved);
    }

    @Override
    public UpdateBootcampResponse update(UpdateBootcampRequest request) {
        Bootcamp bootcamp = bootcampRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Bootcamp not found!"));

        bootcamp.setName(request.name());
        bootcamp.setInstructorId(request.instructorId());
        bootcamp.setStartDate(request.startDate());
        bootcamp.setEndDate(request.endDate());
        bootcamp.setBootcampState(request.bootcampState());

        Bootcamp updated = bootcampRepository.save(bootcamp);
        return bootcampMapper.toUpdateResponse(updated);
    }

    @Override
    public void delete(int id) {
        bootcampRepository.deleteById(id);
    }

    @Override
    public GetBootcampResponse getById(int id) {
        Bootcamp bootcamp = bootcampRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bootcamp not found!"));
        return bootcampMapper.toGetResponse(bootcamp);
    }

    @Override
    public List<GetListBootcampResponse> getAll() {
        List<Bootcamp> bootcamps = bootcampRepository.findAll();
        return bootcampMapper.toGetListResponse(bootcamps);
    }
}