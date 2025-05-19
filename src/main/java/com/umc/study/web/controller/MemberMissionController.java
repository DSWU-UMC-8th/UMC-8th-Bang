package com.umc.study.web.controller;

import com.umc.study.apiPayload.ApiResponse;
import com.umc.study.service.MemberMissionCommandService.MemberMissionCommandService;
import com.umc.study.web.dto.MissionChallengeRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/{missionId}/challenge")
    public ResponseEntity<ApiResponse<Void>> challengeMission(
            @PathVariable Long missionId,
            @RequestBody @Valid MissionChallengeRequest request) {
        memberMissionCommandService.challengeMission(missionId, request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.onSuccess(null));
    }
}

