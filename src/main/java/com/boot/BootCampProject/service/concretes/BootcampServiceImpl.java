package com.boot.BootCampProject.service.concretes;

import com.boot.BootCampProject.entity.Bootcamp;
import com.boot.BootCampProject.repository.BootcampRepository;
import com.boot.BootCampProject.service.abstracts.BootcampService;
import com.boot.BootCampProject.service.dtos.requests.bootcamp.*;
import com.boot.BootCampProject.service.dtos.responses.bootcamp.*;
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
        // Bootcamp entity'sini request'ten dönüştürüp kaydediyoruz
        Bootcamp bootcamp = bootcampMapper.toEntity(request);
        Bootcamp savedBootcamp = bootcampRepository.save(bootcamp);
        return bootcampMapper.toCreateResponse(savedBootcamp);
    }

    @Override
    public List<GetListBootcampResponse> getAll() {
        return bootcampMapper.toGetListResponse(bootcampRepository.findAll());
    }

    @Override
    public UpdateBootcampResponse update(UpdateBootcampRequest request) {
        Bootcamp bootcamp = bootcampRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Bootcamp not found!"));

        bootcamp.setName(request.name());
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
                .orElseThrow(() -> new RuntimeException("Bootcamp not found"));
        return bootcampMapper.toGetResponse(bootcamp);
    }
}
