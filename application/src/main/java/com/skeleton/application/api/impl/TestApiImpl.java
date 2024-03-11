package com.skeleton.application.api.impl;

import com.skeleton.application.api.TestApi;
import com.skeleton.application.api.dto.TestApiRequestDTO;
import com.skeleton.framework.exception.BusinessException;
import com.skeleton.application.api.dto.TestApiResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestApiImpl implements TestApi {
    @Override
    public TestApiResponseDTO test(TestApiRequestDTO requestDTO) {
        throw new BusinessException("test");
//        return TestApiResponseDTO.builder()
//                .code("0")
//                .message("OK")
//                .build();
    }
}
