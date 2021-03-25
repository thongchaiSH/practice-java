package com.its.app.ws.mobile.ui.model.response;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    private Date timestamp;
    private String message;
}
