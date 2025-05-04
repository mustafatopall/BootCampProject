package com.boot.BootCampProject.service.mappers.application;

import com.boot.BootCampProject.entity.Application;
import com.boot.BootCampProject.service.dtos.requests.application.*;
import com.boot.BootCampProject.service.dtos.responses.application.*;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    Application toEntity(CreateApplicationRequest request);

    CreateApplicationResponse toCreateResponse(Application application);
    UpdateApplicationResponse toUpdateResponse(Application application);
    GetApplicationResponse toGetResponse(Application application);
    List<GetListApplicationResponse> toGetListResponse(List<Application> applications);
}