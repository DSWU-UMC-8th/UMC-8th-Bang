package com.umc.study.web.controller;

import com.umc.study.apiPayload.ApiResponse;
import com.umc.study.service.MissionCommandService.MissionCommandService;
import com.umc.study.web.dto.MissionRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{storeId}/missions")
    public ResponseEntity<ApiResponse<Void>> createMission(
            @PathVariable Long storeId,
            @RequestBody @Valid MissionRequest request) {
        missionCommandService.createMission(storeId, request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.onSuccess(null));
    }
}
