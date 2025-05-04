package com.boot.BootCampProject.service.mappers.bootcamp;


import com.boot.BootCampProject.entity.Bootcamp;

import com.boot.BootCampProject.service.dtos.responses.bootcamp.*;
import com.boot.BootCampProject.service.dtos.requests.bootcamp.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BootcampMapper {

    Bootcamp toEntity(CreateBootcampRequest request);

    CreateBootcampResponse toCreateResponse(Bootcamp bootcamp);

    UpdateBootcampResponse toUpdateResponse(Bootcamp bootcamp);

    GetBootcampResponse toGetResponse(Bootcamp bootcamp);

    List<GetListBootcampResponse> toGetListResponse(List<Bootcamp> bootcamp);
}
