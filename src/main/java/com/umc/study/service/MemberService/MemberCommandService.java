package com.umc.study.service.MemberService;

import com.umc.study.domain.Member;
import com.umc.study.web.dto.MemberRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public interface MemberCommandService {
    @Transactional
    public abstract Member joinMember(MemberRequestDTO.JoinDto request);
}
