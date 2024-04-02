package com.skeleton.application.api.impl;

import com.skeleton.application.api.TestApi;
import com.skeleton.application.api.dto.TestApiRequestDTO;
import com.skeleton.application.api.dto.TestApiResponseDTO;
import com.skeleton.domain.aggregate.User;
import com.skeleton.domain.repository.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestApiImpl implements TestApi {

    private final UserDomainRepository userDomainRepository;

    @Override
    public TestApiResponseDTO test(TestApiRequestDTO requestDTO) {
        userDomainRepository.saveAll(List.of(new User(null, "name", "email")));
userDomainRepository.findByPage();
        return new TestApiResponseDTO();
        //        return TestApiResponseDTO.builder()
//                .code("0")
//                .message("OK")
//                .build();
    }
}
