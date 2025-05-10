package com.boot.BootCampProject.service.mappers.application;

import com.boot.BootCampProject.entity.Application;
import com.boot.BootCampProject.service.dtos.requests.application.*;
import com.boot.BootCampProject.service.dtos.responses.application.*;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    // CreateApplicationRequest'ten Application entity'sine dönüşüm
    @Mapping(target = "applicant.id", source = "request.applicantId")
    @Mapping(target = "bootcamp.id", source = "request.bootcampId")
    Application toEntity(CreateApplicationRequest request);

    // Application entity'sinden CreateApplicationResponse'a dönüşüm
    CreateApplicationResponse toCreateResponse(Application application);

    // Application entity'sinden UpdateApplicationResponse'a dönüşüm
    UpdateApplicationResponse toUpdateResponse(Application application);

    // Application entity'sinden GetApplicationResponse'a dönüşüm
    GetApplicationResponse toGetResponse(Application application);

    // Application listesinden GetListApplicationResponse'a dönüşüm
    List<GetListApplicationResponse> toGetListResponse(List<Application> applications);
}
