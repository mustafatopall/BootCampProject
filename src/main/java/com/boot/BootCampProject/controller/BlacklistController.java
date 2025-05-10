package com.boot.BootCampProject.controller;

import com.boot.BootCampProject.service.abstracts.BlacklistService;
import com.boot.BootCampProject.service.dtos.requests.blacklist.CreateBlacklistRequest;
import com.boot.BootCampProject.service.dtos.requests.blacklist.UpdateBlacklistRequest;
import com.boot.BootCampProject.service.dtos.responses.blacklist.CreateBlacklistResponse;
import com.boot.BootCampProject.service.dtos.responses.blacklist.GetBlacklistResponse;
import com.boot.BootCampProject.service.dtos.responses.blacklist.GetListBlacklistResponse;
import com.boot.BootCampProject.service.dtos.responses.blacklist.UpdateBlacklistResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blacklist")
public class BlacklistController {

    private final BlacklistService blacklistService;

    public BlacklistController(BlacklistService blacklistService) {
        this.blacklistService = blacklistService;
    }

    @PostMapping
    public ResponseEntity<CreateBlacklistResponse> add(@RequestBody CreateBlacklistRequest request) {
        return ResponseEntity.ok(blacklistService.add(request));
    }

    @PutMapping
    public ResponseEntity<UpdateBlacklistResponse> update(@RequestBody UpdateBlacklistRequest request) {

        return ResponseEntity.ok(blacklistService.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        blacklistService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetBlacklistResponse> getById(@PathVariable int id) {
        return ResponseEntity.ok(blacklistService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<GetListBlacklistResponse>> getAll() {
        return ResponseEntity.ok(blacklistService.getAll());
    }
}