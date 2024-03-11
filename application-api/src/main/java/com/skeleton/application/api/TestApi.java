package com.skeleton.application.api;

import com.skeleton.application.api.dto.TestApiRequestDTO;
import com.skeleton.application.api.dto.TestApiResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Tag(name = "测试接口")
public interface TestApi {
    @PostMapping("/test")
    @Operation(summary = "测试接口")
    TestApiResponseDTO test(@RequestBody @Valid TestApiRequestDTO requestDTO);
}
