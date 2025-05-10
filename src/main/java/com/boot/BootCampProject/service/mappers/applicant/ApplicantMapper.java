package com.boot.BootCampProject.service.mappers.applicant;

import com.boot.BootCampProject.entity.Applicant;
import com.boot.BootCampProject.service.dtos.requests.applicant.*;
import com.boot.BootCampProject.service.dtos.responses.applicant.*;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicantMapper {

    @Mapping(target = "applications", ignore = true) // applications ilişkilendirmesini yok sayıyoruz
    Applicant toEntity(CreateApplicantRequest createApplicantRequest);

    CreateApplicantResponse toCreateResponse(Applicant applicant);

    UpdateApplicantResponse toUpdateResponse(Applicant applicant);

    GetApplicantResponse toGetResponse(Applicant applicant);

    List<GetListApplicantResponse> toGetListResponse(List<Applicant> applicants);
}
