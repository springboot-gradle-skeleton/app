package com.skeleton.application.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "测试接口应答对象")
public class TestApiResponseDTO {
    @Schema(description = "应答代码")
    private String code;
    @Schema(description = "应答消息")
    private String message;
}
