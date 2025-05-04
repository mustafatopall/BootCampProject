package com.boot.BootCampProject.service.concretes;

import com.boot.BootCampProject.entity.Blacklist;
import com.boot.BootCampProject.repository.BlacklistRepository;
import com.boot.BootCampProject.service.abstracts.BlacklistService;
import com.boot.BootCampProject.service.dtos.requests.blacklist.CreateBlacklistRequest;
import com.boot.BootCampProject.service.dtos.requests.blacklist.UpdateBlacklistRequest;
import com.boot.BootCampProject.service.dtos.responses.blacklist.CreateBlacklistResponse;
import com.boot.BootCampProject.service.dtos.responses.blacklist.GetBlacklistResponse;
import com.boot.BootCampProject.service.dtos.responses.blacklist.GetListBlacklistResponse;
import com.boot.BootCampProject.service.dtos.responses.blacklist.UpdateBlacklistResponse;
import com.boot.BootCampProject.service.mappers.blacklist.BlacklistMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlacklistServiceImpl implements BlacklistService {

    private final BlacklistRepository blacklistRepository;
    private final BlacklistMapper blacklistMapper;

    public BlacklistServiceImpl(BlacklistRepository blacklistRepository, BlacklistMapper blacklistMapper) {
        this.blacklistRepository = blacklistRepository;
        this.blacklistMapper = blacklistMapper;
    }

    @Override
    public CreateBlacklistResponse add(CreateBlacklistRequest request) {
        Blacklist blacklist = blacklistMapper.toEntity(request);
        Blacklist saved = blacklistRepository.save(blacklist);

        return blacklistMapper.toCreateResponse(saved);
    }

    @Override
    public UpdateBlacklistResponse update(UpdateBlacklistRequest request) {
        Blacklist blacklist = blacklistRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Blacklist entry not found!"));

        blacklist.setReason(request.reason());
        blacklist.setDate(request.date());
        blacklist.setApplicantId(request.applicantId());

        Blacklist updated = blacklistRepository.save(blacklist);
        return blacklistMapper.toUpdateResponse(updated);
    }

    @Override
    public void delete(int id) {
        blacklistRepository.deleteById(id);
    }

    @Override
    public GetBlacklistResponse getById(int id) {
        Blacklist blacklist = blacklistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blacklist entry not found!"));
        return blacklistMapper.toGetResponse(blacklist);
    }

    @Override
    public List<GetListBlacklistResponse> getAll() {
        List<Blacklist> blacklists = blacklistRepository.findAll();
        return blacklistMapper.toGetListResponse(blacklists);
    }
}