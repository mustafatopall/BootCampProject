package com.boot.BootCampProject.service.mappers.instructor;

import com.boot.BootCampProject.entity.Instructor;
import com.boot.BootCampProject.service.dtos.requests.instructor.*;
import com.boot.BootCampProject.service.dtos.responses.instructor.*;

import org.mapstruct.Mapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    Instructor toEntity(CreateInstructorRequest request);

    CreateInstructorResponse toCreateResponse(Instructor instructor);

    UpdateInstructorResponse toUpdateResponse(Instructor instructor);

    GetInstructorResponse toGetResponse(Instructor instructor);

    List<GetListInstructorResponse> toGetListResponse(List<Instructor> instructors);


}
