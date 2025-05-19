package com.umc.study.web.controller;

import com.umc.study.service.StoreCommandService.StoreCommandService;
import com.umc.study.web.dto.StoreRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreCommandService storeCommandService;

    @PostMapping
    public ResponseEntity<?> addStore(@RequestParam String region,
                                      @Valid @RequestBody StoreRequestDTO.Create request) {
        storeCommandService.createStore(region, request);
        return ResponseEntity.ok("가게가 성공적으로 등록되었습니다.");
    }
}

