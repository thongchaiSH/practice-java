package com.its.app.ws.mobile.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserDetailsModel {
    @NotNull(message = "First name cannot be null")
    @Size(min = 2,message = "Fitstname must not lessthan 2 char")
    private String firstName;

    @NotNull(message = "Lasname cannot be null")
    @Size(min = 2,message = "Fitstname must not lessthan 2 char")
    private String lastName;
}
