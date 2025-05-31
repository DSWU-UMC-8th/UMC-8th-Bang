package com.umc.study.service.ReviewCommandService;

import com.umc.study.apiPayload.code.status.ErrorStatus;
import com.umc.study.apiPayload.exception.CustomException;
import com.umc.study.domain.Member;
import com.umc.study.domain.Review;
import com.umc.study.domain.Store;
import com.umc.study.repository.MemberRepository.MemberRepository;
import com.umc.study.repository.ReviewRepository.ReviewRepository;
import com.umc.study.repository.StoreRepository.StoreRepository;
import com.umc.study.web.dto.ReviewRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewCommandService {

    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    public void createReview(Long storeId, ReviewRequest request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new CustomException(ErrorStatus.STORE_NOT_FOUND));

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new CustomException(ErrorStatus.MEMBER_NOT_FOUND));

        Review review = Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();

        reviewRepository.save(review);
    }
}

