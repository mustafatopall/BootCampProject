package com.boot.BootCampProject.service.mappers.blacklist;


import com.boot.BootCampProject.entity.Blacklist;
import com.boot.BootCampProject.service.dtos.requests.blacklist.*;
import com.boot.BootCampProject.service.dtos.responses.blacklist.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlacklistMapper {

    Blacklist toEntity(CreateBlacklistRequest request);

    CreateBlacklistResponse toCreateResponse(Blacklist blacklist);

    UpdateBlacklistResponse toUpdateResponse(Blacklist blacklist);

    GetBlacklistResponse toGetResponse(Blacklist blacklist);

    List<GetListBlacklistResponse> toGetListResponse(List<Blacklist> blacklists);
}
