package com.umc.study.service.StoreCommandService;

import com.umc.study.apiPayload.code.status.ErrorStatus;
import com.umc.study.apiPayload.exception.CustomException;
import com.umc.study.domain.Member;
import com.umc.study.domain.Region;
import com.umc.study.domain.Store;
import com.umc.study.repository.MemberRepository.MemberRepository;
import com.umc.study.repository.RegionRepository.RegionRepository;
import com.umc.study.repository.StoreRepository.StoreRepository;
import com.umc.study.web.dto.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoreCommandService {

    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final RegionRepository regionRepository;

    public void createStore(String regionName, StoreRequestDTO.Create request) {
        Member owner = memberRepository.findById(1L)
                .orElseThrow(() -> new CustomException(ErrorStatus.MEMBER_NOT_FOUND));

        Region region = regionRepository.findByName(regionName)
                .orElseThrow(() -> new CustomException(ErrorStatus.REGION_NOT_FOUND));

        Store store = Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();

        storeRepository.save(store);
    }
}
