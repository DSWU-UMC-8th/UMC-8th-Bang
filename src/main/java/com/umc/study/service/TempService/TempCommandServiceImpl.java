package com.umc.study.service.TempService;

import com.umc.study.apiPayload.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.umc.study.apiPayload.code.status.ErrorStatus;

@Service
@RequiredArgsConstructor
public class TempCommandServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
