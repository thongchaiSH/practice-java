package com.spring.elk.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseBo {
    private String status;
    private String message;
}
