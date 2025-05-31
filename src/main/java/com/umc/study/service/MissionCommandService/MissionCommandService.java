package com.umc.study.service.MissionCommandService;

import com.umc.study.apiPayload.code.status.ErrorStatus;
import com.umc.study.apiPayload.exception.CustomException;
import com.umc.study.domain.Mission;
import com.umc.study.domain.Store;
import com.umc.study.repository.MissionRepository.MissionRepository;
import com.umc.study.repository.StoreRepository.StoreRepository;
import com.umc.study.web.dto.MissionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    public void createMission(Long storeId, MissionRequest request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new CustomException(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = Mission.builder()
                .store(store)
                .deadline(request.getDeadline())
                .reward(request.getReward())
                .missionSpec(request.getTitle())
                .build();

        missionRepository.save(mission);
    }
}
